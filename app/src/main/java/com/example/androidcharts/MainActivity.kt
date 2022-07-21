package com.example.androidcharts

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidcharts.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    private val answerAdapter = AnswerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerTaskAnswers.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = answerAdapter
        }

        viewModel.task.observe(this) { task ->
            with(binding) {
                txtTaskTotalAnswers.text = "${task.totalAnswers} respuestas"
                txtTaskDates.text = "${task.startDate} - ${task.endDate}"
                txtTaskTitle.text = task.title
                txtTaskDescription.text = task.description
            }

            answerAdapter.submitList(task.questions)
        }
    }
}