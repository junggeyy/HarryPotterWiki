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
class HarryPotterCharacterViewModel @Inject constructor(
    private val harryPotterRepository: HarryPotterRepository
) : ViewModel() {

    private val _characters =
        MutableStateFlow<HarryPotterCharacterState>(HarryPotterCharacterState.Loading)
    val characters: StateFlow<HarryPotterCharacterState> = _characters.asStateFlow()

    fun fillData() = viewModelScope.launch {
        when (val response = harryPotterRepository.getCharacters()) {
            HarryPotterApiResponse.Error -> _characters.value = HarryPotterCharacterState.Failure
            is HarryPotterApiResponse.Success -> _characters.value =
                HarryPotterCharacterState.Success(response.characters)

            else -> _characters.value = HarryPotterCharacterState.Failure
        }
    }

    sealed class HarryPotterCharacterState {
        data class Success(val characters: List<HarryPotterCharacterResponse.CharacterResponseItem>) :
            HarryPotterCharacterState()

        data object Failure : HarryPotterCharacterState()
        data object Loading : HarryPotterCharacterState()
    }

}