package edu.nku.classapp.data

import edu.nku.classapp.model.HarryPotterCharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface HarryPotterApi {
    @GET("api/characters")
    suspend fun getCharacters(): Response<List<HarryPotterCharacterResponse.CharacterResponseItem>>

    @GET("api/character/{id}")
    suspend fun getCharacterById(@Path("id") id: String): Response<List<HarryPotterCharacterResponse.CharacterResponseItem>>

}