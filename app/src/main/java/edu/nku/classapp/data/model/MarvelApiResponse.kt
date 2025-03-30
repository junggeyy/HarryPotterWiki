package edu.nku.classapp.data.model

import edu.nku.classapp.model.MarvelCharacterResponse

sealed class MarvelApiResponse {
    data class Success(val characters: List<MarvelCharacterResponse.Character>) :
        MarvelApiResponse()

    data object Error : MarvelApiResponse()
}