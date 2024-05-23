package com.mkrdeveloper.movieinfoappmvvm.models

data class Metadata(
    val current_page: String,
    val page_count: Int, //25
    val per_page: Int, //10
    val total_count: Int //250
)