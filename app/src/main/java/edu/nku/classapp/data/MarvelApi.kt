package edu.nku.classapp.data

import edu.nku.classapp.model.MarvelCharacterResponse
import retrofit2.Response
import retrofit2.http.GET

interface MarvelApi {
    @GET("/api/character")
    suspend fun getCharacters(): Response<MarvelCharacterResponse>

}