package com.cosmo.dojo.reactivetrivia

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch

class MainViewModel(private val useCase: MainUseCase,
    private val presenter: MainPresenter) : ViewModel() {

    private val mutableLiveData = MutableLiveData<String>()
    val liveData: LiveData<String>
        get() = mutableLiveData


    fun initializeData() {
        launch(CommonPool) { useCase.init() }
        launch(CommonPool) {
            for (presentedString in presenter.presenterChannel) {
                mutableLiveData.postValue(presentedString)
            }
        }
    }

}