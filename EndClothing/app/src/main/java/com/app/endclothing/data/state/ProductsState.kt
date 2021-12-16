package com.app.endclothing.data.state

import com.app.endclothing.arch.IState
import com.app.endclothing.data.model.Catalog
import com.app.endclothing.data.model.NewProducts

class ProductsState(
    val newProduct: NewProducts = NewProducts(),
    val isLoading: Boolean = false,
    val errorMessage: String? = null
) : IState

