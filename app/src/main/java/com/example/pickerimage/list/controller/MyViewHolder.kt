package com.example.pickerimage.list.controller

import android.content.Context
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pickerimage.R
import com.example.pickerimage.list.MyModel

class MyViewHolder(view: View, val context: Context) : RecyclerView.ViewHolder(view) {

    private val txt_name: TextView = view.findViewById(R.id.txt_name_item)
    private val txt_family: TextView = view.findViewById(R.id.txt_family_item)
    private val root: RelativeLayout = view.findViewById(R.id.item_root)

    fun bindData(model: MyModel) {

        txt_name.text = model.name
        txt_family.text = model.family
    }

    fun setOnListHolderListener(listener: ListItemInterAction?, model: MyModel) {

        root.setOnClickListener {
            listener?.itemOnClick(model)
        }

    }
}