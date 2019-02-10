package com.example.mymoviesmvp.utils

import com.example.mymoviesmvp.data.dto.MovieReponse
import com.example.mymoviesmvp.data.dto.MovieResult
import com.example.mymoviesmvp.model.MovieModel

object MovieMapper {
    @JvmStatic
    fun map(movieResults: List<MovieResult>): List<MovieModel> {
        var movies = ArrayList<MovieModel>()
        movieResults.forEach {
            movies.add(MovieModel(it.title, it.posterPath))
        }
        return movies
    }
}