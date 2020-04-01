package com.github.coraandroidtest.newcontact.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.findNavController
import com.github.coraandroidtest.core.utils.Mask
import com.github.coraandroidtest.core.utils.NewContact.HASH_MAP_ACCOUNT
import com.github.coraandroidtest.extensions.hideKeyboard
import com.github.coraandroidtest.extensions.setButtonEnabled
import com.github.coraandroidtest.extensions.setViewBackgroundDisabled
import com.github.coraandroidtest.extensions.setViewBackgroundEnabled

import com.github.coraandroidtest.newcontact.R
import com.github.coraandroidtest.newcontact.base.BaseNewContactFragment
import kotlinx.android.synthetic.main.fragment_new_contact_account.*

class NewContactAccountFragment : BaseNewContactFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_contact_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
    }

    private fun setupObservables() {
        etNewContactAccount.editText?.addTextChangedListener {
            if (it?.length == Mask.MASK_ACCOUNT.length) {
                acbNewContactAccountNext.setButtonEnabled(true)
                acbNewContactAccountNext.setViewBackgroundEnabled(requireContext())
            } else {
                acbNewContactAccountNext.setButtonEnabled(false)
                acbNewContactAccountNext.setViewBackgroundDisabled(requireContext())
            }
        }

        acbNewContactAccountNext.setOnClickListener {
            requireActivity().hideKeyboard(it)
            val cpf = etNewContactAccount.editText?.text.toString()
            viewModel.saveNewContactPartially(HASH_MAP_ACCOUNT, cpf)
            viewModel.saveNewContactDatabase()
            val action = NewContactAccountFragmentDirections.actionNewContactAccountFragmentToNewContactSuccessFragment()
            view?.findNavController()?.navigate(action)
        }
    }

}
