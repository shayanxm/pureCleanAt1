package com.example.purecleanat1.model

import com.example.purecleanat1.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountiesApi {
    @GET("DevTides/countries/master/countriesV2.json")
    fun getCountires(): Single<List<Country>>


}