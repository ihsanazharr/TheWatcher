package com.ihsan.thewatcher.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("id")
    val id : String ?,

    @SerializedName("title")
    val title : String ?,

    @SerializedName("poster_path")
    val poster : String ?,

    @SerializedName("overview")
    val overview : String ?,

    @SerializedName("release_date")
    val releaseDate : String ?,

    @SerializedName("popularity")
    val popularity : String ?,

    @SerializedName("vote_average")
    val voteAverage : String ?

    ) : Parcelable {
    constructor() : this("", "", "", "", "", "", "")
}
