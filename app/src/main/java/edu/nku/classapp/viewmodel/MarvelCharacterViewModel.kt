package edu.nku.classapp.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.nku.classapp.model.MarvelCharacter
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MarvelCharacterViewModel @Inject constructor() :
    ViewModel() {

    private val characters = mutableListOf<MarvelCharacter>()
    private val names = listOf(
        "Dr Strange", "Iron Man", "Captain America", "Hulk", "Wong", "Spider Man",
        "Denomination", "Dr Doom", "Kong", "Thor", "Gor", "Captain Marvel", "Nick Fury",
        "Black Panther", "Loki", "Thanos"
    )
    private val planets = listOf("Earth", "Asgard", "Morag", "Sakaar", "Vormir", "Ego", "Titan")
    private val powers = listOf(
        "Time control", "Shield", "Infinity Stones", "Mjhonir", "Mischief",
        "Suite", "Healing", "Smash"
    )
    private val enemies = listOf(
        "Baron Mordo",
        "Mandarin",
        "Red Skull",
        "Abomination",
        "Shang-Chi",
        "Green Goblin",
        "Mephisto",
        "Doctor Doom",
        "Skullcrawler",
        "Loki",
        "Gor the God Butcher",
        "Yon-Rogg",
        "Hydra",
        "Killmonger",
        "Thor",
        "Iron Man"
    )

    private val aliases = listOf(
        "Sorcerer Supreme",
        "Tony Stark",
        "Steve Rogers",
        "Bruce Banner",
        "Wong",
        "Peter Parker",
        "The Defenders",
        "Victor Von Doom",
        "King Kong",
        "God of Thunder",
        "The Butcher of Gods",
        "Carol Danvers",
        "Agent of S.H.I.E.L.D.",
        "T'Challa",
        "God of Mischief",
        "Mad Titan"
    )

    private val catchphrases = listOf(
        "By the Hoary Hosts of Hoggoth!",
        "I am Iron Man.",
        "I can do this all day.",
        "Hulk Smash!",
        "Time Stone is mine.",
        "With great power comes great responsibility.",
        "I am vengeance! I am the night!",
        "You are nothing but a man in a suit.",
        "Kong is King!",
        "Bring me Thanos!",
        "Gods do not answer to anyone!",
        "Higher, Further, Faster.",
        "Shield Up!",
        "Wakanda Forever!",
        "I am Loki, of Asgard!",
        "I am inevitable."
    )

    init {
        createCharacters()
    }

    fun fillData() = characters.toList()

    fun fetchById(id: Int) = characters.first { it.id == id }

    private fun createCharacters() = (0..30).map { id ->
        characters.add(
            MarvelCharacter(
                id = id,
                name = names.random(),
                age = Random.nextInt(1, 100),
                power = powers.random(),
                planet = planets.random(),
                //picture = R.drawable.ic_launcher_background
                // picture = "https://rickandmortyapi.com/api/character/avatar/${Random.nextInt(1, 100)}.jpeg"
                picture = "https://i.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73.jpg",
                enemy = enemies.random(),
                alias = aliases.random(),
                catchPhrase = catchphrases.random(),
            )
        )
    }
}