package com.example.androidcharts

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chart = findViewById<View>(R.id.barchart) as BarChart
        chart.apply {
            this.isEnabled = false
            this.setMaxVisibleValueCount(60)
            this.setPinchZoom(false)
            this.setDrawBarShadow(false)
            this.setDrawGridBackground(false)
            this.description = null
        }

        val xAxis = chart.xAxis
        xAxis.apply {
            position = XAxis.XAxisPosition.BOTTOM
            setDrawAxisLine(false)
            setDrawGridLines(false)
            valueFormatter = MyFormatter()
            labelCount = 4 // dinamic
        }

        chart.axisLeft.isEnabled = true
        chart.axisLeft.setDrawAxisLine(false)
        chart.axisRight.isEnabled = false
        chart.legend.isEnabled = false

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
        chart.data = data
        chart.setFitBars(true)
        chart.invalidate()

    }
}

class MyFormatter : ValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        return "$value%"
    }
}