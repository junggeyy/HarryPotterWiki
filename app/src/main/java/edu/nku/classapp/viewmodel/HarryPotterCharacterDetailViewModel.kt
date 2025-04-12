package edu.nku.classapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.nku.classapp.data.model.HarryPotterApiResponse
import edu.nku.classapp.data.repository.HarryPotterRepository
import edu.nku.classapp.model.HarryPotterCharacterResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HarryPotterCharacterDetailViewModel @Inject constructor(
    private val harryPotterRepository: HarryPotterRepository
) : ViewModel() {

    private val _character =
        MutableStateFlow<HarryPotterCharacterDetailState>(HarryPotterCharacterDetailState.Loading)
    val character: StateFlow<HarryPotterCharacterDetailState> = _character.asStateFlow()


    fun fetchCharacter(id: String) = viewModelScope.launch {
        _character.value = HarryPotterCharacterDetailState.Loading

        when (val response = harryPotterRepository.getCharacterById(id)) {
            HarryPotterApiResponse.Error -> _character.value =
                HarryPotterCharacterDetailState.Failure

            is HarryPotterApiResponse.SingleCharacterSuccess -> _character.value =
                HarryPotterCharacterDetailState.Success(response.character)

            else -> _character.value = HarryPotterCharacterDetailState.Failure
        }
    }

    sealed class HarryPotterCharacterDetailState {
        data class Success(val character: HarryPotterCharacterResponse.CharacterResponseItem) :
            HarryPotterCharacterDetailState()

        data object Failure : HarryPotterCharacterDetailState()
        data object Loading : HarryPotterCharacterDetailState()
    }
}