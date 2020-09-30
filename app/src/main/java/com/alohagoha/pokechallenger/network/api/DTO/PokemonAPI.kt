package com.alohagoha.pokechallenger.network.api.DTO

import com.google.gson.annotations.SerializedName

data class PokemonAPI(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val name: String?
)