package com.veselove.myapplication210806

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.veselove.myapplication210806.databinding.RecyclerviewItemBinding

class MyRecyclerViewAdapter(private var idImageList: MutableList<Int>):
    RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder(val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        Glide.with(viewHolder.itemView.context)
            .load("http://loremflickr.com/200/200/" + idImageList[position] + "/")
            .placeholder(R.drawable.hourglass)
            .into(viewHolder.binding.imageView)

    }

    override fun getItemCount() = idImageList.size

    fun updateList(newData: MutableList<Int>) {
        idImageList = newData
        notifyDataSetChanged()
    }

}