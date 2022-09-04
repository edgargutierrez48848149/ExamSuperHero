package com.gentera.yastas.sdk.myapplication.core

import android.app.Application
import androidx.lifecycle.LifecycleOwner
import com.gentera.yastas.sdk.myapplication.viewModel.VmNetwork
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ConnectivityManager
@Inject
constructor(application: Application) {

    private val connectionLiveData = ConnectivityLiveData(application)

    fun registerConnectionObserver(
        lifecycleOwner: LifecycleOwner,
        generalViewModelNetwork: VmNetwork
    ) {
        generalViewModelNetwork.setIsConected(false)
        connectionLiveData.observe(lifecycleOwner, { isConnected ->
            isConnected?.let {
                generalViewModelNetwork.setIsConected(it)
            }
        })
    }

    fun unregisterConnectionObserver(lifecycleOwner: LifecycleOwner) {
        connectionLiveData.removeObservers(lifecycleOwner)
    }
}