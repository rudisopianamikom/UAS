package com.example.uas_clientserver_17620107.common.domain.model

import com.example.uas_clientserver_17620107.network.ApiService
import javax.inject.Inject

class LoadFootballDownloader @Inject constructor(private val apiService: ApiService) :
    LoadFootballRepository {
    override fun execute(): ApiService {
        return apiService
    }

}