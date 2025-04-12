package edu.nku.classapp.data.repository

import edu.nku.classapp.data.model.HarryPotterApiResponse

interface HarryPotterRepository {
    suspend fun getCharacters(): HarryPotterApiResponse
    
    suspend fun getCharacterById(id: String): HarryPotterApiResponse
}