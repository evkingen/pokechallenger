package com.alohagoha.pokechallenger.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alohagoha.pokechallenger.domain.entities.Pokemon
import com.alohagoha.pokechallenger.repository.PokemonRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class PokemonViewModel(val repository: PokemonRepository) : ViewModel() {

    private val pokemonList: MutableLiveData<List<Pokemon>> = MutableLiveData()
    private val choosenPokemon: MutableLiveData<Pokemon> = MutableLiveData()

    fun getPokemons(): LiveData<List<Pokemon>> = pokemonList

    fun getCurrentPokemon(): LiveData<Pokemon> = choosenPokemon

    fun fetchPokemonList() {
        repository.getAllPokemons()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { t -> pokemonList.value = t }
    }


    fun fetchCurrentPokemon(id: Int) {
        choosenPokemon.value = pokemonList.value?.get(id)
    }

}