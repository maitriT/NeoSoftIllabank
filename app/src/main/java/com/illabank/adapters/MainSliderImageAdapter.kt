package com.illabank.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.illabank.databinding.ItemSliderImageBinding
import com.illabank.model.SliderImageModel

class MainSliderImageAdapter (
    private val sliderImageModelList: List<SliderImageModel>
) : RecyclerView.Adapter<MainSliderImageAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemSliderImageBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSliderImageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            sliderImageModelList[position].imageUrl?.let { binding.ivBanner.setImageResource(it) }
        }
    }

    override fun getItemCount(): Int {
        return sliderImageModelList.size
    }
}