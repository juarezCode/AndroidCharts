package com.example.androidcharts

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chart = findViewById<View>(R.id.barchart) as BarChart
        chart.apply {
            this.setTouchEnabled(false)
            this.setPinchZoom(false)
            this.setDrawBarShadow(false)
            this.setDrawGridBackground(false)
            this.description = null
            this.axisLeft.isEnabled = true
            this.axisLeft.setDrawAxisLine(false)
            this.axisRight.isEnabled = false
            this.legend.isEnabled = false
        }

        val pieChart = findViewById<View>(R.id.pieChart) as PieChart
        pieChart.apply {
            setTouchEnabled(false)
            setUsePercentValues(true)
            this.description = null
            setExtraOffsets(5f, 10f, 5f, 5f)
            dragDecelerationFrictionCoef = 0.95f
            isDrawHoleEnabled = false
            this.legend.isEnabled = false
        }

        chart.xAxis.apply {
            position = XAxis.XAxisPosition.BOTTOM
            setDrawAxisLine(false)
            setDrawGridLines(false)
            valueFormatter = MyFormatter()
            labelCount = 4 // dinamic
        }


        val entries = mutableListOf<BarEntry>()
        entries.add(BarEntry(1f, 1f))
        entries.add(BarEntry(2f, 2f))
        entries.add(BarEntry(3f, 10f))
        entries.add(BarEntry(4f, 15f))

        val dataset = BarDataSet(entries, "Cells")
        dataset.colors = mutableListOf(
            ContextCompat.getColor(this, android.R.color.holo_blue_light),
            ContextCompat.getColor(this, android.R.color.holo_green_light),
            ContextCompat.getColor(this, android.R.color.holo_orange_light),
            ContextCompat.getColor(this, android.R.color.holo_red_light),
        )
        dataset.setDrawValues(false)

        val dataSets = mutableListOf<IBarDataSet>()
        dataSets.add(dataset)

        val data = BarData(dataSets)
        data.barWidth = 0.5f
        data.isHighlightEnabled = false
        chart.data = data
        chart.setFitBars(true)
        chart.invalidate()

        val pieEntries = mutableListOf<PieEntry>()
        pieEntries.add(PieEntry(1f))
        pieEntries.add(PieEntry(1f))
        pieEntries.add(PieEntry(2f))
        pieEntries.add(PieEntry(1f))

        val pieDataSet = PieDataSet(pieEntries, "Pie Chart")
        pieDataSet.sliceSpace = 0f
        pieDataSet.selectionShift = 20f
        pieDataSet.colors = mutableListOf(
            ContextCompat.getColor(this, android.R.color.holo_blue_light),
            ContextCompat.getColor(this, android.R.color.holo_green_light),
            ContextCompat.getColor(this, android.R.color.holo_orange_light),
            ContextCompat.getColor(this, android.R.color.holo_red_light)
        )
        pieDataSet.valueLinePart1OffsetPercentage = 100f
        pieDataSet.valueLinePart1Length = 0.7f
        pieDataSet.valueLinePart2Length = 0.3f
        pieDataSet.yValuePosition = PieDataSet.ValuePosition.OUTSIDE_SLICE

        val pieData = PieData(pieDataSet)
        pieData.setValueFormatter(MyFormatter())
        pieData.setValueTextSize(11f)
        pieData.setValueTextColor(Color.BLACK)

        pieChart.data = pieData
        pieChart.highlightValues(null)
        pieChart.invalidate()

    }
}

class MyFormatter : ValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        return "$value%"
    }
}