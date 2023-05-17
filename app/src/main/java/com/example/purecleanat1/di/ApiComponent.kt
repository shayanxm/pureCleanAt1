package com.example.purecleanat1.di

import androidx.lifecycle.ViewModel
import com.example.purecleanat1.model.CountiesService
import com.example.purecleanat1.viewmodel.ListViewModel
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service:CountiesService)
    fun inject(viewModel: ListViewModel)

}