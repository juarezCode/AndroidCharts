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
                    AnswerType.PieChart,
                    "1.1 ¿Que gustan los gatos?",
                    200,
                    listOf(
                        Answer(
                            1,
                            "si, claro son los mejores amigos del hombre, arriba los michis",
                            75,
                            150
                        ),
                        Answer(2, "no, dejan mucho pelo suelto", 25, 50),
                    )
                ),
                AnswerWrapper(
                    2,
                    AnswerType.BarChart,
                    "1.2 ¿Que gustan los gatos?",
                    200,
                    listOf(
                        Answer(1, "si, claro son los mejores amigos del hombre", 75, 150),
                        Answer(2, "no, dejan mucho pelo suelto", 25, 50),
                    )
                ),
                AnswerWrapper(
                    3,
                    AnswerType.PieChart,
                    "1 ¿Que tantos dias a la semana te gusta ir a la oficina?",
                    1562,
                    listOf(
                        Answer(1, "1 dia", 9, 194),
                        Answer(2, "2 dias", 20, 402),
                        Answer(3, "3 dias", 50, 1009),
                        Answer(4, "4 dias", 17, 341),
                        Answer(5, "5 dias", 2, 50)
                    )
                ), AnswerWrapper(
                    4,
                    AnswerType.BarChart,
                    "1 ¿Que tantos dias a la semana te gusta ir a la oficina?",
                    1562,
                    listOf(
                        Answer(1, "1 dia", 9, 194),
                        Answer(2, "2 dias", 20, 402),
                        Answer(3, "3 dias", 50, 1009),
                        Answer(4, "4 dias", 17, 341),
                        Answer(5, "5 dias", 2, 50)
                    )
                ),
                AnswerWrapper(
                    5, AnswerType.PieChart, "3 ¿Que calificacion le das a tu lider?", 10000, listOf(
                        Answer(1, "1", 14, 1000),
                        Answer(2, "2", 10, 500),
                        Answer(3, "3", 7, 100),
                        Answer(4, "4", 15, 400),
                        Answer(5, "5", 3, 800),
                        Answer(6, "6", 6, 300),
                        Answer(7, "7", 7, 700),
                        Answer(8, "8", 10, 900),
                        Answer(9, "9", 3, 400),
                        Answer(10, "10", 3, 400),
                        Answer(11, "11", 10, 500),
                        Answer(12, "12", 8, 100),
                        Answer(13, "13", 9, 300),
                        Answer(14, "14", 3, 100),
                        Answer(15, "15", 7, 200)
                    )
                ),
                AnswerWrapper(
                    6, AnswerType.BarChart, "3 ¿Que calificacion le das a tu lider?", 10000, listOf(
                        Answer(1, "1", 14, 1000),
                        Answer(2, "2", 10, 500),
                        Answer(3, "3", 7, 100),
                        Answer(4, "4", 15, 400),
                        Answer(5, "5", 3, 800),
                        Answer(6, "6", 6, 300),
                        Answer(7, "7", 7, 700),
                        Answer(8, "8", 10, 900),
                        Answer(9, "9", 3, 400),
                        Answer(10, "10", 3, 400),
                        Answer(11, "11", 10, 500),
                        Answer(12, "12", 8, 100),
                        Answer(13, "13", 9, 300),
                        Answer(14, "14", 3, 100),
                        Answer(15, "15", 7, 200)
                    )
                ),
                AnswerWrapper(
                    id = 7,
                    type = AnswerType.PieChart,
                    question = "4 ¿como prefieres trabajar?",
                    totalAnswers = 100,
                    answers = listOf(
                        Answer(1, "oficina", 0, 0),
                        Answer(2, "hibrido", 5, 5),
                        Answer(3, "remoto", 75, 75)
                    )
                ),
                AnswerWrapper(
                    8, AnswerType.BarChart, "4 ¿como prefieres trabajar?", 100, listOf(
                        Answer(1, "oficina", 0, 0),
                        Answer(2, "hibrido", 5, 5),
                        Answer(3, "remoto", 75, 75)
                    )
                )
            )
        )
    }
}