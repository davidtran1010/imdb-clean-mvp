package com.example.mymoviesmvp.injection

import com.example.mymoviesmvp.presenter.ContextModule
import com.example.mymoviesmvp.data.NetworkModule
import com.example.mymoviesmvp.presenter.MovieGettingPresenter
import com.example.mymoviesmvp.view.BaseView
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class), (NetworkModule::class)])
interface PresenterInjector {
    /**
     * Injects required dependencies into the specified PostPresenter.
     * @param postPresenter PostPresenter in which to inject the dependencies
     */
    fun inject(movieGettingPresenter: MovieGettingPresenter)

    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector

        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}