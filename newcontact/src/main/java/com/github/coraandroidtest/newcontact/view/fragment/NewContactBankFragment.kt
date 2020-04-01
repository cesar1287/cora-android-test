package com.github.coraandroidtest.newcontact.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.coraandroidtest.core.database.entity.Bank
import com.github.coraandroidtest.core.utils.NewContact.HASH_MAP_BANK

import com.github.coraandroidtest.newcontact.R
import com.github.coraandroidtest.newcontact.adapter.BankAdapter
import com.github.coraandroidtest.newcontact.base.BaseNewContactFragment
import com.github.coraandroidtest.newcontact.listener.BankListener
import kotlinx.android.synthetic.main.fragment_new_contact_bank.*

class NewContactBankFragment : BaseNewContactFragment(), BankListener {

    private lateinit var bankAdapter: BankAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_contact_bank, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getAllBanks()
        setupObservables()
    }

    private fun setupObservables() {
        viewModel.bankLiveData.observe(this, Observer {
            setupRecyclerView(requireContext(), it)
        })
    }

    private fun setupRecyclerView(context: Context, banksList: List<Bank>) {
        val layoutManager = LinearLayoutManager(context)
        rvHomeBanksList.layoutManager = layoutManager
        bankAdapter = BankAdapter(banksList, this)
        rvHomeBanksList.adapter = bankAdapter
    }

    override fun onBankSelected(bankCode: Int?) {
        viewModel.saveNewContactPartially(HASH_MAP_BANK, bankCode)
        val action = NewContactBankFragmentDirections.actionNewContactBankFragmentToNewContactAgencyFragment()
        view?.findNavController()?.navigate(action)
    }

}
