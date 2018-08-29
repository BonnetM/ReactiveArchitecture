package com.cosmo.dojo.reactivetrivia

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders

@Suppress("UNCHECKED_CAST")
class MainFactory(private val useCase: MainUseCase,
    private val presenter: MainPresenter) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(useCase, presenter) as T
    }
}