package com.example.contactapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.contactapp.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryBinding
    private var categoryAdaptor = CategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)
        setUpData()
    }

    private fun setUpData() {
        val layoutManager = GridLayoutManager(this, 2)
        binding.recyclerCategoryList.layoutManager = layoutManager
        binding.recyclerCategoryList.adapter = categoryAdaptor

        val categories = mutableListOf<Category>()
        categories.add(Category("Family"))
        categories.add(Category("Friends"))
        categories.add(Category("Colleagues"))
        categories.add(Category("Mentors"))
        categories.add(Category("Co-workers"))
        categories.add(Category("Enemies"))
        categories.add(Category("Emergencies"))
        categories.add(Category("Haters"))
        categoryAdaptor.setCategories(categories)
    }
}