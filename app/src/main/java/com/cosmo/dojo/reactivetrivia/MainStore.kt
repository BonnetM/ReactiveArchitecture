package com.cosmo.dojo.reactivetrivia

import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.ReceiveChannel

class MainStore {

    private val channel = Channel<String>(1)
    val receiveChannel: ReceiveChannel<String>
        get() = channel

    suspend fun putData(data: String) {
        channel.send(data)
    }
}