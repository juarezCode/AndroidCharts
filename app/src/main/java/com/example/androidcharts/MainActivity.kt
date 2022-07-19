package com.example.androidcharts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidcharts.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val answerAdapter = AnswerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.answersRecycler.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = answerAdapter
        }

        answerAdapter.submitList(
            listOf(
                AnswerWrapper(
                    1,
                    1,
                    "1 ¿Que tantos dias a la semana te gusta ir a la oficina?",
                    "1562 respuestas",
                    listOf(
                        Answer(1, 2, 26, 194),
                        Answer(2, 4, 49, 402),
                        Answer(3, 5, 70, 1009),
                        Answer(4, 4, 35, 341),
                        Answer(5, 1, 17, 50)
                    )
                ), AnswerWrapper(
                    1,
                    2,
                    "1 ¿Que tantos dias a la semana te gusta ir a la oficina?",
                    "1562 respuestas",
                    listOf(
                        Answer(1, 2, 26, 194),
                        Answer(2, 4, 49, 402),
                        Answer(3, 5, 70, 1009),
                        Answer(4, 4, 35, 341),
                        Answer(5, 1, 17, 50)
                    )
                ),
                AnswerWrapper(
                    1, 2, "1 question", "20 answers", listOf(
                        Answer(1, 1, 100, 5),
                        Answer(2, 2, 100, 5),
                        Answer(3, 3, 100, 10),
                        Answer(4, 4, 100, 10),
                        Answer(5, 5, 100, 10),
                        Answer(6, 5, 100, 10),
                        Answer(7, 5, 100, 10),
                        Answer(8, 5, 100, 10),
                        Answer(9, 5, 100, 10),
                        Answer(10, 5, 100, 10)
                    )
                ),
                AnswerWrapper(
                    1, 2, "1 question", "20 answers", listOf(
                        Answer(1, 1, 5, 5),
                        Answer(2, 2, 5, 5),
                        Answer(3, 3, 10, 5)
                    )
                )
            )
        )
    }
}