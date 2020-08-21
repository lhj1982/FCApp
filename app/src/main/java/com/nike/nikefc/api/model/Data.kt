package com.nike.nikefc.api.model
import com.google.gson.annotations.SerializedName
data class Data (

	@SerializedName("favoriteTeams") val favoriteTeams : List<String>,
	@SerializedName("favoritePlayers") val favoritePlayers : List<String>,
	@SerializedName("_id") val _id : String,
	@SerializedName("firstName") val firstName : String,
	@SerializedName("lastName") val lastName : String,
	@SerializedName("age") val age : Int,
	@SerializedName("team") val team : String,
	@SerializedName("preferFoot") val preferFoot : String,
	@SerializedName("position") val position : String,
	@SerializedName("height") val height : Int,
	@SerializedName("format") val format : Int,
	@SerializedName("weight") val weight : Int,
	@SerializedName("developments") val developments : List<Developments>,
	@SerializedName("id") val id : String,
	@SerializedName("friends") val friends : List<Friends>
)