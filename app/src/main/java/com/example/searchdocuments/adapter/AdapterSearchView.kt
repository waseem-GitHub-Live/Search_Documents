package com.example.searchdocuments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.searchdocuments.R
import com.example.searchdocuments.data.DataClassSearch

class AdapterSearchView (var mList: List<DataClassSearch>): RecyclerView.Adapter<AdapterSearchView.MyViewHolder>(){
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.documentimage)
        val textViewTag: TextView =itemView.findViewById(R.id.TAGMAIN)
        val textViewdate: TextView =itemView.findViewById(R.id.DATEd)
        val textViewtime: TextView =itemView.findViewById(R.id.Timed)
        val sharebutton: ImageView =itemView.findViewById(R.id.shared)
        val optionbutton: ImageView =itemView.findViewById(R.id.optiond)
    }
    fun setFilteredList(mList: List<DataClassSearch>){
        this.mList = mList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.items_search, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return mList.size

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val imageResourceId = mList[position]
        holder.imageView.setImageResource(imageResourceId.logo)
        holder.textViewTag.text= mList[position].title
        holder.textViewdate.text
        holder.textViewtime.text = "haudaudaududhaudhdh"
        holder.sharebutton.setOnClickListener {
        }
        holder.optionbutton.setOnClickListener {
        }
    }
}