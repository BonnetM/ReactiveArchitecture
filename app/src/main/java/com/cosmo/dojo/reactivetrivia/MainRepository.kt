package com.cosmo.dojo.reactivetrivia

import kotlinx.coroutines.experimental.channels.Channel
import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch

class MainRepository {

    init {
        launch {
            while (true) {
                delay(1000)
                channel.send(System.currentTimeMillis().toString())
            }
        }
    }

    private val channel = Channel<String>(1)
    val receiveChannel: ReceiveChannel<String>
        get() = channel


}