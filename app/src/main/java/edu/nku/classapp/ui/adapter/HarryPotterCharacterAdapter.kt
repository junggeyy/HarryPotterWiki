package edu.nku.classapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.nku.classapp.R
import edu.nku.classapp.databinding.CharacterCardViewBinding
import edu.nku.classapp.model.HarryPotterCharacterResponse

class HarryPotterCharacterAdapter(
    private val onCharacterClicked: (character: HarryPotterCharacterResponse.CharacterResponseItem, position: Int) -> Unit,
) :
    RecyclerView.Adapter<HarryPotterCharacterAdapter.HarryPotterCharacterViewHolder>() {
    class HarryPotterCharacterViewHolder(
        private val binding: CharacterCardViewBinding,
        private val onCharacterClicked: (position: Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onCharacterClicked(adapterPosition)
            }
        }

        fun bind(character: HarryPotterCharacterResponse.CharacterResponseItem) {
            binding.characterName.text =
                binding.root.context.getString(R.string.name, character.name)
            binding.characterYear.text =
                binding.root.context.getString(R.string.birthYear, character.yearOfBirth)
            binding.characterGender.text =
                binding.root.context.getString(R.string.gender, character.gender)
            binding.characterSpecies.text =
                binding.root.context.getString(R.string.species, character.species)

            Glide.with(binding.root).load(character.image).into(binding.characterImage)
        }
    }

    private val harryPotterCharacters =
        mutableListOf<HarryPotterCharacterResponse.CharacterResponseItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun refreshData(characters: List<HarryPotterCharacterResponse.CharacterResponseItem>) {
        harryPotterCharacters.clear()
        harryPotterCharacters.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HarryPotterCharacterViewHolder {
        val binding =
            CharacterCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return HarryPotterCharacterViewHolder(binding) { position ->
            onCharacterClicked(harryPotterCharacters[position], position)
        }
    }

    override fun getItemCount() = harryPotterCharacters.size

    override fun onBindViewHolder(
        holder: HarryPotterCharacterViewHolder,
        position: Int
    ) {
        val character = harryPotterCharacters[position]
        holder.bind(character)
    }
}
