package com.appsquadz.mvvmwithretrofit.model

data class MenuMaster(
    var id:String,
    var menu_title:String,
    var menu_type_id:String,
    var type:String,
    var list:MutableList<MenuTypeList>
)
