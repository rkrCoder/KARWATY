package com.jaiecom.karwaty.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jaiecom.karwaty.R

class RVGenInfoAdapter : RecyclerView.Adapter<RVGenInfoAdapter.MyViewHolder>() {


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvTitle: TextView = itemView.findViewById(R.id.text_info)
        val cb: CheckBox = itemView.findViewById(R.id.cb)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_gen_info_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return listss.size
    }






    var listss = ArrayList<String>()


    fun setListData(selectQualification: ArrayList<String>) {
        if (selectQualification != null) {
            selectQualification.also { listss = it }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val  model = listss[position]

        holder.tvTitle.text = model

        holder.tvTitle.setOnClickListener(View.OnClickListener {
            // model.selected(!model.selected(!model.selected()))
            // holder.tvTitle.setBackgroundColor(if (model.selected) Color.CYAN else Color.WHITE)
        })
    }
}