package com.nabzi.mvi

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Switch
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nabzi.mvi.databinding.RowItemBinding
import com.nabzi.mvi.model.Item


class ItemAdapter(private val onAddItemClick: (Long) -> Unit) :
    ListAdapter<Item, RecyclerView.ViewHolder>(diffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_item, parent, false
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
        private val diffCallback = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean =
                oldItem == newItem
        }
    }

}

class ItemViewHolder(val binding: RowItemBinding, val onItemClick: (Long) -> Unit) :
    RecyclerView.ViewHolder(binding.root) {
    var item: Item? = null
    fun bindTo(_item: Item) {
        this.item = _item
        binding.btnAdd.setOnClickListener {
            onItemClick(_item.id)
        }
        with(binding) {
            item = _item
            executePendingBindings()
        }
    }
}