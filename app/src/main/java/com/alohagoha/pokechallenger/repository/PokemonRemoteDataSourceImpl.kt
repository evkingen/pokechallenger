package com.alohagoha.pokechallenger.repository

import com.alohagoha.pokechallenger.domain.entities.Pokemon
import com.alohagoha.pokechallenger.network.api.DTO.PokemonAPI
import com.alohagoha.pokechallenger.network.api.PoGoServiceAPI
import com.alohagoha.pokechallenger.repository.mappers.ListMapper
import io.reactivex.rxjava3.schedulers.Schedulers

class PokemonRemoteDataSourceImpl(
    val service: PoGoServiceAPI,
    val pokemonMapper: ListMapper<PokemonAPI, Pokemon>
) : PokemonDataSource {

    override fun getPokemonsData() =
        service.getAllPokemons()
            .map { it.values.toList() }
            .map { pokemonMapper.map(it) }
            .subscribeOn(Schedulers.io())

}