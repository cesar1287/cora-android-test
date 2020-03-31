package com.github.coraandroidtest.newcontact.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.github.coraandroidtest.core.utils.Mask
import com.github.coraandroidtest.core.utils.NewContact.HASH_MAP_CPF

import com.github.coraandroidtest.newcontact.R
import com.github.coraandroidtest.newcontact.base.BaseNewContactFragment
import com.github.coraandroidtest.newcontact.viewmodel.NewContactViewModel
import com.github.coraandroidtest.R as APP
import kotlinx.android.synthetic.main.fragment_new_contact_cpf.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

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
    }

    private fun setupObservables() {
        etNewContactCpf.editText?.addTextChangedListener {
            if (it?.length == Mask.MASK_CPF.length) {
                acbNewContactCpfNext.isEnabled = true
                acbNewContactCpfNext.background = ContextCompat.getDrawable(requireContext(), APP.drawable.button_border_enabled)
            } else {
                acbNewContactCpfNext.background = ContextCompat.getDrawable(requireContext(), APP.drawable.button_border_disabled)
            }
        }

        acbNewContactCpfNext.setOnClickListener {
            val cpf = etNewContactCpf.editText?.text.toString()
            viewModel.saveNewContactPartially(HASH_MAP_CPF, cpf)
            val action = NewContactCpfFragmentDirections.actionNewContactCpfFragmentToNewContactNameFragment()
            view?.findNavController()?.navigate(action)
        }
    }
}
