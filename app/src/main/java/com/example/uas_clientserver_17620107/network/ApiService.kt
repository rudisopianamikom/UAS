package com.example.uas_clientserver_17620107.network

import com.example.uas_clientserver_17620107.common.domain.model.EventFootball
import com.example.uas_clientserver_17620107.common.domain.model.TeamDetail
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

const val API_BASE_URL = "https://www.thesportsdb.com/"

// 4328
interface ApiService {
    @GET("/api/v1/json/1/eventspastleague.php")
    fun getFootballEventPrev(
            @Query("id") id : String?
    ) : Deferred<EventFootball>

    @GET("/api/v1/json/1/searchteams.php")
    fun getTeamData(
            @Query("t") t : String?
    ) : Deferred<TeamDetail>

    @GET("/api/v1/json/1/eventsnextleague.php")
    fun getFootBallEventNext(
            @Query("id") id : String?
    ) : Deferred<EventFootball>

}