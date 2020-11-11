package com.will.rubysparks

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BASIC
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * @author WeiYi Yu
 * @date 2020-11-11
 */
interface TmdbService {

    companion object {
        fun create(): TmdbService {
            val logger = HttpLoggingInterceptor().apply { level = BASIC }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            val moshiConverter = MoshiConverterFactory.create()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BuildConfig.TMDB_BASE_URL)
                .addConverterFactory(moshiConverter)
                .build()
                .create(TmdbService::class.java)
        }
    }
}