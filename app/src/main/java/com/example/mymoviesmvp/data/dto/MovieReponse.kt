package com.example.mymoviesmvp.data.dto
import com.google.gson.annotations.SerializedName


class MovieReponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<MovieResult>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)