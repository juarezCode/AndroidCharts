package com.example.androidcharts

data class AnswerWrapper(
    val id: Int,
    val question: String,
    val totalQuestions: String,
    val answers: List<Answer>
)

data class Answer(
    val id: Int,
    val option: Int,
    val percent: Int,
    val total: Int
)
