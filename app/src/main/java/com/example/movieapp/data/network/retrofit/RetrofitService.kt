package com.example.movieapp.data.network.retrofit

import com.example.movieapp.data.network.models.MovieDto
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

const val URL = "docs/movie-reviews-api/1/routes/reviews/search.json/get"

interface RetrofitService {
    @GET(URL)
    fun getMovie(): Single<MovieDto>
}