package com.itis.task3

data class Album(
    val id: Int,
    val name: String,
    val year: String,
    var url: String
) {
    constructor() : this(0,"", "", "")
}
