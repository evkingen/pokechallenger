package com.alohagoha.pokechallenger.domain.entities

class PokemonDetails(
    val isReleased: Boolean = false,
    val isNested: Boolean = false,
    val isShiny: Boolean = false,
    val isRaidExclusive: Boolean = false,
    val isAlolan: Boolean = false,
    val isPossibleDitto: Boolean = false,
    val isLegendary: Boolean = false,
    val pokemonStats: PokemonStats? = null,
    val maxCP: Int? = null,
    val distanceCandy: Int? = null,
    val candyRequire: Int? = null,
    val type: List<String>? = null
)

