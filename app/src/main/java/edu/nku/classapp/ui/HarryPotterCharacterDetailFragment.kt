package edu.nku.classapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import edu.nku.classapp.R
import edu.nku.classapp.databinding.FragmentCharacterDetailBinding
import edu.nku.classapp.model.HarryPotterCharacterResponse
import edu.nku.classapp.viewmodel.HarryPotterCharacterDetailViewModel
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HarryPotterCharacterDetailFragment : Fragment() {
    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding
        get() = _binding!!

    private val harryPotterCharacterDetailViewModel:
            HarryPotterCharacterDetailViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)
        setUpObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val characterId = arguments?.getString(BUNDLE_ID) ?: return
        harryPotterCharacterDetailViewModel.fetchCharacter(characterId)
    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            harryPotterCharacterDetailViewModel.character.collect { event ->
                when (event) {
                    is HarryPotterCharacterDetailViewModel.HarryPotterCharacterDetailState.Loading -> {
                        binding.progressBar.isVisible = true
                        binding.errorMessage.isVisible = false
                        binding.root.isVisible = false
                    }

                    is HarryPotterCharacterDetailViewModel.HarryPotterCharacterDetailState.Success -> {
                        binding.progressBar.isVisible = false
                        binding.errorMessage.isVisible = false
                        binding.root.isVisible = true
                        bindCharacterDetails(event.character)
                    }

                    is HarryPotterCharacterDetailViewModel.HarryPotterCharacterDetailState.Failure -> {
                        binding.progressBar.isVisible = false
                        binding.errorMessage.isVisible = true
                        binding.root.isVisible = false
                    }
                }
            }
        }
    }


    private fun bindCharacterDetails(character: HarryPotterCharacterResponse.CharacterResponseItem) {
        binding.apply {
            characterNameDetail.text = getString(R.string.name, character.name)
            characterYearDetail.text = getString(R.string.birthYear, character.yearOfBirth)
            characterSpeciesDetail.text = getString(R.string.species, character.species)
            characterGenderDetail.text = getString(R.string.gender, character.gender)
            characterHouseDetail.text = getString(R.string.house, character.house ?: "Unknown")
            characterAncestryDetail.text =
                getString(R.string.ancestry, character.ancestry ?: "Unknown")
            characterActorDetail.text = getString(R.string.actor, character.actor)
            characterWandDetail.text = character.wand.let {
                getString(
                    R.string.wand,
                    "${it.wood ?: "Unknown"}, ${it.core}, Length: ${it.length ?: "Unknown"}"
                )
            } ?: getString(R.string.wand, "No wand information")

            Glide.with(requireContext())
                .load(character.image)
                .into(characterImageDetail)
        }
    }

    companion object {
        private const val BUNDLE_ID = "character_id"

        fun newInstance(id: String) = HarryPotterCharacterDetailFragment().apply {
            arguments = bundleOf(BUNDLE_ID to id)
        }
    }
}