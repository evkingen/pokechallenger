package com.alohagoha.pokechallenger.network.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class PoGoRESTAPI() {

    fun getService(): PoGoServiceAPI {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pogoapi.net/")
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(PoGoServiceAPI::class.java)
    }

}