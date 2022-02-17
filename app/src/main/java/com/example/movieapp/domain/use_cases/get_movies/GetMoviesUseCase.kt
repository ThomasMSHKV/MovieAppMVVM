package com.example.movieapp.domain.use_cases.get_movies

import com.example.movieapp.domain.models.Movie
import com.example.movieapp.domain.repository.MovieRepository

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    fun execute(): List<Movie> {
        return movieRepository.getMovies()
    }
}