package com.ihsan.thewatcher.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TV(
    @SerializedName("id")
    val id : String ?,

    @SerializedName("name")
    val name : String ?,

    @SerializedName("poster_path")
    val poster : String ?,

    @SerializedName("overview")
    val overview : String ?,

    @SerializedName("first_air_date")
    val firstAir : String ?,

    @SerializedName("original_language")
    val language : String ?,

    @SerializedName("popularity")
    val popularity : String ?,

    @SerializedName("vote_average")
    val voteAverage : String ?

    ): Parcelable {
    constructor() : this("", "", "", "", "", "", "","")
}
