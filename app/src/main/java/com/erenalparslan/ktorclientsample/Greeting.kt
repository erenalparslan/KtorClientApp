package com.erenalparslan.ktorclientsample

import com.erenalparslan.ktorclientsample.data.UserData
import com.google.gson.Gson
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText

class Greeting {
    private val client = HttpClient(Android)


    suspend fun greeting(): UserData? {
        val data: HttpResponse = client.get("https://reqres.in/api/users?page=2")
        val responseBody: String = data.bodyAsText()


        return Gson().fromJson(responseBody,UserData::class.java)
    }
}