package com.will.rubysparks.features.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.will.rubysparks.databinding.ItemPopularMovieBinding
import com.will.tmdbsdk.data.TmdbMovie

/**
 * @author WeiYi Yu
 * @date 2021-01-27
 */
class PopularMoviesAdapter :
    ListAdapter<TmdbMovie, PopularMoviesAdapter.ViewHolder>(MovieDiffCallback()) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ViewHolder = ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
    }

    class ViewHolder private constructor(
        private val binding: ItemPopularMovieBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: TmdbMovie) {
            binding.movie = movie
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPopularMovieBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    private class MovieDiffCallback : DiffUtil.ItemCallback<TmdbMovie>() {
        override fun areItemsTheSame(oldItem: TmdbMovie, newItem: TmdbMovie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TmdbMovie, newItem: TmdbMovie): Boolean {
            return oldItem == newItem
        }
    }
}