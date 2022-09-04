package com.gentera.yastas.sdk.myapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gentera.yastas.sdk.myapplication.core.ConnectivityManager
import com.gentera.yastas.sdk.myapplication.databinding.ActivityMainBinding
import com.gentera.yastas.sdk.myapplication.viewModel.VmNetwork

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var connectivityManager: ConnectivityManager
    private val vmNetwork: VmNetwork by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        connectivityManager = ConnectivityManager(application)
        connectivityManager.registerConnectionObserver(this, vmNetwork)
    }

    override fun onDestroy() {
        super.onDestroy()
        connectivityManager.unregisterConnectionObserver(this)
    }
}