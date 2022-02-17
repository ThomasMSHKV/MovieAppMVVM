package com.example.movieapp.data.network.models

import android.os.Parcelable
import com.example.movieapp.domain.models.Movie
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Result(
    val byline: String,
    val critics_pick: Int,
    val date_updated: String,
    val display_title: String,
    val headline: String,
    val link: @RawValue Link,
    val mpaa_rating: String,
    val multimedia: @RawValue Multimedia,
    val opening_date: @RawValue Any,
    val publication_date: String,
    val summary_short: String
) : Parcelable

fun Result.toMovie(): Movie {
    return Movie(
        src = this.multimedia.src,
        summary_short = this.summary_short,
        display_title = this.display_title
    )
}