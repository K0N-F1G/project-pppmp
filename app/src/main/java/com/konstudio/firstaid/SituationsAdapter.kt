package com.konstudio.firstaid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.konstudio.firstaid.ActivitiesMap

class SituationsAdapter (var mList: List<SituationsData>) : RecyclerView.Adapter<SituationsAdapter.SituationsViewHolder>() {


    inner class SituationsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val img : ImageView = itemView.findViewById(R.id.imgSituation)
        val name : TextView = itemView.findViewById(R.id.txtSituation)
    }

    fun setFilteredList(mList: List<SituationsData>) {
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SituationsViewHolder {
        val view = LayoutInflater.from(parent.context). inflate(R.layout.search_item, parent, false)
        return SituationsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SituationsViewHolder, position: Int) {
        val currentItem = mList[position]
        holder.img.setImageResource(currentItem.img)
        holder.name.text = currentItem.name
    }



    override fun getItemCount(): Int {
        return mList.size
    }
}