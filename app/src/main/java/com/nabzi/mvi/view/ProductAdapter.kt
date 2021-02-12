package com.nabzi.mvi.view
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nabzi.mvi.R
import com.nabzi.mvi.databinding.RowProductBinding
import com.nabzi.mvi.model.Product


//class ProductAdapter(private val fragment: HomeFragmentHandler) :
//    ListAdapter<Product, RecyclerView.ViewHolder>(diffCallback) {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
//        ItemViewHolder(
//            DataBindingUtil.inflate(
//                LayoutInflater.from(parent.context),
//                R.layout.row_product, parent, false
//            )
//        )
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        var Item = getItem(position)
//        if (Item != null) {
//            (holder as ItemViewHolder).bindTo(Item);
//        }
//    }
//
//    companion object {
//        //This diff callback informs the PagedListAdapter how to compute list differences when new
//        private val diffCallback = object : DiffUtil.ItemCallback<Product>() {
//            override fun areItemsTheSame(oldProduct: Product, newProduct: Product): Boolean =
//                oldProduct.id == newProduct.id
//
//            override fun areContentsTheSame(oldProduct: Product, newProduct: Product): Boolean =
//                oldProduct == newProduct
//        }
//    }
//    inner class ItemViewHolder(val binding: RowProductBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        var product: Product? = null
//        fun bindTo(_product: Product) {
//            this.product = _product
//            binding.btnAdd.setOnClickListener {
//                fragment.onAddToCartClicked(_product)
//            }
//            with(binding) {
//                item = _product
//                executePendingBindings()
//            }
//        }
//    }
//}
//

class ProductViewHolder(parent: ViewGroup) : LayoutViewHolder(parent, R.layout.row_product) {
    val binding = RowProductBinding.bind(itemView)
}

class ProductAdapter(private val fragment: HomeFragmentHandler) :
    ListAdapter<Product, ProductViewHolder>(diffCallback) {
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