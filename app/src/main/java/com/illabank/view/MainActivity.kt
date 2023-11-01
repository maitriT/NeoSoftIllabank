package com.illabank.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.illabank.viewmodel.MainViewModel
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.illabank.adapters.MainDataListAdapter
import com.illabank.adapters.MainSliderImageAdapter
import com.illabank.databinding.ActivityMainBinding
import com.illabank.model.MainDataItemModel
import com.illabank.model.SliderImageModel
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var sliderListAdapter: MainSliderImageAdapter
    private lateinit var dataListAdapter: MainDataListAdapter
    private var originalList = mutableListOf<MainDataItemModel>()
    private var originalSliderList = mutableListOf<SliderImageModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Trigger data fetch
        viewModel.fetchDummyData()
        attachObservers()

    }

    private fun setupView() {
        sliderListAdapter =
            MainSliderImageAdapter(originalSliderList)
        binding.viewPager.adapter = sliderListAdapter

        binding.viewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                originalList.clear()
                originalList.addAll(originalSliderList[position].dummyList)
                setUpMainDataAdapter(originalList)

            }

        })

        TabLayoutMediator(binding.tabsIndicator, binding.viewPager) { _, _ ->

        }.attach()

        setUpSearch()

    }

    private fun setUpSearch() {
        binding.searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrEmpty()) {
                    dataListAdapter.updateList(originalList)
                } else {
                    dataListAdapter.search(newText)
                }
                return true
            }
        })

    }

    private fun attachObservers() {
        lifecycleScope.launch {
            viewModel.dummyData.collect { data ->
                originalSliderList.addAll(data)
                setupView()
                originalList.addAll(data[0].dummyList)
                setUpMainDataAdapter(originalList)
            }
        }
    }


    fun setUpMainDataAdapter(dataModel: List<MainDataItemModel>) {
        dataListAdapter = MainDataListAdapter(dataModel)
        binding.rvDataList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = dataListAdapter
            isNestedScrollingEnabled = true
        }
    }


}