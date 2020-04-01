package com.github.coraandroidtest.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.coraandroidtest.core.database.entity.Contact
import com.github.coraandroidtest.home.R
import kotlinx.android.synthetic.main.item_contact.view.*

class HomeAdapter(
    private val contactsList: List<Contact>,
    private val idLastInserted: Int
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(contactsList[position], idLastInserted)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(
            contact: Contact,
            idLastInserted: Int
        ) = with(itemView) {
            tvContactName.text = contact.contactName
            tvContactCpf.text = contact.contactCpf

            if (contact.uid == idLastInserted) {
                vwContactNewContact.visibility = View.VISIBLE
            }
        }
    }
}