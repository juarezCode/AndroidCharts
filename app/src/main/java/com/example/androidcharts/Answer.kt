package com.example.androidcharts

import com.google.gson.annotations.SerializedName

data class Task(
    @SerializedName("id_task") val id: Int,
    @SerializedName("total_answers") val totalAnswers: Int,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("start_date") val startDate: String,
    @SerializedName("end_date") val endDate: String,
    @SerializedName("questions") val questions: List<Question>
)

data class Question(
    @SerializedName("id_question") val id: Int,
    @SerializedName("type") val type: Int,
    @SerializedName("description") val description: String,
    @SerializedName("total_answers") val totalAnswers: Int,
    @SerializedName("total_pages") val totalPages: Int?,
    @SerializedName("actual_page") val actualPage: Int?,
    @SerializedName("answers") val answers: List<Answer>
)

data class Answer(
    @SerializedName("id_answer") val id: Int?,
    @SerializedName("description") val description: String,
    @SerializedName("percent") val percent: Int,
    @SerializedName("total") val total: Int
)
