package com.example.mymoviesmvp.view

import android.content.Context
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mymoviesmvp.R
import com.example.mymoviesmvp.model.MovieModel
import com.example.mymoviesmvp.presenter.MovieGettingPresenter
import com.example.mymoviesmvp.utils.ViewUtils

class HomeFragment: BaseFragment<MovieGettingPresenter>(), MovieGettingView{

    lateinit var moviesAdapter: MoviesAdapter

    lateinit var recyclerView: RecyclerView

    lateinit var progressBarView: ConstraintLayout

    lateinit var mSwipeRefeshLayout: SwipeRefreshLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        instantiateLayout(view)
        presenter.onViewCreated()
    }

    override fun instantiatePresenter(): MovieGettingPresenter {
        return MovieGettingPresenter(this)
    }

    fun initSwipeRefeshLayout(view: View) {
        mSwipeRefeshLayout = view.findViewById(R.id.swiperefesh)
        mSwipeRefeshLayout.setOnRefreshListener {
            presenter.onViewSwipeRefesh(intArrayOf(1))
        }
    }

    fun initRecyclerView(view: View) {
        val gridLayoutManager = GridLayoutManager(getViewContext(), 3)
        recyclerView = view.findViewById(R.id.recyclerview_list)
        recyclerView.layoutManager = gridLayoutManager
        recyclerView.addOnScrollListener(object: EndlessRecyclerViewScrollListener<GridLayoutManager>(gridLayoutManager){
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                presenter.onViewNeedLoadMore(page)
            }
        })
        moviesAdapter = MoviesAdapter(getViewContext(), ViewUtils.getScreenHeight(getViewContext()))
        recyclerView.adapter = moviesAdapter
    }
    override fun instantiateLayout(view: View) {
        progressBarView = view.findViewById(R.id.progress_bar_view)
        initSwipeRefeshLayout(view)
        initRecyclerView(view)
    }

    override fun updateMovies(movies: List<MovieModel>, isLoadedMore: Boolean) {
        moviesAdapter.setData(movies, isLoadedMore)
    }

    override fun showError(error: String) {
        Log.d("ERROR","ERROR LOAD")
    }

    override fun showLoading() {
        Log.d("UI","LOADING...")
        progressBarView.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        Log.d("UI","Hide Loading")
        progressBarView.visibility = View.INVISIBLE
        mSwipeRefeshLayout.isRefreshing = false
    }
}