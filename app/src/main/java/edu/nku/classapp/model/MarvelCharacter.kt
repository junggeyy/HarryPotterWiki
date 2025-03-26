package edu.nku.classapp.model

data class MarvelCharacter(
    val id: Int,
    val name: String,
    val age: Int,
    val power: String,
    val planet: String,
    val picture: String,
    val enemy: String,
    val alias: String,
    val catchPhrase: String,
)