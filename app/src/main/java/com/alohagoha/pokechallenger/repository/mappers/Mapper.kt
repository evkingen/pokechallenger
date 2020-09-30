package com.alohagoha.pokechallenger.repository.mappers

interface Mapper<I, O> {
    fun map(item: I): O
}