package com.example.movieapp.contract

import com.example.movieapp.data.network.models.Result

interface MovieCallback {

    fun openFragment(mainMovieApi: Result)
}