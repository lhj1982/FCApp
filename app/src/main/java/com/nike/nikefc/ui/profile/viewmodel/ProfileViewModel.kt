package com.nike.nikefc.ui.profile.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.nike.nikefc.api.model.Data
import com.nike.nikefc.api.model.UserProfile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.*
import java.io.IOException

class ProfileViewModel : ViewModel() {

    private val client = OkHttpClient()

    private val _text = MutableLiveData<String>().apply {
        value = "This is Profile Fragment"
    }
    val text: LiveData<String> = _text

    val profileLiveData : MutableLiveData<Data> = MutableLiveData()

    fun getProfile(userID : String) {

        viewModelScope.launch(Dispatchers.IO) {

            val request = Request.Builder()
                .url("http://fcapp.jubenfan.com/users/$userID")
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.e("tag", "error")
                }
                override fun onResponse(call: Call, response: Response) {
                    val gson = Gson()
                    val result = gson.fromJson(response.body()?.string(), UserProfile::class.java)
                    if(result.code == "SUCCESS") {
                        profileLiveData.postValue(result.data)
                    }
                }
            })
        }
    }
}