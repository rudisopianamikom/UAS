package com.example.uas_clientserver_17620107.screen.match

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import com.example.uas_clientserver_17620107.NEXT_MATCH
import com.example.uas_clientserver_17620107.PREV_MATCH
import com.example.uas_clientserver_17620107.common.ViewModel.Response
import com.example.uas_clientserver_17620107.common.domain.interactor.FootaballInteractor
import com.example.uas_clientserver_17620107.common.domain.interactor.FootballUseCase
import com.example.uas_clientserver_17620107.common.domain.model.Events
import com.example.uas_clientserver_17620107.local.database
import io.reactivex.disposables.CompositeDisposable
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject


const val ENGLISH_LEAGUE = "4328"

class PrevMatchViewModel @Inject constructor(
        val footBallInteractor: FootaballInteractor
) : ViewModel(){

    private val response = MutableLiveData<Response>()
    private val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun response () : MutableLiveData<Response> = response

    suspend fun loadDataFootball(menu : String, context: Context?) = loadFootballEvent(footBallInteractor, menu, context)

    suspend fun loadFootballEvent(footballUseCase: FootballUseCase, menu : String, context: Context?){

        when(menu) {
            PREV_MATCH -> {
                try{
                    val responsAPI = footballUseCase
                            .getFootBallResponse()
                            .getFootballEventPrev(ENGLISH_LEAGUE)
                    response.value = Response.Success(responsAPI.await())
                } catch (e : HttpException){
                    Timber.e("Errornya adalah ${e.message()}")
                    response.value = Response.Error
                } catch (e : Throwable){
                    Timber.e("Errornya adalah ${e.message}")
                    response.value = Response.Error
                }
//                compositeDisposable.add(
//                        footballUseCase.getFootBallResponse().getFootballEventPrev(ENGLISH_LEAGUE)
//                                .subscribeOn(Schedulers.io())
//                                .observeOn(AndroidSchedulers.mainThread())
//                                .doOnSubscribe { response.value = Response.Loading }
//                                .subscribe({footballEvent -> response.value = Response.Success(footballEvent)}){
//                                    throwable -> response.value = Response.Error
//                                }
//                )
            }
            NEXT_MATCH -> {
                try{
                    val responsAPI = footballUseCase
                            .getFootBallResponse()
                            .getFootBallEventNext(ENGLISH_LEAGUE)
                    response.value = Response.Success(responsAPI.await())
                } catch (e : HttpException){
                    response.value = Response.Error
                } catch (e : Throwable){
                    response.value = Response.Error
                }
//                compositeDisposable.add(
//                        footballUseCase.getFootBallResponse().getFootBallEventNext(ENGLISH_LEAGUE)
//                                .subscribeOn(Schedulers.io())
//                                .observeOn(AndroidSchedulers.mainThread())
//                                .doOnSubscribe { response.value = Response.Loading }
//                                .subscribe({footballEvent -> response.value = Response.Success(footballEvent)}){
//                                    throwable -> Timber.e("Errornya adalah ${throwable.message}")
//                                }
//                )
            }
            else -> {
                context?.database?.use {
                    val result = select(Events.TABLE_FAVORITE)
                    val favorite = result.parseList(classParser<Events>())

                    response.value = Response.Success(favorite)
                }
            }
        }


    }

}