package com.example.androidcharts

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidcharts.databinding.ItemAnswerBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
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

        with(holder.binding) {
            txtQuestion.text = answer.question
            txtTotalAnswers.text = answer.totalQuestions
        }

        if (answer.type == 1) {

            with(holder) {
                binding.itemPieChart.apply {
                    this.isVisible = true
                    this.setTouchEnabled(false)
                    this.setUsePercentValues(true)
                    this.description = null
                    this.setExtraOffsets(5f, 10f, 5f, 5f)
                    this.dragDecelerationFrictionCoef = 0.95f
                    this.isDrawHoleEnabled = false
                    this.legend.isEnabled = false
                }

                val entries = mutableListOf<PieEntry>()

                answer.answers.map {
                    entries.add(PieEntry(it.total.toFloat()))
                }

                val pieDataSet = PieDataSet(entries, "PieChart").apply {
                    this.sliceSpace = 0f
                    this.selectionShift = 20f
                    this.colors = Utils.getColors(binding.root.context)
                    this.valueLinePart1OffsetPercentage = 100f
                    this.valueLinePart1Length = 0.7f
                    this.valueLinePart2Length = 0.3f
                    this.yValuePosition = PieDataSet.ValuePosition.OUTSIDE_SLICE
                }

                val pieData = PieData(pieDataSet).apply {
                    this.setValueTextSize(14f)
                    this.setValueTextColor(Color.GRAY)
                    this.setValueFormatter(object : ValueFormatter() {
                        override fun getFormattedValue(value: Float): String {
                            return "${value.toInt()}%"
                        }
                    })
                }

                binding.itemPieChart.data = pieData
                binding.itemPieChart.highlightValues(null)
                binding.itemPieChart.invalidate()
            }
            return
        }

        if (answer.type == 2) {
            with(holder) {
                binding.itemBarChart.apply {
                    this.isVisible = true
                    this.setTouchEnabled(false)
                    this.setPinchZoom(false)
                    this.setDrawBarShadow(false)
                    this.setDrawGridBackground(false)
                    this.description = null
                    this.axisLeft.apply {
                        this.isEnabled = true
                        this.textColor = Color.GRAY
                        this.textSize = 12f
                        this.labelCount = answer.answers.size
                        this.axisMinimum = 0f
                    }
                    this.axisLeft.setDrawAxisLine(false)
                    this.axisRight.isEnabled = false
                    this.legend.isEnabled = false
                    this.xAxis.apply {
                        this.position = XAxis.XAxisPosition.BOTTOM
                        this.setDrawAxisLine(false)
                        this.setDrawGridLines(false)
                        this.textSize = 12f
                        this.textColor = Color.GRAY
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

                val dataset = BarDataSet(entries, "BarChart").apply {
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
    }

    object DiffCallback : DiffUtil.ItemCallback<AnswerWrapper>() {
        override fun areItemsTheSame(oldItem: AnswerWrapper, newItem: AnswerWrapper) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: AnswerWrapper, newItem: AnswerWrapper) =
            oldItem == newItem
    }

}