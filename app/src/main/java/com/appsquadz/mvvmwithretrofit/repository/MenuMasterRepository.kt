package com.appsquadz.mvvmwithretrofit.repository


import com.appsquadz.mvvmwithretrofit.interfaces.ApiInterface

class MenuMasterRepository(private val apiInterface: ApiInterface) {
    suspend fun getData() = apiInterface.getMenuMaster("163")
}