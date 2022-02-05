package com.example.islamiproject.recycle_views

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiproject.R
import com.example.islamiproject.data_classes.QuranDataItem


class QuranAdapter(val items:MutableList<QuranDataItem>): RecyclerView.Adapter<QuranAdapter.QuranItemHolder> (){
    class QuranItemHolder(view: View):RecyclerView.ViewHolder(view){
        var textName:TextView=view.findViewById(R.id.name)
        var textCount:TextView=view.findViewById(R.id.count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuranItemHolder {
        var view:View= LayoutInflater.from(parent.context).inflate(R.layout.quran_recycler_view,parent,false)
        return QuranItemHolder(view)
    }

    override fun onBindViewHolder(holder: QuranItemHolder, position: Int) {
        var item=items.get(position)
        holder.textName.text=item.name
        holder.textCount.text=item.count
        if(itemClickLisener!=null){
            holder.textName.setOnClickListener {
                itemClickLisener?.onItemClick(item,position)
            }
        }
    }
    override fun getItemCount(): Int =items.size ?:0

    interface ItemClickLisener{
        fun onItemClick(item:QuranDataItem,pos:Int)
    }
    var itemClickLisener:ItemClickLisener?=null
}