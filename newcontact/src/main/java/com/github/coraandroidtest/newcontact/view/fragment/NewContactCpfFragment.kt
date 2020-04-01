package com.github.coraandroidtest.newcontact.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.navigation.findNavController
import com.github.coraandroidtest.core.utils.Mask
import com.github.coraandroidtest.core.utils.NewContact.HASH_MAP_CPF
import com.github.coraandroidtest.customview.ToolbarCora
import com.github.coraandroidtest.extensions.hideKeyboard
import com.github.coraandroidtest.extensions.setButtonEnabled
import com.github.coraandroidtest.extensions.setViewBackgroundDisabled
import com.github.coraandroidtest.extensions.setViewBackgroundEnabled

import com.github.coraandroidtest.newcontact.R
import com.github.coraandroidtest.newcontact.base.BaseNewContactFragment
import kotlinx.android.synthetic.main.fragment_new_contact_cpf.*

class NewContactCpfFragment : BaseNewContactFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_contact_cpf, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupObservables()
        tbNewContactToolbar.listener = this
    }

    private fun setupObservables() {
        etNewContactCpf.editText?.addTextChangedListener {
            if (it?.length == Mask.MASK_CPF.length) {
                acbNewContactCpfNext.setButtonEnabled(true)
                acbNewContactCpfNext.setViewBackgroundEnabled(requireContext())
            } else {
                acbNewContactCpfNext.setButtonEnabled(false)
                acbNewContactCpfNext.setViewBackgroundDisabled(requireContext())
            }
        }

        acbNewContactCpfNext.setOnClickListener {
            requireActivity().hideKeyboard(it)
            val cpf = etNewContactCpf.editText?.text.toString()
            viewModel.saveNewContactPartially(HASH_MAP_CPF, cpf)
            val action = NewContactCpfFragmentDirections.actionNewContactCpfFragmentToNewContactNameFragment()
            view?.findNavController()?.navigate(action)
        }
    }
}
