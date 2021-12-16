package com.app.endclothing.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.app.endclothing.BR
import com.app.endclothing.R
import com.app.endclothing.arch.IView
import com.app.endclothing.data.intent.ProductIntent
import com.app.endclothing.data.model.Products
import com.app.endclothing.data.state.ProductsState
import com.app.endclothing.databinding.ActivityMainBinding
import com.app.endclothing.ui.adapter.ItemAdapter
import com.app.endclothing.ui.viewmodel.ProductViewModel
import com.app.endclothing.util.ConnectionLiveData
import com.app.endclothing.util.isConnected
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

class MainActivity : AppCompatActivity(), IView<ProductsState> {
    private val mAdapter = ItemAdapter()
    private val mViewModel by viewModel<ProductViewModel>()
    lateinit var binding: ActivityMainBinding
    protected lateinit var connectionLiveData: ConnectionLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        connectionLiveData = ConnectionLiveData(this)

        connectionLiveData.observe(this) {
            mViewModel.isNetworkAvailable = it
        }
        mViewModel.isNetworkAvailable = isConnected
        recyclerView.adapter = mAdapter

        // Observing the state
        mViewModel.state.observe(this, Observer {
            render(it)
        })

        if (mViewModel.isNetworkAvailable) {
            // Fetching data when the application launched
            lifecycleScope.launch {
                mViewModel.intents.send(ProductIntent.FetchProducts)
            }

            // Refresh data
            btnRefresh.setOnClickListener {
                lifecycleScope.launch {
                    mViewModel.intents.send(ProductIntent.NewArrival)
                }
            }
        } else {
            //binding.noInternet.visibility = View.VISIBLE
            Toast.makeText(this@MainActivity, "No Internet Connection", Toast.LENGTH_LONG).show()

        }
    }

    override fun render(state: ProductsState) {
        with(state) {
            state.newProduct
            progressBar.isVisible = isLoading
            btnRefresh.isEnabled = !isLoading
            val newProducts = newProduct
            val filteredList = filterList(newProduct.products)
            mAdapter.submitList(filteredList)
            binding.setVariable(BR.newProducts, newProducts)
            binding.executePendingBindings()


            if (errorMessage != null) {
                Log.e("Mainactivity", errorMessage)
                Toast.makeText(this@MainActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun filterList(products: ArrayList<Products>): ArrayList<Products> {
        val list1 = ArrayList<Products>()
        val list2 = ArrayList<Products>()
        for (item in products) {
            if (item.id.equals("2")) {
                list1.add(item)
            } else {
                list2.add(item)
            }
        }
        products.clear()
        products.addAll(0, list1)
        products.addAll(list2)
        return products
    }
}

