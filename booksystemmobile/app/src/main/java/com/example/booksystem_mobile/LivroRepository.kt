package com.example.booksystem_mobile

import android.util.Log
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class LivroRepository {
    private val okhttp = OkHttpClient()

    fun delete(id: String){
        val req = Request.Builder()
            .delete()
            .url("https://android-jaaj-default-rtdb.firebaseio.com/livros/${id}.json")
            .build()

        val res = object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.i("faildelete", "call $call | Exception ${e.localizedMessage}")
            }

            override fun onResponse(call: Call, response: Response) {
                val resposta = response.body
                Log.i("resdelete", "call $call | Resposta ${resposta?.string()}")
            }

        }

        okhttp.newCall(req).enqueue(res)
    }



}