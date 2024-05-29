package com.example.booksystem_mobile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.io.IOException

class CatalogoActivity : AppCompatActivity(){
    val okhttp = OkHttpClient()
    val gson = Gson()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.catagolo_layout);

        val req = Request.Builder()
            .get()
            .url("https://android-jaaj-default-rtdb.firebaseio.com/livros.json")
            .build()

        val res = object : Callback{

            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {
                TODO("Not yet implemented")
            }

        }



    }
}