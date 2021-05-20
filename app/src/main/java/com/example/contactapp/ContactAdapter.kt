package com.example.contactapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.databinding.ActivityRecyclerItemLayoutBinding

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    private val contacts = mutableListOf<Contact>()

    fun setUpTheContacts(contacts : List<Contact>){
        this.contacts.addAll(contacts)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return ContactViewHolder(ActivityRecyclerItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent,false))
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bindItem(contact)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    inner class ContactViewHolder(private val binding: ActivityRecyclerItemLayoutBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindItem( contact: Contact){
            binding.apply {
                txvName.text = contact.name
                txvNumber.text = contact.number
            }
        }
    }
}