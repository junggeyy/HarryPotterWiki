package edu.nku.classapp.data.repository

import edu.nku.classapp.data.HarryPotterApi
import edu.nku.classapp.data.model.HarryPotterApiResponse
import javax.inject.Inject

class HarryPotterRepositoryReal @Inject constructor(
    private val harryPotterApi: HarryPotterApi
) : HarryPotterRepository {
    override suspend fun getCharacters(): HarryPotterApiResponse {
        val result = harryPotterApi.getCharacters()
        return if (result.isSuccessful) {
            result.body()?.let {
                HarryPotterApiResponse.Success(it)
            } ?: HarryPotterApiResponse.Error
        } else {
            HarryPotterApiResponse.Error
        }
    }

    override suspend fun getCharacterById(id: String): HarryPotterApiResponse {
        val result = harryPotterApi.getCharacterById(id)
        return if (result.isSuccessful) {
            result.body()?.let { characterList ->
                HarryPotterApiResponse.SingleCharacterSuccess(characterList.first())
            } ?: HarryPotterApiResponse.Error
        } else {
            HarryPotterApiResponse.Error
        }
    }

}