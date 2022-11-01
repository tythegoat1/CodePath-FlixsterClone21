package com.example.codepath_flixsterclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieRecyclerViewAdapter(
    private val currentMovieList: List<CurrentMovie>,
    private val mListener: OnListFragmentInteractionListener?,
    )
    : RecyclerView.Adapter<MovieRecyclerViewAdapter.MovieViewHolder>()
    {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
         val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.movie_row, parent, false)
         return MovieViewHolder(view)
        }

        inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView){
            var mMovie: CurrentMovie? = null
            val mMovieTitle: TextView = mView.findViewById<View>(R.id.movieTitleTV) as TextView
            val mMovieDescription: TextView = mView.findViewById(R.id.movieDescriptionTV) as TextView
            val mMovieImage: ImageView = mView.findViewById(R.id.movieImageIV) as ImageView
        }

     override fun onBindViewHolder(holder: MovieRecyclerViewAdapter.MovieViewHolder, position: Int) {
         // Get the data model based on position
         val currentMovie = currentMovieList[position]
         // Set item views based on views and data model
         holder.mMovie = currentMovie
         holder.mMovieTitle.text = currentMovie.movieTitleModel
         holder.mMovieDescription.text = currentMovie.movieDescriptionModel

         Glide.with(holder.mView)
             .load("https://image.tmdb.org/t/p/w500"+ currentMovie.movieImageModel)
             .centerInside()
             .into(holder.mMovieImage)

         holder.mView.setOnClickListener {
             holder.mMovie?.let { movie ->
                 mListener?.onItemClick(movie)
             }
         }
     }

     override fun getItemCount(): Int {
         return currentMovieList.size
     }
 }


