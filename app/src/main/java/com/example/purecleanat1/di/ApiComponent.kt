package com.example.purecleanat1.di

import com.example.purecleanat1.model.CountiesService
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent {
    fun inject(service:CountiesService)

}