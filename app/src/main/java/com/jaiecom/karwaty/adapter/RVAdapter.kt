package com.jaiecom.karwaty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jaiecom.karwaty.R


class RVAdapter : RecyclerView.Adapter<RVAdapter.MyViewHolder>() {


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvTitle: TextView = itemView.findViewById(R.id.tv_title)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listss.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model = listss[position]

        holder.tvTitle.text = model

        holder.tvTitle.setOnClickListener(View.OnClickListener {
            // model.selected(!model.selected(!model.selected()))
            // holder.tvTitle.setBackgroundColor(if (model.selected) Color.CYAN else Color.WHITE)
        })
    }

    fun setListData(convenienceComfert: ArrayList<String>) {
        listss = convenienceComfert
    }


    var listss = ArrayList<String>()

}