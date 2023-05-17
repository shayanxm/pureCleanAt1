package com.example.purecleanat1.model

import com.example.purecleanat1.Country
import com.example.purecleanat1.di.DaggerApiComponent
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class CountiesService {
    private val BASE_URL ="https://raw.githubusercontent.com/"
  @Inject
    lateinit var  api:CountiesApi
    init {
      DaggerApiComponent.create().inject(this)
    }
    fun getCountires(): Single<List<Country>>{
      return  api.getCountires()
    }

}