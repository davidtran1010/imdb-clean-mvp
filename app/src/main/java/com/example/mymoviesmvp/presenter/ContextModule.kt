package com.example.mymoviesmvp.presenter

import android.app.Application
import android.content.Context
import com.example.mymoviesmvp.view.BaseView
import dagger.Module
import dagger.Provides

@Module
object ContextModule {

    @Provides
    @JvmStatic
    internal fun provideContext(baseView: BaseView): Context {
        return baseView.getViewContext()
    }

    @Provides
    @JvmStatic
    internal fun provideApplication(context: Context): Application {
        return context.applicationContext as Application
    }
}