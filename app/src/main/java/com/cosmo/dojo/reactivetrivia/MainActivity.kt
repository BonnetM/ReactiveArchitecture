package com.cosmo.dojo.reactivetrivia

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val repository = MainRepository()
    private val store = MainStore()
    private val useCase= MainUseCase(repository, store)
    private val presenter = MainPresenter(store)
    private val factory = MainFactory(useCase, presenter)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Ce qui suit est un scandal
        val viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)
        viewModel.liveData.observe(this,  Observer { mainButton.text = it })
        mainButton.setOnClickListener {
            viewModel.initializeData()
        }
    }
}
