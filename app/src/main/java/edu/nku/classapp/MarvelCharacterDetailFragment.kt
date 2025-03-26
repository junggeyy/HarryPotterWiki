//package edu.nku.classapp
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.fragment.app.Fragment
//import com.bumptech.glide.Glide
//
//class MarvelCharacterDetailFragment : Fragment() {
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_character_detail, container, false)
//
//        if (arguments != null) {
//            val image = requireArguments().getString("image")
//            val imageView = view.findViewById<ImageView>(R.id.character_image_detail)
//            Glide.with(this).load(image).into(imageView)
//
//            val name = requireArguments().getString("name")
//            view.findViewById<TextView>(R.id.character_name_detail).text =
//                getString(R.string.name, name)
//
//            val age = requireArguments().getInt("age")
//            view.findViewById<TextView>(R.id.character_age_detail).text =
//                getString(R.string.age, age)
//
//            val power = requireArguments().getString("power")
//            view.findViewById<TextView>(R.id.character_power_detail).text =
//                getString(R.string.power, power)
//
//            val planet = requireArguments().getString("planet")
//            view.findViewById<TextView>(R.id.character_planet_detail).text =
//                getString(R.string.planet, planet)
//
//            val enemy = requireArguments().getString("enemy")
//            view.findViewById<TextView>(R.id.character_enemy_detail).text =
//                getString(R.string.enemy, enemy)
//
//            val alias = requireArguments().getString("alias")
//            view.findViewById<TextView>(R.id.character_alias_detail).text =
//                getString(R.string.alias, alias)
//
//            val catchPhrase = requireArguments().getString("catchPhrase")
//            view.findViewById<TextView>(R.id.character_catchPhrase_detail).text =
//                getString(R.string.catchPhrase, catchPhrase)
//        }
//
//        return view
//    }
//
//}