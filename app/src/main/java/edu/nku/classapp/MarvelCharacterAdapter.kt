//package edu.nku.classapp
//
//import android.annotation.SuppressLint
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.os.bundleOf
//import androidx.fragment.app.commit
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//
//class MarvelCharacterAdapter(private val characters: List<MarvelCharacter>) :
//    RecyclerView.Adapter<MarvelCharacterAdapter.MarvelCharacterViewHolder>() {
//
//    class MarvelCharacterViewHolder(
//        itemView: View,
//        private val onCharacterClicked: (position: Int) -> Unit
//    ) :
//        RecyclerView.ViewHolder(itemView) {
//
//        init {
//            itemView.setOnClickListener {
//                onCharacterClicked(adapterPosition)
//            }
//        }
//
//        val characterImage: ImageView = itemView.findViewById(R.id.character_image)
//        val characterName: TextView = itemView.findViewById(R.id.character_name)
//        val characterAge: TextView = itemView.findViewById(R.id.character_age)
//        val characterPower: TextView = itemView.findViewById(R.id.character_power)
//        val characterPlanet: TextView = itemView.findViewById(R.id.character_planet)
////        val characterEnemy: TextView = itemView.findViewById(R.id.character_enemy)
////        val characterAlias: TextView = itemView.findViewById(R.id.character_alias)
////        val characterCatchPhrase: TextView = itemView.findViewById(R.id.character_catchPhrase)
//    }
//
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): MarvelCharacterViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(
//            R.layout.character_card_view, parent,
//            false
//        )
//        return MarvelCharacterViewHolder(view) { position ->
//            val character = characters[position]
//
//            val bundle = bundleOf(
//                "image" to character.picture,
//                "name" to character.name,
//                "age" to character.age,
//                "power" to character.power,
//                "planet" to character.planet,
//                "enemy" to character.enemy,
//                "alias" to character.alias,
//                "catchPhrase" to character.catchPhrase,
//            )
//
//            val detailFragment = MarvelCharacterDetailFragment()
//
//            detailFragment.arguments = bundle
//
//            val activity = view.context as AppCompatActivity
//
//            activity.supportFragmentManager.commit {
//                setReorderingAllowed(true)
//                replace(R.id.fragment_container_view, detailFragment)
//                addToBackStack(null)
//            }
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return characters.size
//    }
//
//    @SuppressLint("SetTextI18n")
//    override fun onBindViewHolder(
//        holder: MarvelCharacterViewHolder,
//        position: Int
//    ) {
//        val character = characters[position]
//        holder.characterName.text = holder.itemView.context.getString(R.string.name, character.name)
//        holder.characterAge.text = holder.itemView.context.getString(R.string.age, character.age)
//        //holder.characterImage.setImageResource(character.picture)
//        holder.characterPower.text =
//            holder.itemView.context.getString(R.string.power, character.power)
//        holder.characterPlanet.text =
//            holder.itemView.context.getString(R.string.planet, character.planet)
//
//        Glide.with(holder.itemView.context)
//            .load(character.picture)
//            .placeholder(R.drawable.ic_launcher_background)
//            .into(holder.characterImage)
//    }
//}