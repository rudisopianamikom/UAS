package com.example.uas_clientserver_17620107.network.di

import com.example.uas_clientserver_17620107.screen.detail_match.DetailMatch
import com.example.uas_clientserver_17620107.screen.detail_match.di.DetailMatchModule
import com.example.uas_clientserver_17620107.screen.match.PrevMatchFragment
import com.example.uas_clientserver_17620107.screen.match.di.PrevMatchModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuilderModule {

    @ContributesAndroidInjector(modules = arrayOf(PrevMatchModule::class))
    abstract fun bindFootballFragment() : PrevMatchFragment

    @ContributesAndroidInjector(modules = arrayOf(DetailMatchModule::class))
    abstract fun bindDetailFragment() : DetailMatch

}