package com.alohagoha.pokechallenger.network.api

import com.alohagoha.pokechallenger.network.api.DTO.PokemonAPI
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

//https://pogoapi.net
interface PoGoServiceAPI {

    //all pokemons
    @GET("api/v1/pokemon_names.json")
    fun getAllPokemons(): Single<List<PokemonAPI>>
}