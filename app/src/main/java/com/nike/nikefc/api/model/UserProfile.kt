package com.nike.nikefc.api.model
import com.google.gson.annotations.SerializedName
data class UserProfile (
	@SerializedName("code") val code : String,
	@SerializedName("data") val data : Data
)