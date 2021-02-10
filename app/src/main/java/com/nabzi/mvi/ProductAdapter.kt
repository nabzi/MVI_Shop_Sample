package com.nabzi.mvi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nabzi.mvi.databinding.RowProductBinding
import com.nabzi.mvi.model.Product


class ProductAdapter(private val onAddItemClick: (Long) -> Unit) :
    ListAdapter<Product, RecyclerView.ViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_product, parent, false
            ), onAddItemClick
        )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var Item = getItem(position)
        if (Item != null) {
            (holder as ItemViewHolder).bindTo(Item);
        }
    }

    companion object {
        //This diff callback informs the PagedListAdapter how to compute list differences when new
        private val diffCallback = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldProduct: Product, newProduct: Product): Boolean =
                oldProduct.id == newProduct.id

            override fun areContentsTheSame(oldProduct: Product, newProduct: Product): Boolean =
                oldProduct == newProduct
        }
    }

}

class ItemViewHolder(val binding: RowProductBinding, val onItemClick: (Long) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {
    var product: Product? = null
    fun bindTo(_product: Product) {
        this.product = _product
        binding.btnAdd.setOnClickListener {
            onItemClick(_product.id)
        }
        with(binding) {
            item = _product
            executePendingBindings()
        }
    }
}