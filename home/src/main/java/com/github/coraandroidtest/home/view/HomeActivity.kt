package com.github.coraandroidtest.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.coraandroidtest.home.R
import com.github.coraandroidtest.home.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel.getAllContacts()
    }
}
