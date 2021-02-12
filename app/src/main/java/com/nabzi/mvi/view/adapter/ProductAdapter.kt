package com.nabzi.mvi.view.adapter
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.nabzi.mvi.R
import com.nabzi.mvi.databinding.RowProductBinding
import com.nabzi.mvi.model.Product
import com.nabzi.mvi.view.HomeFragmentHandler

class ProductViewHolder(parent: ViewGroup) : LayoutViewHolder(parent, R.layout.row_product) {
    val binding = RowProductBinding.bind(itemView)
}

class ProductAdapter(private val fragment: HomeFragmentHandler) :
    ListAdapter<Product, ProductViewHolder>(
        diffCallback
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(parent).apply {
            binding.handler = fragment
        }
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.binding.item = getItem(position)
        holder.binding.handler = fragment
    }
    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldProduct: Product, newProduct: Product): Boolean =
                oldProduct.id == newProduct.id

            override fun areContentsTheSame(oldProduct: Product, newProduct: Product): Boolean =
                oldProduct == newProduct
        }
    }
}