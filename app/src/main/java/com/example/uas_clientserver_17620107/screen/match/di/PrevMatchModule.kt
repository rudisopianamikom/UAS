package com.example.uas_clientserver_17620107.screen.match.di

import com.example.uas_clientserver_17620107.screen.match.PrevMatchViewModelFactory
import com.example.uas_clientserver_17620107.common.domain.interactor.FootaballInteractor
import dagger.Module
import dagger.Provides

@Module
class PrevMatchModule {

    @Provides
    fun providePrevMatchViewModelFactory(footaballInteractor: FootaballInteractor) : PrevMatchViewModelFactory {
        return PrevMatchViewModelFactory(footaballInteractor)
    }
}