package com.example.mvvm_sample.response

class PostResponse : ArrayList<PostResponseItem>()

data class PostResponseItem(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)