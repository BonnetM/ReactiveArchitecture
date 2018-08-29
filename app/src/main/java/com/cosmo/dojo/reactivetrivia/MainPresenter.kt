package com.cosmo.dojo.reactivetrivia

import kotlinx.coroutines.experimental.channels.ReceiveChannel
import kotlinx.coroutines.experimental.channels.map

class MainPresenter(store: MainStore) {
    val presenterChannel: ReceiveChannel<String> = store.receiveChannel.map { "view model $it" }
}