package com.alohagoha.pokechallenger.domain.entities

data class Pokemon(
    val id: Int,
    val name: String,
    val pokemonDetails: PokemonDetails? = null
)