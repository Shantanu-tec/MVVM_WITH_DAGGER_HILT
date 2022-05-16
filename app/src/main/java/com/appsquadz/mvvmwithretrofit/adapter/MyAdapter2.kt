package com.appsquadz.mvvmwithretrofit.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.appsquadz.mvvmwithretrofit.databinding.*
import com.appsquadz.mvvmwithretrofit.model.MenuTypeList
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class MyAdapter2(val context: Context, private val menuTypeList: MutableList<MenuTypeList>,
                 private val MenuTypeId : String ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            1 -> EpisodesViewHolder(EpisodeItemBinding.inflate(LayoutInflater.from(context),parent,false))
            2 -> VideoViewHolder(VideoItemBinding.inflate(LayoutInflater.from(context),parent,false))
            3 -> ChannelViewHolder(ChannelItemBinding.inflate(LayoutInflater.from(context),parent,false))
            4 -> SeasonViewHolder(SeasonItemBinding.inflate(LayoutInflater.from(context),parent,false))
            5 -> BhajanViewHolder(BhajanItemBinding.inflate(LayoutInflater.from(context),parent,false))
            else -> GuruViewHolder(BhajanItemBinding.inflate(LayoutInflater.from(context),parent,false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            1 -> (holder as EpisodesViewHolder).setData(menuTypeList[position])
            2 -> (holder as VideoViewHolder).setData(menuTypeList[position])
            3 -> (holder as ChannelViewHolder).setData(menuTypeList[position])
            4 -> (holder as SeasonViewHolder).setData(menuTypeList[position])
            5 -> (holder as BhajanViewHolder).setData(menuTypeList[position])
            else -> (holder as GuruViewHolder).setData(menuTypeList[position])
        }
    }

    override fun getItemCount(): Int {
       return menuTypeList.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (MenuTypeId){
            "10" -> 1
            "3" -> 2
            "11" -> 2
            "1" -> 3
            "6" -> 4
            "12" -> 5
            "5" -> 6
            else -> -1
        }
    }

    inner class ChannelViewHolder(private val binding: ChannelItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun setData(menuTypeList: MenuTypeList){
            Glide.with(context)
                .load(menuTypeList.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imageView)
        }

    }
    inner class VideoViewHolder(private val binding: VideoItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(menuTypeList:MenuTypeList){
            Glide.with(context)
                .load(menuTypeList.thumbnail_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imageView)
        }
    }
    inner class SeasonViewHolder(private val binding: SeasonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(menuTypeList: MenuTypeList){
            Glide.with(context)
                .load(menuTypeList.season_thumbnail)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imageView)
        }
    }
    inner class EpisodesViewHolder(private val binding: EpisodeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(menuTypeList:MenuTypeList){
            Glide.with(context)
                .load(menuTypeList.thumbnail_url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imageView)
        }
    }
    inner class BhajanViewHolder(private val binding: BhajanItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(menuTypeList:MenuTypeList){
            Glide.with(context)
                .load(menuTypeList.thumbnail1)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imageView)
        }
    }

    inner class GuruViewHolder(private val binding: BhajanItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(menuTypeList:MenuTypeList){
            Glide.with(context)
                .load(menuTypeList.profile_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.imageView)
        }
    }
}