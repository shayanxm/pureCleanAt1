package com.example.purecleanat1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.purecleanat1.Country

/**
 * 3 var
 * liveData : anyone can acess to it in live (with subscribtion)
 *
 */
class ListViewModel:ViewModel() {

    val countries= MutableLiveData<List<Country>>()
    //true for error
    val countryLoadError = MutableLiveData<Boolean>()
//true if view model is in process of loading data from backend
    val loading = MutableLiveData<Boolean>()

    //its public and can be acessed from outside
    fun refresh(){
        fetchCountries()

    }
    private  fun fetchCountries(){
        val mockData= listOf(Country("country a"),
            Country("country a"),
            Country("country b"),
            Country("country c"),
            Country("country d"),
            Country("country f"),
            Country("country j")
        )
        countryLoadError.value=false
        loading.value=false
        countries.value=mockData


    }

}