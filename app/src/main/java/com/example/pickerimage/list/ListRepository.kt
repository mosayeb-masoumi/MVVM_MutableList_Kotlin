package com.example.pickerimage.list

import android.content.Context
import androidx.lifecycle.MutableLiveData
import java.util.ArrayList

class ListRepository(context: ListActivity) {

    var mutableLiveData: MutableLiveData<List<MyModel>> = MutableLiveData<List<MyModel>>()
    var context : Context? = context

    fun getData(): MutableLiveData<List<MyModel>> {

        // call server
        val list: MutableList<MyModel> = ArrayList()
        list.add(MyModel("ali" , "rezai"))
        list.add(MyModel("mina" , "madadi"))
        list.add(MyModel("yas" , "yasi"))

        mutableLiveData.value = list
        return mutableLiveData

    }

}