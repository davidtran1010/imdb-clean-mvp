package com.example.mymoviesmvp.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mymoviesmvp.R
import com.example.mymoviesmvp.model.MovieModel
import com.example.mymoviesmvp.utils.MOVIE_POSTER_URL
import com.example.mymoviesmvp.utils.MoviePhotoSize
import kotlinx.android.synthetic.main.item_movie_layout.view.*

class MoviesAdapter(val mContext: Context, val viewHeight: Int):
    RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {

    private val MAX_VISIBLE_ITEMS: Int = 4
    private var  movies: ArrayList<MovieModel> = ArrayList<MovieModel>()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val v: View = LayoutInflater.from(p0.context).inflate(R.layout.item_movie_layout, p0, false)
        v.layoutParams.height = viewHeight / MAX_VISIBLE_ITEMS
        return MyViewHolder(v)
    }

    fun setData(movies: List<MovieModel>, isLoadedMore: Boolean) {
        if (!isLoadedMore) {
            this.movies.clear()
        }
        this.movies.addAll(movies)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        Log.d("data","title:" + movies[p1].name + " - " + "photo:" + MOVIE_POSTER_URL + MoviePhotoSize.standard.value + movies[p1].photoUrl)
        p0.title.text = movies[p1].name
        if (movies[p1].photoUrl != null) {
//            Picasso.get()
//                .load(MOVIE_POSTER_URL + MoviePhotoSize.standard.value + movies[p1].photoUrl)
//                .fit()
//                .centerCrop()
//                .into(p0.photo)
            Glide.with(mContext)
                .load(MOVIE_POSTER_URL + MoviePhotoSize.standard.value + movies[p1].photoUrl)
                .apply(RequestOptions.fitCenterTransform())
                .into(p0.photo)
        }
        p0.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Toast.makeText(mContext," " + "item" + p1 + "clicked", Toast.LENGTH_LONG)
            }
        })
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val title = itemView.movieTitle
        val photo = itemView.movieImage
    }

}