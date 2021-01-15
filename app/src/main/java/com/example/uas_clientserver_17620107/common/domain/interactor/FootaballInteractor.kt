package com.example.uas_clientserver_17620107.common.domain.interactor

import com.example.uas_clientserver_17620107.common.domain.model.LoadFootballRepository
import com.example.uas_clientserver_17620107.network.ApiService
import javax.inject.Inject

class FootaballInteractor @Inject constructor(private val loadFootballRepository: LoadFootballRepository) :
    FootballUseCase {
    override fun getFootBallResponse(): ApiService {
        return loadFootballRepository.execute()
    }

}