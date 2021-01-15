package com.example.uas_clientserver_17620107.network.di

import com.example.uas_clientserver_17620107.common.domain.model.LoadFootballDownloader
import com.example.uas_clientserver_17620107.common.domain.model.LoadFootballRepository
import com.example.uas_clientserver_17620107.network.ApiService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class FootballInteractorModule {

    @Singleton
    @Provides
    fun provideFootballInteractor(apiService: ApiService) : LoadFootballRepository = LoadFootballDownloader(apiService)
}