package edu.nku.classapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import edu.nku.classapp.R
import edu.nku.classapp.databinding.FragmentCharacterListBinding
import edu.nku.classapp.ui.adapter.HarryPotterCharacterAdapter
import edu.nku.classapp.viewmodel.HarryPotterCharacterViewModel
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HarryPotterCharacterListFragment : Fragment() {

    private var _binding: FragmentCharacterListBinding? = null
    private val binding
        get() = _binding!!

    private val harryPotterCharacterViewModel: HarryPotterCharacterViewModel by activityViewModels()

    private val harryPotterCharacterAdapter = HarryPotterCharacterAdapter { character, _ ->
        requireActivity().supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(
                R.id.fragment_container_view,
                HarryPotterCharacterDetailFragment.newInstance(id = character.id)
            )
            addToBackStack(null)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)

        setUpObservers()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = harryPotterCharacterAdapter
        }
        harryPotterCharacterViewModel.fillData()
    }

    private fun setUpObservers() {
        lifecycleScope.launch {
            harryPotterCharacterViewModel.characters.collect { event ->
                when (event) {
                    HarryPotterCharacterViewModel.HarryPotterCharacterState.Failure -> {
                        binding.errorMessage.isVisible = true
                        binding.progressBar.isVisible = false
                        binding.recyclerView.isVisible = false
                    }

                    HarryPotterCharacterViewModel.HarryPotterCharacterState.Loading -> {
                        binding.progressBar.isVisible = true
                        binding.errorMessage.isVisible = false
                        binding.recyclerView.isVisible = false
                    }

                    is HarryPotterCharacterViewModel.HarryPotterCharacterState.Success -> {
                        harryPotterCharacterAdapter.refreshData(event.characters)
                        binding.recyclerView.isVisible = true
                        binding.errorMessage.isVisible = false
                        binding.progressBar.isVisible = false
                    }
                }

            }
        }
    }
}