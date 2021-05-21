package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.contactapp.databinding.ActivityMainBinding
import com.example.contactapp.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val contactAdapter = ContactAdapter()
    private lateinit var category: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)

        category = intent.getStringExtra("Category") ?: ""
        if(category.isNotEmpty()){
            supportActionBar?.title = category
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        setUpData(binding)
    }

    fun setUpData(binding: ActivityMainBinding){

        binding.recyclViewList.adapter = contactAdapter
        binding.recyclViewList.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))

        val builder = AlertDialog.Builder(this)
        val view = this.layoutInflater.inflate(R.layout.add_contact_dialog, null)
        builder.setView(view)

        var name =  view.findViewById<TextView>(R.id.etxv_add_name)
        var number = view.findViewById<TextView>(R.id.etxv_add_number)
        var addContactButton = view.findViewById<Button>(R.id.btn_add_contact)

        number.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                addContactButton.isEnabled = s?.length == 11
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

        val alertDialog = builder.create()

        addContactButton.setOnClickListener{
            val contact = Contact(name.text.toString(), number.text.toString())
            val contacts = mutableListOf(contact)

            contactAdapter.setUpTheContacts(contacts)
            alertDialog.dismiss()
        }

        binding.fabBtn.setOnClickListener{
            alertDialog.show()
        }
    }
}