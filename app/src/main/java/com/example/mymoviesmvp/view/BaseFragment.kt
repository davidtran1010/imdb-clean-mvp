package com.example.mymoviesmvp.view

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymoviesmvp.R
import com.example.mymoviesmvp.presenter.BasePresenter

abstract class BaseFragment<P: BasePresenter<BaseView>>:BaseView, Fragment() {

    protected lateinit var presenter: P

    override fun getViewContext(): Context {
        return activity!!.applicationContext
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = instantiatePresenter()
    }

    protected abstract fun instantiatePresenter(): P

    protected abstract fun instantiateLayout(view: View)

}