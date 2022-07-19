package com.example.androidcharts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcharts.databinding.ItemChartFooterBinding

class FooterAdapter : ListAdapter<FooterChart, FooterAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(val binding: ItemChartFooterBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemChartFooterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val footer = getItem(position)

        with(holder) {
            binding.txtFooterTotal.text = footer.total.toString()
            binding.txtFooterQuestion.text = footer.question
            val colorsSize = Utils.getColors(binding.root.context).size
            if (footer.id >= colorsSize) {
                binding.txtFooterIndicator.setBackgroundColor(
                    Utils.getColors(binding.root.context)[1]
                )
            } else {
                binding.txtFooterIndicator.setBackgroundColor(Utils.getColors(binding.root.context)[footer.id])
            }
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<FooterChart>() {
        override fun areItemsTheSame(oldItem: FooterChart, newItem: FooterChart) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: FooterChart, newItem: FooterChart) =
            oldItem == newItem
    }
}