package edu.nku.classapp.data.model

import edu.nku.classapp.model.HarryPotterCharacterResponse

sealed class HarryPotterApiResponse {
    data class Success(val characters: List<HarryPotterCharacterResponse.CharacterResponseItem>) :
        HarryPotterApiResponse()

    data class SingleCharacterSuccess(val character: HarryPotterCharacterResponse.CharacterResponseItem) :
        HarryPotterApiResponse()

    data object Error : HarryPotterApiResponse()
}