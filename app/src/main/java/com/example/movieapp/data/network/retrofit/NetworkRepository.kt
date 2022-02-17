package com.example.movieapp.data.network.retrofit

import com.example.movieapp.common.Retrofit.getRetrofitService
import com.example.movieapp.data.network.models.toMovie
import com.example.movieapp.domain.models.Movie
import com.example.movieapp.domain.repository.MovieRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class NetworkRepository : MovieRepository {

    private val compositeDisposable = CompositeDisposable()

    override fun getMovies(): List<Movie> {
        var listOfMovies = listOf<Movie>()
        compositeDisposable.add(
            getRetrofitService().getMovie()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                   listOfMovies = it.results.map { movieDto ->
                        movieDto.toMovie()
                    }
                }, {})
        )
        return listOfMovies
    }
}
