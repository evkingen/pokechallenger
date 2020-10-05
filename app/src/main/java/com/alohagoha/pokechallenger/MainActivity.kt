package com.alohagoha.pokechallenger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alohagoha.pokechallenger.UI.PokemonViewModel
import com.alohagoha.pokechallenger.domain.entities.Pokemon
import com.alohagoha.pokechallenger.network.api.MapperRESTAPI
import com.alohagoha.pokechallenger.network.api.PoGoRESTAPI
import com.alohagoha.pokechallenger.repository.PokemonRemoteDataSourceImpl
import com.alohagoha.pokechallenger.repository.PokemonRepositoryImpl
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), LifecycleOwner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = PoGoRESTAPI()
        val mapper = MapperRESTAPI()
        val dataSource = PokemonRemoteDataSourceImpl(service.getService(), mapper)
        val repository = PokemonRepositoryImpl(dataSource)
        val pokemonViewModel = ViewModelProvider(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(PokemonViewModel::class.java)) {
                    return PokemonViewModel(repository) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }).get(PokemonViewModel::class.java)

        pokemonViewModel.fetchPokemonList()
        val observer: Observer<Pokemon> = Observer {
            textView.text = it.name
        }
        pokemonViewModel.getCurrentPokemon().observe(this, observer)

        fetch_button.setOnClickListener {
            pokemonViewModel.fetchCurrentPokemon(et_pokemon_id.text.toString().toInt())
        }
    }


}