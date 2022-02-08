package com.example.movieapp.contract

import com.example.movieapp.data.network.models.MainMovieApi

interface MovieCallback {

    fun openFragment(mainMovieApi: MainMovieApi)
}