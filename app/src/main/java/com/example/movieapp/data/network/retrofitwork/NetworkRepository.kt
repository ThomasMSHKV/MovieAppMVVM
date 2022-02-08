package com.example.movieapp.data.network.retrofitwork

import com.example.movieapp.common.Retrofit.getRetrofitService

class NetworkRepository {

    fun getMovie() = getRetrofitService().getMovie()
}