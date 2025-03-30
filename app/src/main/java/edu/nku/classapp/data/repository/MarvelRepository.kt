package edu.nku.classapp.data.repository

import edu.nku.classapp.data.model.MarvelApiResponse

interface MarvelRepository {
    suspend fun getCharacters(): MarvelApiResponse
}