package com.nabzi.mvi.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.nabzi.mvi.R
import com.smarteist.autoimageslider.SliderViewAdapter


data class SlidingItem(
    var imageUrl : String
)
class SliderAdapter : SliderViewAdapter<SliderAdapterVH>() {
    private var context: Context? = null
    private var mSlidingItems: ArrayList<SlidingItem> = arrayListOf()
    fun SliderAdapterExample(context: Context?) {
        this.context = context
    }

    fun renewItems(SlidingItems: ArrayList<SlidingItem>) {
        mSlidingItems = SlidingItems
        notifyDataSetChanged()
    }

    fun deleteItem(position: Int) {
        mSlidingItems.removeAt(position)
        notifyDataSetChanged()
    }

    fun addItem(SlidingItem: SlidingItem) {
        mSlidingItems.add(SlidingItem)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val inflate: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_slider_layout_item, null)
        return SliderAdapterVH(inflate)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        val SlidingItem: SlidingItem = mSlidingItems[position]
//        viewHolder.textViewDescription.setText(Item.desc)
//        viewHolder.textViewDescription.textSize = 16f
//        viewHolder.textViewDescription.setTextColor(Color.WHITE)

        Glide.with(viewHolder.itemView)
            .load(SlidingItem.imageUrl)
            .centerCrop()
            .into(viewHolder.imageViewBackground)
        viewHolder.itemView.setOnClickListener(View.OnClickListener {
            Toast.makeText(context, "This is item in position $position", Toast.LENGTH_SHORT)
                .show()
        })
    }

    override fun getCount(): Int {
        //slider view count could be dynamic size
        return mSlidingItems.size
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