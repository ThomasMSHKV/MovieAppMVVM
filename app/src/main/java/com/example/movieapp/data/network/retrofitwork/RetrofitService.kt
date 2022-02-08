package com.example.movieapp.data.network.retrofitwork

import com.example.movieapp.data.network.models.MainMovieApi
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

const val URL = "/3/movie/550?api_key=aa8434c836c0481f9d42551952129ad2"

interface RetrofitService {
    @GET(URL)
    fun getMovie():Single<MainMovieApi>
}