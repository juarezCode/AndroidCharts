package com.example.androidcharts

data class AnswerWrapper(
    val id: Int,
    val type: Int,
    val question: String,
    val totalAnswers: Int,
    val answers: List<Answer>
)

data class Answer(
    val id: Int,
    val answer: String,
    val percent: Int,
    val total: Int
)
