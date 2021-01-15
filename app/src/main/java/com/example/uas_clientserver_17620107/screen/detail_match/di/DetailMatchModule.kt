package com.example.uas_clientserver_17620107.screen.detail_match.di

import com.example.uas_clientserver_17620107.common.domain.interactor.FootaballInteractor
import com.example.uas_clientserver_17620107.screen.detail_match.DetailMatchViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class DetailMatchModule {

    @Provides
    fun provideDetailMatchViewModelFactory
            (footballInteractor: FootaballInteractor) : DetailMatchViewModelFactory {
        return DetailMatchViewModelFactory(footballInteractor)
    }
}