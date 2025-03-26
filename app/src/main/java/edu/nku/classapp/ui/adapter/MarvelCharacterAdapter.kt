package edu.nku.classapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.nku.classapp.R
import edu.nku.classapp.databinding.CharacterCardViewBinding
import edu.nku.classapp.model.MarvelCharacter

class MarvelCharacterAdapter(
    private val characters: List<MarvelCharacter>,
    private val onCharacterClicked: (position: Int) -> Unit,
) :
    RecyclerView.Adapter<MarvelCharacterAdapter.MarvelCharacterViewHolder>() {
    class MarvelCharacterViewHolder(
        private val binding: CharacterCardViewBinding,
        private val onCharacterClicked: (position: Int) -> Unit
    ) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            itemView.setOnClickListener {
                onCharacterClicked(adapterPosition)
            }
        }

        fun bind(character: MarvelCharacter) {
            binding.characterName.text =
                binding.root.context.getString(R.string.name, character.name)
            binding.characterAge.text =
                binding.root.context.getString(R.string.age, character.age)
            binding.characterPower.text =
                binding.root.context.getString(R.string.power, character.power)
            binding.characterPlanet.text =
                binding.root.context.getString(R.string.planet, character.planet)

            Glide.with(binding.root).load(character.picture).into(binding.characterImage)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarvelCharacterViewHolder {
        val binding =
            CharacterCardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return MarvelCharacterViewHolder(binding) { position ->
            onCharacterClicked(position)
        }
    }

    override fun getItemCount() = characters.size

    override fun onBindViewHolder(
        holder: MarvelCharacterViewHolder,
        position: Int
    ) {
        val character = characters[position]
        holder.bind(character)

    }
}
