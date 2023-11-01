package com.illabank.repository


import com.illabank.R
import com.illabank.model.MainDataItemModel
import com.illabank.model.SliderImageModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class MainRepository {
    private val dummyData = MutableStateFlow<List<SliderImageModel>>(emptyList())

    fun getDummyData(): Flow<List<SliderImageModel>> = dummyData

    fun fetchDummyData() {
        val data = listOf(
            SliderImageModel(
                R.drawable.bird,
                mutableListOf(
                    MainDataItemModel("Eagle"),
                    MainDataItemModel("Peacock"),
                    MainDataItemModel("Owl"),
                    MainDataItemModel("Pigeon"),
                    MainDataItemModel("Penguin"),
                    MainDataItemModel("Mallard"),
                    MainDataItemModel("Cuckoo"),
                    MainDataItemModel("Sparrow"),
                    MainDataItemModel("Crow"),
                    MainDataItemModel("Parrot"),
                    MainDataItemModel("Hen"),
                    MainDataItemModel("Swan"),
                    MainDataItemModel("Bluebird"),
                    MainDataItemModel("Gannet"),
                    MainDataItemModel("Oriole"),
                    MainDataItemModel("Weaverbird"),
                    MainDataItemModel("Catbird")
                )
            ),
            SliderImageModel(
                R.drawable.animal,
                mutableListOf(
                    MainDataItemModel("Lion"),
                    MainDataItemModel("Tiger"),
                    MainDataItemModel("Bear"),
                    MainDataItemModel("Crocodile"),
                    MainDataItemModel("Donkey"),
                    MainDataItemModel("Deer"),
                    MainDataItemModel("Cat"),
                    MainDataItemModel("Dog"),
                    MainDataItemModel("Goat"),
                    MainDataItemModel("Wolf"),
                    MainDataItemModel("Fox"),
                    MainDataItemModel("Leopard"),
                    MainDataItemModel("Elephant"),
                    MainDataItemModel("Horse"),
                    MainDataItemModel("Monkey")
                )
            ),
            SliderImageModel(
                R.drawable.flower,
                mutableListOf(
                    MainDataItemModel("Rose"),
                    MainDataItemModel("Jasmine"),
                    MainDataItemModel("Sunflower"),
                    MainDataItemModel("Lotus"),
                    MainDataItemModel("Lavender"),
                    MainDataItemModel("Marigold"),
                    MainDataItemModel("Hibiscus"),
                    MainDataItemModel("Millingtonia Hortensis")
                )
            )
        )

        dummyData.value = data
    }
}
