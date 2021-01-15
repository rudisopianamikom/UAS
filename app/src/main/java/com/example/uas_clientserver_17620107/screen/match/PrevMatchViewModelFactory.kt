package com.example.uas_clientserver_17620107.screen.match

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.uas_clientserver_17620107.common.domain.interactor.FootaballInteractor

class PrevMatchViewModelFactory (
        val footballInteractor: FootaballInteractor
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(PrevMatchViewModel::class.java) -> {
                return PrevMatchViewModel(footballInteractor) as (T)
            }
        }
        throw IllegalArgumentException(" Kelas tidak diketahui")
    }

}