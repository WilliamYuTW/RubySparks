package com.will.rubysparks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.will.tmdbsdk.TmdbService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var tmdbService: TmdbService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            val popularMovies = withContext(Dispatchers.IO) {
                tmdbService.getPopularMovies()
            }
            print(popularMovies.results.toString())
        }
    }
}