package com.mobile2you.moviedbmobile2you.di

import com.mobile2you.moviedbmobile2you.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

object ServiceModule {

    @Provides
    @Singleton
    fun providesRepository():Repository{
        return Repository()
    }

}