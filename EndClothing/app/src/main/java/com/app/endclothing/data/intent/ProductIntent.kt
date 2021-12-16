package com.app.endclothing.data.intent

import com.app.endclothing.arch.IIntent

sealed class ProductIntent : IIntent {
    object FetchProducts : ProductIntent()
    object NewArrival : ProductIntent()
}