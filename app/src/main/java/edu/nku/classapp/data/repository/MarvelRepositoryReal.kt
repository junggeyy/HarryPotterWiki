package edu.nku.classapp.data.repository

import edu.nku.classapp.data.MarvelApi
import edu.nku.classapp.data.model.MarvelApiResponse
import javax.inject.Inject

class MarvelRepositoryReal @Inject constructor(
    private val marvelApi: MarvelApi
) : MarvelRepository {
    override suspend fun getCharacters(): MarvelApiResponse {
        val result = marvelApi.getCharacters()
        return if (result.isSuccessful) {
            // if no info and result, and just result- just return result?.body()
            MarvelApiResponse.Success(result.body()?.characters ?: emptyList())
        } else {
            MarvelApiResponse.Error
        }
    }
}