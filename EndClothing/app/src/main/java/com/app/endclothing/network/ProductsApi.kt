package com.app.endclothing.network

import com.app.endclothing.data.model.Catalog
import com.app.endclothing.data.model.NewProducts
import retrofit2.http.GET

interface ProductsApi {
    @GET("android_test_example.json")
    suspend fun getProductList(): NewProducts

    @GET("example.json")
     suspend fun getNewArrival() : NewProducts

}