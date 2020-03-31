package com.github.coraandroidtest.newcontact.base

import androidx.fragment.app.Fragment
import com.github.coraandroidtest.newcontact.viewmodel.NewContactViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

open class BaseNewContactFragment : Fragment() {

    val viewModel: NewContactViewModel by sharedViewModel()
}