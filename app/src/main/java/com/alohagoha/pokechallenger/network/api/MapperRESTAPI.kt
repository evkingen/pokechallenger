package com.alohagoha.pokechallenger.network.api

import com.alohagoha.pokechallenger.domain.entities.Pokemon
import com.alohagoha.pokechallenger.network.api.DTO.PokemonAPI
import com.alohagoha.pokechallenger.repository.mappers.ListMapper

class MapperRESTAPI : ListMapper<PokemonAPI, Pokemon> {
    override fun map(item: List<PokemonAPI>): List<Pokemon> = item.map {
        Pokemon(id = it.id, name = it.name)
    }
}