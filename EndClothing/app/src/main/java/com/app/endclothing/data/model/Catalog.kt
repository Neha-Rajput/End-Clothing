package com.app.endclothing.data.model

import com.google.gson.annotations.SerializedName
import java.util.*


data class Catalog(val products: ArrayList<Products> = ArrayList()) {
    @SerializedName("product_count") var productCount: Int = 0
    var title: String = ""
}