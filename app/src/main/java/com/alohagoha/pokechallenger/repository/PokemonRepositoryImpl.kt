package com.alohagoha.pokechallenger.repository

class PokemonRepositoryImpl(val dataSource: PokemonDataSource) : PokemonRepository {
    override fun getAllPokemons() = dataSource.getPokemonsData()
}