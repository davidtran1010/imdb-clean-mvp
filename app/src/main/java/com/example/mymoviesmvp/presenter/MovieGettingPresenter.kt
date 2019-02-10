package com.example.mymoviesmvp.presenter

import com.example.mymoviesmvp.data.api.FlickrApi
import com.example.mymoviesmvp.utils.MovieMapper
import com.example.mymoviesmvp.view.MovieGettingView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieGettingPresenter(view: MovieGettingView) : BasePresenter<MovieGettingView>(view) {

    @Inject
    lateinit var movieApi: FlickrApi

    var subscription: Disposable? = null


    override fun onViewCreated() {
        loadMovie(1, false, true)
    }

    override fun onViewNeedLoadMore(offset: Int) {
        loadMovie(offset, true, true)
    }

    override fun onViewSwipeRefesh(pageArray: IntArray) {
        for ((page, index) in pageArray.withIndex()) {
            loadMovie(page, false, false)
        }
    }

    private fun loadMovie(page: Int, isLoadedMore: Boolean, isEnableIconLoading: Boolean) {
        if (isEnableIconLoading){
            view.showLoading()
        }
        subscription = movieApi.getPoppularMovie(page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate { view.hideLoading() }
            .subscribe({
                view.updateMovies(MovieMapper.map(it.results), isLoadedMore)
            },{
                view.showError("unknow error")
                if (isLoadedMore) {
                    view.hideLoading()
                }
            })
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}