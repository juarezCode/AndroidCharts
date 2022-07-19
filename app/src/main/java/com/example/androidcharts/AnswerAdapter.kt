package com.example.androidcharts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcharts.databinding.ItemAnswerBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet

class AnswerAdapter : ListAdapter<AnswerWrapper, AnswerAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(val binding: ItemAnswerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemAnswerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val answer = getItem(position)

        with(holder) {
            binding.txtQuestion.text = answer.question
            binding.txtTotalAnswers.text = answer.totalQuestions


            binding.itemBarChart.apply {
                this.setTouchEnabled(false)
                this.setPinchZoom(false)
                this.setDrawBarShadow(false)
                this.setDrawGridBackground(false)
                this.description = null
                this.axisLeft.isEnabled = true
                this.axisLeft.setDrawAxisLine(false)
                this.axisRight.isEnabled = false
                this.legend.isEnabled = false
                this.xAxis.apply {
                    this.position = XAxis.XAxisPosition.BOTTOM
                    this.setDrawAxisLine(false)
                    this.setDrawGridLines(false)
                    this.labelCount = answer.answers.size
                    this.valueFormatter = object : ValueFormatter() {
                        override fun getFormattedValue(value: Float): String {
                            val answerFounded = answer.answers.find { it.id.toFloat() == value }
                            if (answerFounded == null) return "0%"
                            return "${answerFounded.percent}%"
                        }
                    }
                }
            }

            val entries = mutableListOf<BarEntry>()

            answer.answers.mapIndexed { index, answer ->
                entries.add(BarEntry(answer.id.toFloat(), answer.option.toFloat()))
            }

            val dataset = BarDataSet(entries, "Cells").apply {
                this.colors = Utils.getColors(binding.root.context)
                this.setDrawValues(false)
            }

            val data = BarData(listOf<IBarDataSet>(dataset)).apply {
                this.barWidth = 0.5f
            }

            binding.itemBarChart.data = data
            binding.itemBarChart.setFitBars(true)
            binding.itemBarChart.invalidate()
        }

    }

    object DiffCallback : DiffUtil.ItemCallback<AnswerWrapper>() {
        override fun areItemsTheSame(oldItem: AnswerWrapper, newItem: AnswerWrapper) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: AnswerWrapper, newItem: AnswerWrapper) =
            oldItem == newItem
    }

}