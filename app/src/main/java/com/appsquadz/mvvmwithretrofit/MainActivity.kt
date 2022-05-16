package com.appsquadz.mvvmwithretrofit

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.appsquadz.mvvmwithretrofit.adapter.MyAdapter
import com.appsquadz.mvvmwithretrofit.databinding.ActivityMainBinding
import com.appsquadz.mvvmwithretrofit.viewmodel.MenuMasterViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val menuMasterViewModel: MenuMasterViewModel by viewModels()

    @Inject
    lateinit var myAdapter: MyAdapter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setViews()
        observerMenuMaster()
    }

    private fun setViews() {
        with(binding) {
            this.swipeRefreshLayout.setOnRefreshListener {
                menuMasterViewModel.getMenuMasterData()
            }
            with(this.recyclerView) {
                this.layoutManager = LinearLayoutManager(this@MainActivity)
                this.adapter = MyAdapter()
            }
        }
    }

    private fun observerMenuMaster() {
        menuMasterViewModel.liveMenuMasterData.observe(this) { menuMasterList ->
            menuMasterList?.let {
                with(binding) {
                    recyclerView.apply {
                        with(myAdapter) {
                            menuMasterListInAdapter = it
                            this@apply.adapter = this
                        }
                    }
                    swipeRefreshLayout.isRefreshing = false
                }
            }
        }
    }

}