package edu.nku.classapp.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class HarryPotterCharacterResponse :
    ArrayList<HarryPotterCharacterResponse.CharacterResponseItem>() {
    @JsonClass(generateAdapter = true)
    data class CharacterResponseItem(
        @Json(name = "actor")
        val actor: String,
        @Json(name = "alive")
        val alive: Boolean,
        @Json(name = "alternate_actors")
        val alternateActors: List<Any?>,
        @Json(name = "alternate_names")
        val alternateNames: List<String>,
        @Json(name = "ancestry")
        val ancestry: String,
        @Json(name = "dateOfBirth")
        val dateOfBirth: String?,
        @Json(name = "eyeColour")
        val eyeColour: String,
        @Json(name = "gender")
        val gender: String,
        @Json(name = "hairColour")
        val hairColour: String,
        @Json(name = "hogwartsStaff")
        val hogwartsStaff: Boolean,
        @Json(name = "hogwartsStudent")
        val hogwartsStudent: Boolean,
        @Json(name = "house")
        val house: String,
        @Json(name = "id")
        val id: String,
        @Json(name = "image")
        val image: String,
        @Json(name = "name")
        val name: String,
        @Json(name = "patronus")
        val patronus: String,
        @Json(name = "species")
        val species: String,
        @Json(name = "wand")
        val wand: Wand,
        @Json(name = "wizard")
        val wizard: Boolean,
        @Json(name = "yearOfBirth")
        val yearOfBirth: Int?
    ) {
        @JsonClass(generateAdapter = true)
        data class Wand(
            @Json(name = "core")
            val core: String,
            @Json(name = "length")
            val length: Double?,
            @Json(name = "wood")
            val wood: String
        )
    }
}