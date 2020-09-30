package com.alohagoha.pokechallenger.repository

import com.alohagoha.pokechallenger.domain.entities.Pokemon
import io.reactivex.rxjava3.core.Single

interface PokemonDataSource {

    fun getPokemonsData(): Single<List<Pokemon>>

}