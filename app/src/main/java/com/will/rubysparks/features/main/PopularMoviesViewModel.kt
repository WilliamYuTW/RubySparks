package com.will.rubysparks.features.main

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.will.tmdbsdk.TmdbService
import com.will.tmdbsdk.data.TmdbMovie

class PopularMoviesViewModel @ViewModelInject constructor(
    tmdbService: TmdbService,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    val popularMovies: LiveData<List<TmdbMovie>> = liveData {
        val movies = tmdbService.getPopularMovies().results
        emit(movies)
    }
}