package com.example.movieapp.domain.repository

import com.example.movieapp.domain.models.Movie

interface MovieRepository {

    fun getMovies(): List<Movie>
}