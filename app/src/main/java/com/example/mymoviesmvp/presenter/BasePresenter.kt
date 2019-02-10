package com.example.mymoviesmvp.presenter

import com.example.mymoviesmvp.data.NetworkModule
import com.example.mymoviesmvp.injection.DaggerPresenterInjector
import com.example.mymoviesmvp.injection.PresenterInjector
import com.example.mymoviesmvp.view.BaseView

abstract class BasePresenter<out V : BaseView>(protected val view: V) {


    private val injector: PresenterInjector = DaggerPresenterInjector
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    open fun onViewCreated() {}

    open fun onViewDestroyed() {}

    open fun onViewNeedLoadMore(offset: Int){}

    open fun onViewSwipeRefesh(pageArray: IntArray) {}

    private fun inject() {
        when (this) {
            is MovieGettingPresenter -> injector.inject(this)
        }
    }
}
