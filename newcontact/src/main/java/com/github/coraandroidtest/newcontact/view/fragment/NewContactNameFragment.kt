package com.github.coraandroidtest.newcontact.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.findNavController
import com.github.coraandroidtest.core.utils.NewContact.HASH_MAP_NAME
import com.github.coraandroidtest.extensions.hideKeyboard
import com.github.coraandroidtest.extensions.setButtonEnabled
import com.github.coraandroidtest.extensions.setViewBackgroundDisabled
import com.github.coraandroidtest.extensions.setViewBackgroundEnabled

import com.github.coraandroidtest.newcontact.R
import com.github.coraandroidtest.newcontact.base.BaseNewContactFragment
import kotlinx.android.synthetic.main.fragment_new_contact_name.*

class NewContactNameFragment : BaseNewContactFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_contact_name, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
    }

    private fun setupObservables() {
        etNewContactName.editText?.addTextChangedListener {
            if (!it.isNullOrBlank()) {
                acbNewContactNameNext.setButtonEnabled(true)
                acbNewContactNameNext.setViewBackgroundEnabled(requireContext())
            } else {
                acbNewContactNameNext.setButtonEnabled(false)
                acbNewContactNameNext.setViewBackgroundDisabled(requireContext())
            }
        }

        acbNewContactNameNext.setOnClickListener {
            requireActivity().hideKeyboard(it)
            val name = etNewContactName.editText?.text.toString()
            viewModel.saveNewContactPartially(HASH_MAP_NAME, name)
            val action = NewContactNameFragmentDirections.actionNewContactNameFragmentToNewContactBankFragment()
            view?.findNavController()?.navigate(action)
        }
    }
}
