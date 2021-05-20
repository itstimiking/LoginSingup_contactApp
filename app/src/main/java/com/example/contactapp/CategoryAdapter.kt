package com.example.contactapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.databinding.CategoryRecyclerItemViewBinding

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    init {
        setCategories()
    }

    val categories = mutableListOf<Category>()

    fun setCategories(){
        addCategory("Family")
        addCategory("Friends")
        addCategory("Colleagues")
        addCategory("Tutors")
        addCategory("Co-workers")
        addCategory("Unknown")
    }

    private fun addCategory(categoryName: String){
        val category = Category(categoryName)
        this.categories.add(category)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(CategoryRecyclerItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bindCategory(category)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class CategoryViewHolder(private val binding: CategoryRecyclerItemViewBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindCategory( category: Category){
            binding.categoryName.text = category.categoryName
        }
    }
}