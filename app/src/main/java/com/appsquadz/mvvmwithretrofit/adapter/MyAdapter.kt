package com.appsquadz.mvvmwithretrofit.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.appsquadz.mvvmwithretrofit.databinding.ItemChannelBinding
import com.appsquadz.mvvmwithretrofit.model.MenuMaster
import com.appsquadz.mvvmwithretrofit.onboarding.OnBoardingApplication.Companion.initializer
import javax.inject.Inject

class MyAdapter @Inject constructor() : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

     var menuMasterListInAdapter: List<MenuMaster> = emptyList()

    inner class ViewHolder(internal val binding : ItemChannelBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemChannelBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(menuMasterListInAdapter[position]){
                binding.menuTitle.text = this.menu_title
                binding.recyclerView.layoutManager = LinearLayoutManager(initializer,LinearLayoutManager.HORIZONTAL,false)
                binding.recyclerView.adapter = MyAdapter2(initializer,this.list,this.menu_type_id)
            }
        }
    }

    override fun getItemCount() :Int {
        return menuMasterListInAdapter.size
    }
}