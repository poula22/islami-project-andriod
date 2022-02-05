package com.example.islamiproject.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiproject.ConstantKeys.Constant
import com.example.islamiproject.R
import com.example.islamiproject.SuraContent
import com.example.islamiproject.data_classes.QuranDataItem
import com.example.islamiproject.recycle_views.QuranAdapter

class QuranFragment(val items:MutableList<QuranDataItem>):Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var quranAdapter:QuranAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=layoutInflater.inflate(R.layout.quran_fragment,container,false)
        recyclerView= view?.findViewById(R.id.quran_recycle_view)!!
        quranAdapter= QuranAdapter(items)
        recyclerView.adapter=quranAdapter
        quranAdapter.itemClickLisener=object :QuranAdapter.ItemClickLisener{
            override fun onItemClick(item: QuranDataItem, pos: Int) {
                showSuraDetails(item,pos)
            }

        }
        return view
    }

    private fun showSuraDetails(item: QuranDataItem, pos: Int) {
        var intent=Intent(requireActivity(),SuraContent::class.java)
        intent.putExtra(Constant.sura_name,item.name)
        intent.putExtra(Constant.sura_pos,pos)
        startActivity(intent)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}