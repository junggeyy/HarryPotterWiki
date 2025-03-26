//package edu.nku.classapp
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import kotlin.random.Random
//
//class MarvelCharacterListFragment : Fragment() {
//
//    private val names = listOf(
//        "Dr Strange", "Iron Man", "Captain America", "Hulk", "Wong", "Spider Man",
//        "Denomination", "Dr Doom", "Kong", "Thor", "Gor", "Captain Marvel", "Nick Fury",
//        "Black Panther", "Loki", "Thanos"
//    )
//    private val planets = listOf("Earth", "Asgard", "Morag", "Sakaar", "Vormir", "Ego", "Titan")
//    private val powers = listOf(
//        "Time control", "Shield", "Infinity Stones", "Mjhonir", "Mischief",
//        "Suite", "Healing", "Smash"
//    )
//    private val enemies = listOf(
//        "Baron Mordo",
//        "Mandarin",
//        "Red Skull",
//        "Abomination",
//        "Shang-Chi",
//        "Green Goblin",
//        "Mephisto",
//        "Doctor Doom",
//        "Skullcrawler",
//        "Loki",
//        "Gor the God Butcher",
//        "Yon-Rogg",
//        "Hydra",
//        "Killmonger",
//        "Thor",
//        "Iron Man"
//    )
//
//    private val aliases = listOf(
//        "Sorcerer Supreme",
//        "Tony Stark",
//        "Steve Rogers",
//        "Bruce Banner",
//        "Wong",
//        "Peter Parker",
//        "The Defenders",
//        "Victor Von Doom",
//        "King Kong",
//        "God of Thunder",
//        "The Butcher of Gods",
//        "Carol Danvers",
//        "Agent of S.H.I.E.L.D.",
//        "T'Challa",
//        "God of Mischief",
//        "Mad Titan"
//    )
//
//    private val catchphrases = listOf(
//        "By the Hoary Hosts of Hoggoth!",
//        "I am Iron Man.",
//        "I can do this all day.",
//        "Hulk Smash!",
//        "Time Stone is mine.",
//        "With great power comes great responsibility.",
//        "I am vengeance! I am the night!",
//        "You are nothing but a man in a suit.",
//        "Kong is King!",
//        "Bring me Thanos!",
//        "Gods do not answer to anyone!",
//        "Higher, Further, Faster.",
//        "Shield Up!",
//        "Wakanda Forever!",
//        "I am Loki, of Asgard!",
//        "I am inevitable."
//    )
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val view = inflater.inflate(R.layout.fragment_character_list, container, false)
//        val characters = mutableListOf<MarvelCharacter>()
//        for (i in 0..30) {
//            characters.add(createCharacter(i))
//        }
//
//        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
//        recyclerView.layoutManager = LinearLayoutManager(requireContext())
//        recyclerView.adapter = MarvelCharacterAdapter(characters)
//
//        return view
//    }
//
//
//    private fun createCharacter(age: Int) = MarvelCharacter(
//        name = names.random(),
//        age = Random.nextInt(1, 100),
//        power = powers.random(),
//        planet = planets.random(),
//        //picture = R.drawable.ic_launcher_background
//        // picture = "https://rickandmortyapi.com/api/character/avatar/${Random.nextInt(1, 100)}.jpeg"
//        picture = "https://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73.jpg",
//        enemy = enemies.random(),
//        alias = aliases.random(),
//        catchPhrase = catchphrases.random(),
//    )
//
//}