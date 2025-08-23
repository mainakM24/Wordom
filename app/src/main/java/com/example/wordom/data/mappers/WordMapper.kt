package com.example.wordom.data.mappers

import com.example.wordom.data.local.models.WordEntity
import com.example.wordom.domain.models.Word

fun WordEntity.toDomain() : Word {
    return Word(
        name = this.name,
        partsOfSpeech = this.partsOfSpeech,
        definition = this.definition,
        date = this.date
    )
}

fun List<WordEntity>.toDomainList() : List<Word> {
    return this.map { it.toDomain() }
}