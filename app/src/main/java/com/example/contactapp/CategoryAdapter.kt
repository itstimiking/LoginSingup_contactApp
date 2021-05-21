package com.example.contactapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.databinding.CategoryRecyclerItemViewBinding

class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    val categories = mutableListOf<Category>()

    fun setCategories(categories: List<Category>){
        this.categories.addAll(categories)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(CategoryRecyclerItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bindCategory(category)
        holder.itemView.setOnClickListener{ v ->
            val intent = Intent(v.context, MainActivity::class.java)
            intent.putExtra("Category", category.categoryName)
            v.context.startActivity(intent)
        }
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