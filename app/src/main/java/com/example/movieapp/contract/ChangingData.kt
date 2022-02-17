package com.example.movieapp.contract

import com.example.movieapp.data.network.models.Result

interface ChangingData {
    fun setData(data: List<Result>)
    fun replaceData(data: List<Result>)
}