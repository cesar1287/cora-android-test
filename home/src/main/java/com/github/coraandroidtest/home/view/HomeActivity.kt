package com.github.coraandroidtest.home.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.coraandroidtest.core.database.entity.Contact
import com.github.coraandroidtest.home.R
import com.github.coraandroidtest.home.adapter.HomeAdapter
import com.github.coraandroidtest.home.di.HomeDependencyInjection
import com.github.coraandroidtest.home.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModel()

    private lateinit var homeAdapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        HomeDependencyInjection.injectModules()

        viewModel.getAllContacts()
        setupObservables()
    }

    private fun setupObservables() {
        viewModel.contactLiveData.observe(this, Observer { contactsList ->
            if (contactsList.isEmpty()) {
                ivHomeNoContacts.visibility = View.VISIBLE
                rvHomeContactsList.visibility = View.GONE
            } else {
                setupRecyclerView(this, contactsList)
            }
        })

        btHomeNewContact.setOnClickListener {
            startActivity(Intent(
                this,
                Class.forName("com.github.coraandroidtest.newcontact.view.activity.NewContactActivity")
            ))
        }
    }

    private fun setupRecyclerView(context: Context, contactsList: List<Contact>) {
        val layoutManager = LinearLayoutManager(context)
        rvHomeContactsList.layoutManager = layoutManager
        homeAdapter = HomeAdapter(contactsList)
        rvHomeContactsList.adapter = homeAdapter
    }
}
