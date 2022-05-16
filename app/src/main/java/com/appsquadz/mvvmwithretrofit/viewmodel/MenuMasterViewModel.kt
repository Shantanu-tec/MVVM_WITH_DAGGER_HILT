package com.appsquadz.mvvmwithretrofit.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appsquadz.mvvmwithretrofit.model.MenuMaster
import com.appsquadz.mvvmwithretrofit.repository.MenuMasterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuMasterViewModel @Inject constructor(private var repository: MenuMasterRepository) : ViewModel() {

    private var menuMasterList: MutableLiveData<List<MenuMaster>> = MutableLiveData()

    fun getMenuMaster() = menuMasterList

    init {
        getMenuMasterData()
    }

     fun getMenuMasterData() {
         viewModelScope.launch {
             val result = repository.getData()

             when(result.isSuccessful){
                 true ->{
                     Log.e("shantanu", repository.getData().body().toString())
                     with(result.body()!!.data.orEmpty()){
                         menuMasterList.postValue(this)
                     }
                 }
                 else ->{
                     Log.e("shantanu","Error")
                 }
             }
         }
    }
}