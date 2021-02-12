package com.nabzi.mvi.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

interface StableItem {
    val stableId: Any
}

class HashItemCallback<T : StableItem> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem.stableId == newItem.stableId

    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem.hashCode() == newItem.hashCode()
}

abstract class LayoutViewHolder(parent: ViewGroup, @LayoutRes layoutRes: Int) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutRes, parent, false)
)