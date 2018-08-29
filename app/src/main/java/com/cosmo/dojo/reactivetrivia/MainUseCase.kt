package com.cosmo.dojo.reactivetrivia

class MainUseCase(
    private val repository: MainRepository,
    private val store: MainStore
) {
    suspend fun init() {
        for (s in repository.receiveChannel) {
            store.putData(s)
        }

    }
}