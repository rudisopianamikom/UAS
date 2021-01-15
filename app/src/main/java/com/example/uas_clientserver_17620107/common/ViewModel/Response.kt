package com.example.uas_clientserver_17620107.common.ViewModel

sealed class Response {
    object Loading : Response()
    data class Success (val data: Any?) : Response()
    object Error : Response()
}