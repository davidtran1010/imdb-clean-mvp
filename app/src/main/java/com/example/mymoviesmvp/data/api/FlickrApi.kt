package com.example.mymoviesmvp.data.api

import com.example.mymoviesmvp.data.dto.MovieReponse
import com.example.mymoviesmvp.utils.API_KEY
import com.example.mymoviesmvp.utils.DISCOVER_API
import retrofit2.http.GET
import io.reactivex.Observable
import retrofit2.http.Path
import retrofit2.http.Query

interface FlickrApi {
    @GET(DISCOVER_API + "?" + API_KEY)
    fun getPoppularMovie(@Query("page") page: Int): Observable<MovieReponse>
}
