package com.example.codepath_flixsterclone
import com.google.gson.annotations.SerializedName


class CurrentMovie {
    @SerializedName("id")
    var movieIdNumber: Int? = null

    @SerializedName("title")
    var movieTitleModel: String? = null

    @SerializedName("overview")
    var movieDescriptionModel: String? = null

    @SerializedName("poster_path")
    var movieImageModel: String? = null

    @SerializedName("release_date")
    var releaseDate: String? = null

    @SerializedName("vote_average")
    var voteAverage: String? = null

    @SerializedName("vote_count")
    var voteCount: String? = null
}

