package com.github.coraandroidtest.newcontact.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.github.coraandroidtest.newcontact.R
import com.github.coraandroidtest.newcontact.base.BaseNewContactFragment

class NewContactBankFragment : BaseNewContactFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_contact_bank, container, false)
    }

}
