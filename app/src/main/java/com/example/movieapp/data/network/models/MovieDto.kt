package com.example.movieapp.data.network.models

import android.os.Parcelable
import com.example.movieapp.domain.models.Movie
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import java.text.FieldPosition

@Parcelize
data class MovieDto(
    val copyright: String,
    val has_more: Boolean,
    val num_results: Int,
    val results: @RawValue List<Result>,
    val status: String
) : Parcelable

