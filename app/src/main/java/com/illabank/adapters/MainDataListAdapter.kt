package com.illabank.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.illabank.databinding.ItemListBinding
import com.illabank.model.MainDataItemModel

class MainDataListAdapter(
    private var mainDataItemModelList: List<MainDataItemModel>
) : RecyclerView.Adapter<MainDataListAdapter.ViewHolder>() {
    private var matchedData: ArrayList<MainDataItemModel> = arrayListOf()

    inner class ViewHolder(val binding: ItemListBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.tvLabel.text = mainDataItemModelList[position].title
        }
    }


    override fun getItemCount(): Int {
        return mainDataItemModelList.size
    }

    fun search(text: String?) {
        matchedData = arrayListOf()

        text?.let {
            mainDataItemModelList.forEach { data ->
                if (data.title.contains(text, true) ||
                    data.title.contains(text, true)
                ) {
                    matchedData.add(data)
                }
            }
            mainDataItemModelList = matchedData
            notifyDataSetChanged()
        }
    }

    fun updateList(dummyList: List<MainDataItemModel>) {
        mainDataItemModelList = dummyList
        notifyDataSetChanged()

    }
}