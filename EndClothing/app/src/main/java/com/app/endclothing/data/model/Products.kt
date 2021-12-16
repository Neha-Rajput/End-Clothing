package com.app.endclothing.data.model

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.app.endclothing.R
import com.squareup.picasso.Picasso

data class Products(
    val id: String,
    val image: String,
    val name: String,
    val price: String
){
    companion object DataBindingAdapter {
        @BindingAdapter("app:image_url")
        @JvmStatic
        fun loadImage(imageView: ImageView, image: String) {
            Picasso.get().load(image)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageView)        }
    }
}