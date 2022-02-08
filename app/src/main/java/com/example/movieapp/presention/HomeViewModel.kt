package com.example.movieapp.presention

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movieapp.data.network.models.MainMovieApi
import com.example.movieapp.data.network.retrofitwork.NetworkRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel() : ViewModel() {

    private val networkRepository = NetworkRepository()
    private val compositeDisposable = CompositeDisposable()

    private var _getMovieResponse = MutableLiveData<MainMovieApi>()
    val getMovieResponse: LiveData<MainMovieApi>
        get() = _getMovieResponse

    fun getMovie(){
        compositeDisposable.add(
            networkRepository.getMovie()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({_getMovieResponse.value = it}, {})
        )
    }
}