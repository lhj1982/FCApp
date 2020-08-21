package com.nike.nikefc.api

import android.util.Log
import okhttp3.*
import java.io.IOException

object APIHelper {

    private val client = OkHttpClient()

    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.e("tag", "error")
            }
            override fun onResponse(call: Call, response: Response) {
                println(response.body()?.string())
            }
        })
    }
}