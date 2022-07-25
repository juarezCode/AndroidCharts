package com.example.androidcharts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcharts.databinding.ItemBarAnswerBinding
import com.example.androidcharts.databinding.ItemPieAnswerBinding

class QuestionsAdapter : RecyclerView.Adapter<QuestionsViewHolder>() {

    var items = listOf<Question>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsViewHolder {
        return when (viewType) {
            R.layout.item_pie_answer -> QuestionsViewHolder.PieViewHolder(
                ItemPieAnswerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.item_bar_answer -> QuestionsViewHolder.BarViewHolder(
                ItemBarAnswerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else -> throw IllegalArgumentException("Invalid ViewType Provided")
        }
    }

    override fun onBindViewHolder(holder: QuestionsViewHolder, position: Int) {
        when (holder) {
            is QuestionsViewHolder.PieViewHolder -> holder.bind(items[position])
            is QuestionsViewHolder.BarViewHolder -> holder.bind(items[position])
        }
    }

    override fun getItemCount(): Int = items.size

    override fun getItemViewType(position: Int): Int {
        if (items[position].type == AnswerType.pieChart) return R.layout.item_pie_answer

        return R.layout.item_bar_answer
    }
}