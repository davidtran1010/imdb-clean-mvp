package com.example.mymoviesmvp.utils

const val BASE_API_URL = "https://api.themoviedb.org/3/"
const val DISCOVER_API = "discover/movie"
const val API_KEY = "api_key=b9447a39462d9f0e7fabce11443ba80f"
const val MOVIE_POSTER_URL = "https://image.tmdb.org/t/p/"

enum class MoviePhotoSize(val value: String) {
    standard("w500"),
    original("original");
}
