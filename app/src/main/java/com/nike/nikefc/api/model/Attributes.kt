package com.nike.nikefc.api.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Attributes (

	@SerializedName("defending") val defending : Int,
	@SerializedName("physical") val physical : Int,
	@SerializedName("speed") val speed : Int,
	@SerializedName("attacking") val attacking : Int,
	@SerializedName("technical") val technical : Int,
	@SerializedName("mental") val mental : Int
) : Serializable