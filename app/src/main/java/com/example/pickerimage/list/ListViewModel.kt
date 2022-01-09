package com.example.pickerimage.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ListViewModel(context: ListActivity) {

   var repository : ListRepository? = ListRepository(context)
   var mutableLiveData: MutableLiveData<List<MyModel>> = MutableLiveData<List<MyModel>>()


   fun getData(): LiveData<List<MyModel>?> {
      mutableLiveData = repository!!.getData()
      return mutableLiveData
   }

}