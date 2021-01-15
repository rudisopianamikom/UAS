package com.example.uas_clientserver_17620107.common.domain.model

import com.example.uas_clientserver_17620107.network.ApiService


interface LoadFootballRepository {
    fun execute () : ApiService
}