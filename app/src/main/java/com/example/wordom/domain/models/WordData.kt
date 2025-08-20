package com.example.wordom.domain.models

data class WordData(
    val word: String,
    val note: String,
    val pdd: String,
    val definitions: List<Definition>,
    val examples: List<Example>,
)

data class Definition(
    val text: String,
    val partOfSpeech: String,
)

data class Example(
    val text: String,
)