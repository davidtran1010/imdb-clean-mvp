package com.example.mymoviesmvp.view

import android.support.annotation.StringRes
import com.example.mymoviesmvp.model.MovieModel

interface MovieGettingView: BaseView {
    fun updateMovies(movies: List<MovieModel>, isLoadedMore: Boolean)

    fun showError(error: String)

    fun showError(@StringRes errorResId: Int) {
        //this.showError(getViewContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()
}