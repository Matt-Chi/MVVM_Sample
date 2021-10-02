package com.example.mvvm_sample.response

class PostResponse : ArrayList<PostResponseItem>()

data class PostResponseItem(
    var body: String,
    var id: Int,
    var title: String,
    var userId: Int
)