package com.nike.nikefc.api.model
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Developments (

	@SerializedName("attributes") val attributes : Attributes,
	@SerializedName("_id") val _id : String,
	@SerializedName("user") val user : String,
	@SerializedName("date") val date : String,
	@SerializedName("id") val id : String,
	@SerializedName("url") val url : String
) : Serializable