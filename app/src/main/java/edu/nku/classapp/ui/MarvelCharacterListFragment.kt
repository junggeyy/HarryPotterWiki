package edu.nku.classapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import edu.nku.classapp.R
import edu.nku.classapp.databinding.FragmentCharacterListBinding
import edu.nku.classapp.ui.adapter.MarvelCharacterAdapter
import edu.nku.classapp.viewmodel.MarvelCharacterViewModel

class MarvelCharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListBinding? = null
    private val binding
        get() = _binding!!

    private val marvelCharacterViewModel: MarvelCharacterViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)

        val characters = marvelCharacterViewModel.fillData()

        val adapter = MarvelCharacterAdapter(characters) { position ->
            val character = characters[position]
            requireActivity().supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragment_container_view,
                    MarvelCharacterDetailFragment.newInstance(character.id)
                )
                addToBackStack(null)
            }
        }

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this.adapter = adapter

        }
        return binding.root
    }

}