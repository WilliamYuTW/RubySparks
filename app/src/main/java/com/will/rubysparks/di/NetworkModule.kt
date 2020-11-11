package com.will.rubysparks.di

import com.will.rubysparks.TmdbService
import dagger.Provides
import javax.inject.Singleton

/**
 * @author WeiYi Yu
 * @date 2020-11-11
 */
class NetworkModule {
    @Singleton
    @Provides
    fun provideTmdbService(): TmdbService {
        return TmdbService.create()
    }
}