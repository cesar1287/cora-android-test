package com.github.coraandroidtest.newcontact.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.coraandroidtest.newcontact.R
import com.github.coraandroidtest.newcontact.di.NewContactDependencyInjection

class NewContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_contact)
        NewContactDependencyInjection.injectModules()
    }
}
