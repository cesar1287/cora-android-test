package com.github.coraandroidtest.newcontact.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.findNavController
import com.github.coraandroidtest.core.utils.Mask
import com.github.coraandroidtest.core.utils.NewContact.HASH_MAP_AGENCY
import com.github.coraandroidtest.extensions.hideKeyboard
import com.github.coraandroidtest.extensions.setButtonEnabled
import com.github.coraandroidtest.extensions.setViewBackgroundDisabled
import com.github.coraandroidtest.extensions.setViewBackgroundEnabled

import com.github.coraandroidtest.newcontact.R
import com.github.coraandroidtest.newcontact.base.BaseNewContactFragment
import kotlinx.android.synthetic.main.fragment_new_contact_agency.*

class NewContactAgencyFragment : BaseNewContactFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_contact_agency, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
    }

    private fun setupObservables() {
        etNewContactAgency.editText?.addTextChangedListener {
            if (it?.length == Mask.MASK_AGENCY.length) {
                acbNewContactAgencyNext.setButtonEnabled(true)
                acbNewContactAgencyNext.setViewBackgroundEnabled(requireContext())
            } else {
                acbNewContactAgencyNext.setButtonEnabled(false)
                acbNewContactAgencyNext.setViewBackgroundDisabled(requireContext())
            }
        }

        acbNewContactAgencyNext.setOnClickListener {
            requireActivity().hideKeyboard(it)
            val cpf = etNewContactAgency.editText?.text.toString()
            viewModel.saveNewContactPartially(HASH_MAP_AGENCY, cpf)
            val action = NewContactAgencyFragmentDirections.actionNewContactAgencyFragmentToNewContactAccountFragment()
            view?.findNavController()?.navigate(action)
        }
    }
}
