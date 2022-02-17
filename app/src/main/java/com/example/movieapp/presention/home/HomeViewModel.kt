package com.example.movieapp.presention.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.data.network.models.MovieDto
import com.example.movieapp.data.network.retrofit.NetworkRepository
import com.example.movieapp.domain.use_cases.get_movies.GetMoviesUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel(private val getMoviesUseCase: GetMoviesUseCase) : ViewModel() {

    private var _getMovieResponse = MutableLiveData<MovieDto>()
    val getMovieResponse: LiveData<MovieDto>
        get() = _getMovieResponse

    fun getMovie() {
        getMoviesUseCase.execute()
    }
}


//        compositeDisposable.add(
//            networkRepository.getMovie()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({_getMovieResponse.value = it}, {})
//        )