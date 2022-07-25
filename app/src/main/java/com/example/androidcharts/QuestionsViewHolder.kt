package com.example.androidcharts

import android.graphics.Color
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.androidcharts.databinding.ItemBarAnswerBinding
import com.example.androidcharts.databinding.ItemPieAnswerBinding
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet

sealed class QuestionsViewHolder(binding: ViewBinding) : RecyclerView.ViewHolder(binding.root) {

    class BarViewHolder(private val binding: ItemBarAnswerBinding) : QuestionsViewHolder(binding) {
        fun bind(question: Question) {
            binding.txtQuestionDescription.text = question.description
            binding.txtQuestionTotalAnswers.text =
                "${String.format("%,d", question.totalAnswers)} respuestas"


            binding.itemBarChart.apply {
                this.setTouchEnabled(false)
                this.setPinchZoom(false)
                this.setDrawBarShadow(false)
                this.setDrawGridBackground(false)
                this.description = null
                this.axisLeft.apply {
                    this.isEnabled = true
                    this.textColor = Color.GRAY
                    this.textSize = 12f
                    this.labelCount = 5
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
                    this.labelCount = question.answers.size
                    this.valueFormatter = object : ValueFormatter() {
                        override fun getFormattedValue(value: Float): String {
                            return try {
                                "${question.answers[value.toInt()].percent}%"
                            } catch (e: Exception) {
                                "0%"
                            }
                        }
                    }
                }
            }

            val entries = question.answers.mapIndexed { index, answer ->
                BarEntry(index.toFloat(), answer.total.toFloat())
            }

            val dataset = BarDataSet(entries, "BarChart").apply {
                this.colors = Utils.getColors(binding.root.context)
                this.setDrawValues(false)
            }

            val data = BarData(listOf<IBarDataSet>(dataset)).apply {
                this.barWidth = 0.5f
            }

            binding.itemBarChart.apply {
                this.data = data
                this.setFitBars(true)
                this.invalidate()
            }


        }
    }

    class PieViewHolder(private val binding: ItemPieAnswerBinding) : QuestionsViewHolder(binding) {
        fun bind(question: Question) {
            binding.txtQuestionDescription.text = question.description
            binding.txtQuestionTotalAnswers.text =
                "${String.format("%,d", question.totalAnswers)} respuestas"

            binding.itemPieChart.apply {
                this.setTouchEnabled(false)
                this.setUsePercentValues(true)
                this.description = null
                this.setExtraOffsets(5f, 10f, 5f, 5f)
                this.dragDecelerationFrictionCoef = 0.95f
                this.isDrawHoleEnabled = false
                this.legend.isEnabled = false
            }

            val entries = question.answers.map { answer -> PieEntry(answer.total.toFloat()) }

            val pieDataSet = PieDataSet(entries, "PieChart").apply {
                this.sliceSpace = 0f
                this.selectionShift = 30f
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

            binding.itemPieChart.apply {
                this.data = pieData
                this.invalidate()
            }

            val footerAdapter = FooterChartAdapter()
            binding.chartFooterRecycler.apply {
                layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = footerAdapter
            }

            question.answers.mapIndexed { index, ans ->
                FooterChart(index, ans.total, ans.description)
            }.also { footerList ->
                footerAdapter.submitList(footerList)
            }
        }
    }
}