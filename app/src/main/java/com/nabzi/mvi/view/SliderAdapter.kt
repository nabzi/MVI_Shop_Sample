package com.nabzi.mvi.view

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.nabzi.mvi.R
import com.nabzi.mvi.model.Item
import com.smarteist.autoimageslider.SliderViewAdapter
import java.util.*
import kotlin.collections.ArrayList

class SliderAdapter : SliderViewAdapter<SliderAdapterVH>() {
    private var context: Context? = null
    private var mItems: ArrayList<Item> = arrayListOf()
    fun SliderAdapterExample(context: Context?) {
        this.context = context
    }

    fun renewItems(items: ArrayList<Item>) {
        mItems = items
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        mItems.removeAt(position)
        notifyDataSetChanged()
    }

    fun addItem(item: Item) {
        mItems.add(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_slider_layout_item, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val item: Item = mItems[position]
//        viewHolder.textViewDescription.setText(Item.desc)
//        viewHolder.textViewDescription.textSize = 16f
//        viewHolder.textViewDescription.setTextColor(Color.WHITE)
        Glide.with(viewHolder.itemView)
            .load(item.imageUrl)
            .fitCenter()
            .into(viewHolder.imageViewBackground)
        viewHolder.itemView.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "This is item in position $position", Toast.LENGTH_SHORT)
                .show()
        })
    }

    override fun getCount(): Int {
        //slider view count could be dynamic size
        return mItems.size
    }


}
class SliderAdapterVH(itemView: View) :
    SliderViewAdapter.ViewHolder(itemView) {
    lateinit var view: View
    var imageViewBackground: ImageView
//    var imageGifContainer: ImageView
//    var textViewDescription: TextView

    init {
        imageViewBackground =
            itemView.findViewById(R.id.ivImage)
//        imageGifContainer =
//            itemView.findViewById(R.id.iv_gif_container)
//        textViewDescription = itemView.findViewById(R.id.tv_auto_image_slider)
        this.view = itemView
    }
}