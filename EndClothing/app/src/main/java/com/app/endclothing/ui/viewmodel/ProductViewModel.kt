package com.app.endclothing.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.endclothing.arch.IModel
import com.app.endclothing.data.intent.ProductIntent
import com.app.endclothing.data.state.ProductsState
import com.app.endclothing.network.ProductsApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch


class ProductViewModel(private val productsApi: ProductsApi) : ViewModel(),
    IModel<ProductsState, ProductIntent> {
    var isNetworkAvailable: Boolean = false
    override val intents: Channel<ProductIntent> = Channel(Channel.UNLIMITED)

    private val _state = MutableLiveData<ProductsState>().apply { value = ProductsState() }
    override val state: LiveData<ProductsState>
        get() = _state

    init {
        handlerIntent()
    }

    private fun handlerIntent() {
        viewModelScope.launch {
            intents.consumeAsFlow().collect { productIntent ->
                when (productIntent) {
                    ProductIntent.FetchProducts -> fetchData()
                    ProductIntent.NewArrival -> getNewArrival()
                }
            }
        }
    }

    private suspend fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                updateState { ProductsState(isLoading = true) }
                updateState {
                    ProductsState(
                        isLoading = false, newProduct = productsApi.getProductList()
                    )
                }
            } catch (e: Exception) {
                updateState { ProductsState(isLoading = false, errorMessage = e.message) }
            }
        }
    }


    private fun getNewArrival() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                updateState { ProductsState(isLoading = true) }
                updateState {
                    ProductsState(
                        isLoading = false, newProduct = productsApi.getNewArrival()
                    )
                }
            } catch (e: Exception) {
                updateState { ProductsState(isLoading = false, errorMessage = e.message) }
            }
        }
    }


    private suspend fun updateState(handler: suspend (intent: ProductsState) -> ProductsState) {
        _state.postValue(handler(state.value!!))
    }
}