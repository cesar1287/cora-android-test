package com.github.coraandroidtest.newcontact.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.coraandroidtest.core.database.entity.Bank
import com.github.coraandroidtest.newcontact.R
import com.github.coraandroidtest.newcontact.listener.BankListener
import kotlinx.android.synthetic.main.item_bank.view.*

class BankAdapter (
    private val banksList: List<Bank>,
    private val bankListener: BankListener
) : RecyclerView.Adapter<BankAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bank, parent, false)
        return ViewHolder(view, bankListener)
    }

    override fun getItemCount(): Int {
        return banksList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(banksList[position])
    }

    class ViewHolder(
        itemView: View,
        private val bankListener: BankListener
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(bank: Bank) = with(itemView) {
            tvBankName.text = bank.bankName
            tvBankCode.text = bank.bankCode.toString()

            contentLayout.setOnClickListener {
                bankListener.onBankSelected(bank.bankCode)
            }
        }
    }
}