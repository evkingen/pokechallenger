package com.alohagoha.pokechallenger.repository.mappers

interface ListMapper<I, O> : Mapper<List<I>, List<O>> {
    override fun map(item: List<I>): List<O>
}