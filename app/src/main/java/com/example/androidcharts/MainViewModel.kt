package com.example.androidcharts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _task: MutableLiveData<Task> = MutableLiveData()
    val task: LiveData<Task> get() = _task

    init {
        _task.value = Task(
            1,
            30257,
            "Prueba para Jalmolonga",
            "Esto es para una prueba para Jalmolonga, espero les guste a todos, gracias por contestar",
            "2022-07-15",
            "2022-07-19",
            listOf(
                Question(
                    1,
                    18,
                    "1.1 ¿Que gustan los gatos?",
                    200,
                    null,
                    null,
                    listOf(
                        Answer(
                            1,
                            "si, claro son los mejores amigos del hombre, arriba los michis",
                            75, 150

                        ),
                        Answer(2, "no, dejan mucho pelo suelto", 25, 50),
                    )
                ),
                Question(
                    2,
                    19,
                    "1.2 ¿Que gustan los gatos?",
                    200,
                    null,
                    null,
                    listOf(
                        Answer(1, "si, claro son los mejores amigos del hombre", 75, 150),
                        Answer(2, "no, dejan mucho pelo suelto", 25, 50),
                    )
                ),
                Question(
                    3,
                    18,
                    "1 ¿Que tantos dias a la semana te gusta ir a la oficina?",
                    1562,
                    null,
                    null,
                    listOf(
                        Answer(1, "1 dia", 9, 194),
                        Answer(2, "2 dias", 20, 402),
                        Answer(3, "3 dias", 50, 1009),
                        Answer(4, "4 dias", 17, 341),
                        Answer(5, "5 dias", 2, 50)
                    )
                ), Question(
                    4,
                    19,
                    "1 ¿Que tantos dias a la semana te gusta ir a la oficina?",
                    1562,
                    null,
                    null,
                    listOf(
                        Answer(1, "1 dia", 9, 194),
                        Answer(2, "2 dias", 20, 402),
                        Answer(3, "3 dias", 50, 1009),
                        Answer(4, "4 dias", 17, 341),
                        Answer(5, "5 dias", 2, 50)
                    )
                ),
                Question(
                    5,
                    18,
                    "3 ¿Que calificacion le das a tu lider?",
                    10000,
                    null,
                    null,
                    listOf(
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
                Question(
                    6,
                    19,
                    "3 ¿Que calificacion le das a tu lider?",
                    10000,
                    null,
                    null,
                    listOf(
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
                Question(
                    id = 7,
                    type = 18,
                    description = "4 ¿como prefieres trabajar?",
                    totalAnswers = 100,
                    totalPages = null,
                    actualPage = null,
                    answers = listOf(
                        Answer(1, "oficina", 0, 0),
                        Answer(2, "hibrido", 20, 20),
                        Answer(3, "remoto", 80, 80)
                    )
                ),
                Question(
                    8, 19, "4 ¿como prefieres trabajar?", 100, null, null, listOf(
                        Answer(1, "oficina", 0, 0),
                        Answer(2, "hibrido", 20, 20),
                        Answer(3, "remoto", 80, 80)
                    )
                )
            )
        )
    }

}