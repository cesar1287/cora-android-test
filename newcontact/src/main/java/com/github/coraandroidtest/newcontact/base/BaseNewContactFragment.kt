package com.github.coraandroidtest.newcontact.base

import androidx.fragment.app.Fragment
import com.github.coraandroidtest.customview.ToolbarCora
import com.github.coraandroidtest.newcontact.view.fragment.NewContactSuccessFragment
import com.github.coraandroidtest.newcontact.viewmodel.NewContactViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

open class BaseNewContactFragment : Fragment(), ToolbarCora.ToolBarItauListener {

    val viewModel: NewContactViewModel by sharedViewModel()

    override fun onBackPressedToolbar() {
        if (this is NewContactSuccessFragment) {
            activity?.finish()
        } else {
            activity?.onBackPressed()
        }
    }
}