package com.example.purecleanat1.model

import com.example.purecleanat1.Country
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountiesService {
    private val BASE_URL ="https://raw.githubusercontent.com/"
    private val api:CountiesApi

    init {
        api= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CountiesApi::class.java)
    }
    fun getCountires(): Single<List<Country>>{
      return  api.getCountires()
    }

}