package com.illabank.viewmodel

import androidx.lifecycle.ViewModel
import com.illabank.model.SliderImageModel
import com.illabank.repository.MainRepository
import kotlinx.coroutines.flow.Flow

class MainViewModel  : ViewModel() {

    private val repository = MainRepository()
    val dummyData: Flow<List<SliderImageModel>> = repository.getDummyData()

    fun fetchDummyData() {
        repository.fetchDummyData()
    }
}