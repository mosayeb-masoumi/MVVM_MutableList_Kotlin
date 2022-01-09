package com.example.pickerimage.list

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pickerimage.R
import com.example.pickerimage.list.controller.ListItemInterAction
import com.example.pickerimage.list.controller.MyAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() , ListItemInterAction{

   var context : Context? = null
   var viewModel : ListViewModel? = null
   private var myAdapter: MyAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        this.context = this@ListActivity
        viewModel = ListViewModel(context as ListActivity)

        getData()

    }

    private fun getData() {
        viewModel!!.getData().observe(this) { myList ->
            if (myList != null) {
                setRecyClerView(myList)
            }
        }
    }


    private fun setRecyClerView(myList: List<MyModel>) {

        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = layoutManager
        myAdapter = MyAdapter(myList as MutableList<MyModel>, context!!)
        myAdapter!!.setListener(this)
        recyclerView.adapter = myAdapter


    }

    override fun itemOnClick(model: MyModel) {
        Toast.makeText(context,model.name+" clicked",Toast.LENGTH_SHORT).show()
    }
}