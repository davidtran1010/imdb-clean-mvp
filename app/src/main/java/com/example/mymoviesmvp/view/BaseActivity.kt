package com.example.mymoviesmvp.view

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.example.mymoviesmvp.presenter.BasePresenter

abstract class BaseActivity<P: BasePresenter<BaseView>> :BaseView, AppCompatActivity() {
    protected lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()

    }

    protected abstract fun instantiatePresenter(): P

    protected abstract fun instantiateLayout()

}