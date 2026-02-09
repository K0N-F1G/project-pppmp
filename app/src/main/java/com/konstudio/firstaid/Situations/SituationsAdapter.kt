package com.konstudio.firstaid.Situations

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.konstudio.firstaid.Database.MainDb
import com.konstudio.firstaid.R
import com.konstudio.firstaid.Situations.Multipage.MP_UBP_Activity
import com.konstudio.firstaid.Situations.Onepage.OP_UBP_Activity
import com.konstudio.firstaid.Situations.Slidable.SLIDE_UBP_Activity

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
        holder.itemView.setOnClickListener {
            Thread {
                val db = MainDb.Companion.getDb(holder.itemView.context)
                val savedVariant = db.getDao().findByName("chosenVariant")?.value.toString()
                if (currentItem.name == "Устойчивое Боковое Положение") {
                    var intent = Intent(holder.itemView.context, MP_UBP_Activity::class.java)
                    if (savedVariant == "Одностраничный") {
                        intent = Intent(holder.itemView.context, OP_UBP_Activity::class.java)
                    } else if (savedVariant == "Пролистываемый") {
                        intent = Intent(holder.itemView.context, SLIDE_UBP_Activity::class.java)
                    }
                    holder.itemView.context.startActivity(intent)
                }
            }.start()
        }
    }



    override fun getItemCount(): Int {
        return mList.size
    }
}