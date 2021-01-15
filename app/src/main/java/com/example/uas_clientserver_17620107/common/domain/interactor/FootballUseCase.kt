package com.example.uas_clientserver_17620107.common.domain.interactor

import com.example.uas_clientserver_17620107.network.ApiService

interface FootballUseCase {
    fun getFootBallResponse() : ApiService
}