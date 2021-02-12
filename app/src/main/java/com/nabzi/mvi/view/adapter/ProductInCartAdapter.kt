package com.nabzi.mvi.view.adapter
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.nabzi.mvi.R
import com.nabzi.mvi.databinding.RowProductBinding
import com.nabzi.mvi.databinding.RowProductInCartBinding
import com.nabzi.mvi.model.Product
import com.nabzi.mvi.view.HomeFragmentHandler


class ProductInCartViewHolder(parent: ViewGroup) :
    LayoutViewHolder(parent, R.layout.row_product_in_cart) {
    val binding = RowProductInCartBinding.bind(itemView)
}

class ProductInCartAdapter() :
    ListAdapter<Product, ProductInCartViewHolder>(
        diffCallback
    ) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductInCartViewHolder {
        return ProductInCartViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ProductInCartViewHolder, position: Int) {
        holder.binding.item = getItem(position)
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