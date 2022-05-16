package com.appsquadz.mvvmwithretrofit.interfaces

import com.appsquadz.mvvmwithretrofit.model.MainMenuMaster
import com.appsquadz.mvvmwithretrofit.utils.Apis
import com.appsquadz.mvvmwithretrofit.utils.Const
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {
    @FormUrlEncoded
    @POST(Apis.MENU_MASTER)
    suspend fun getMenuMaster(@Field(Const.USER_ID) user_id: String?): Response<MainMenuMaster>
}