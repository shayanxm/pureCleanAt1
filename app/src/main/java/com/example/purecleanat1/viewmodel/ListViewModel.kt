package com.example.purecleanat1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.purecleanat1.Country
import com.example.purecleanat1.model.CountiesService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

/**
 * 3 var
 * liveData : anyone can acess to it in live (with subscribtion)
 *
 */
class ListViewModel:ViewModel() {
private val countriesService=CountiesService()
    private val disposable=CompositeDisposable()
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
      loading.value=true

        disposable.add(
            countriesService.getCountires()
                    //create new thread and dont effec UI Thread
                .subscribeOn(Schedulers.newThread())
                //we need to interact with UI so ...
                .observeOn(AndroidSchedulers.mainThread())
                    //what we gonna do when we have datas
                .subscribeWith(object : DisposableSingleObserver<List<Country>>(){
                    override fun onSuccess(value: List<Country>?) {
                        countries.value=value
                        countryLoadError.value=false
                        loading.value=false
                    }

                    override fun onError(e: Throwable?) {
                       countryLoadError.value=true
                        loading.value=false
                    }

                })
        )

    }

    override fun onCleared() {
        //what to do we fineshed:
        super.onCleared()
        disposable.clear()
    }
}