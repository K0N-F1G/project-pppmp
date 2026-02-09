package com.konstudio.firstaid.Situations.Multipage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.konstudio.firstaid.R

class ViewPagerAdapter(private var txt: List<String>, private var image: List<Int>) :
    RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTxt: TextView = itemView.findViewById(R.id.tvText)
        val itemImg: ImageView = itemView.findViewById(R.id.ivImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))
    }

    override fun getItemCount(): Int {
        return txt.size
    }

    override fun onBindViewHolder(holder: Pager2ViewHolder, position: Int) {
        holder.itemTxt.text = txt[position]
        holder.itemImg.setImageResource(image[position])
    }
}