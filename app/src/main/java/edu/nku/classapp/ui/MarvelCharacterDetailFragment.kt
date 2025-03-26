package edu.nku.classapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import edu.nku.classapp.R
import edu.nku.classapp.databinding.FragmentCharacterDetailBinding
import edu.nku.classapp.viewmodel.MarvelCharacterViewModel

class MarvelCharacterDetailFragment : Fragment() {
    private var _binding: FragmentCharacterDetailBinding? = null
    private val binding
        get() = _binding!!

    private val marvelCharacterViewModel:
            MarvelCharacterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterDetailBinding.inflate(inflater, container, false)

        if (arguments != null) {
            val character = marvelCharacterViewModel.fetchById(
                requireArguments().getInt(BUNDLE_ID)
            )
            Glide.with(binding.root).load(character.picture).into(binding.characterImageDetail)
            binding.characterNameDetail.text =
                binding.root.context.getString(R.string.name, character.name)
            binding.characterAgeDetail.text =
                binding.root.context.getString(R.string.age, character.age)
            binding.characterPowerDetail.text =
                binding.root.context.getString(R.string.power, character.power)
            binding.characterPlanetDetail.text =
                binding.root.context.getString(R.string.planet, character.planet)
            binding.characterAliasDetail.text =
                binding.root.context.getString(R.string.alias, character.alias)
            binding.characterEnemyDetail.text =
                binding.root.context.getString(R.string.enemy, character.enemy)
            binding.characterCatchPhraseDetail.text =
                binding.root.context.getString(R.string.catchPhrase, character.catchPhrase)
        }

        return binding.root
    }

    companion object {
        private const val BUNDLE_ID = "character_id"

        fun newInstance(id: Int) = MarvelCharacterDetailFragment().apply {
            arguments = bundleOf(BUNDLE_ID to id)
        }
    }
}
