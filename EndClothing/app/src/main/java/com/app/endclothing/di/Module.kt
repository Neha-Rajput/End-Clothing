package com.app.endclothing.di

import com.app.endclothing.network.ProductsApi
import com.app.endclothing.ui.viewmodel.ProductViewModel
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://www.endclothing.com/media/catalog/"

val netModule = module {
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().build()
    }

    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(client).build()
    }

    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
}


val viewModelScope = module {
    viewModel { ProductViewModel(get()) }
}

val apiModule = module {

    fun provideUserApi(retrofit: Retrofit): ProductsApi {
        return retrofit.create(ProductsApi::class.java)
    }
    single { provideUserApi(get()) }
}