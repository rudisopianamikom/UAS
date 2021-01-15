package com.example.uas_clientserver_17620107.screen.detail_match

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.uas_clientserver_17620107.common.ViewModel.Response
import com.example.uas_clientserver_17620107.common.domain.interactor.FootaballInteractor
import com.example.uas_clientserver_17620107.common.domain.interactor.FootballUseCase
import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject

class DetailMatchViewModel @Inject constructor(
        val footbalInteractor: FootaballInteractor
) : ViewModel() {
    private val response = MutableLiveData<Response>()

    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun response(): MutableLiveData<Response> = response

    suspend fun loadImage(name : String?) = loadImageData(footbalInteractor, name)

    suspend fun loadImageData(footballUsecase : FootballUseCase, name : String?){
        Timber.e("coba")

        try {
            val responseAPI = footballUsecase.getFootBallResponse().getTeamData(name)
            response.value = Response.Success(responseAPI.await())
        } catch (e : HttpException){
            response.value = Response.Error
        } catch (e : Exception){
            response.value = Response.Error
        }

//        compositeDisposable.add(
//                footballUsecase.getFootBallResponse().getTeamData(name)
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .doOnSubscribe {response.value = Response.Loading}
//                        .subscribe({teamData -> run {
//                            Timber.e(" hasil adalah ${teamData.teams[0].strTeamBadge}")
//                            response.value = Response.Success(teamData)
//                        }})
//                        { response.value = Response.Error}
//        )
    }

}