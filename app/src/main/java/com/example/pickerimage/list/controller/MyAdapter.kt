package com.example.pickerimage.list.controller

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pickerimage.R
import com.example.pickerimage.list.MyModel

class MyAdapter(private val list: MutableList<MyModel>, val context: Context) :  RecyclerView.Adapter<MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return MyViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val model = list[position]
        holder.bindData(model)
        holder.setOnListHolderListener(listener, model)
    }

    private var listener: ListItemInterAction? = null
    fun setListener(listener: ListItemInterAction) {
        this.listener = listener
    }

    override fun getItemCount(): Int {
        return list.size
    }
}