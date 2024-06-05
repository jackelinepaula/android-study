package com.example.booksystem_mobile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class FormActivity : AppCompatActivity() {

    val okhttp = OkHttpClient();
    val gson = Gson();

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.form_layout);

        val edtTitulo = findViewById<EditText>(R.id.edtTitulo)
        val edtAutor = findViewById<EditText>(R.id.edtAutor)

        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnCatalogo = findViewById<Button>(R.id.btnCatalogo)

        btnSalvar.setOnClickListener{
            val livro = Livro("", edtTitulo.text.toString(), edtAutor.text.toString())
            val livroJson = gson.toJson(livro)

            val body = livroJson.toRequestBody("application/json".toMediaTypeOrNull())

            val req = Request.Builder()
                .post(body)
                .url("https://android-jaaj-default-rtdb.firebaseio.com/livros.json")
                .build()

            val res = object : Callback{

                override fun onFailure(call: Call, e: IOException) {
                    Log.i("faillivro", "call ${call} | Exception ${e.message.toString()}" )
                }

                override fun onResponse(call: Call, response: Response) {
                    val b = response?.body.toString()
                    Log.i("reslivro", "Call ${call} | Resposta ${response.body.toString()}");

                }

            }

            okhttp.newCall(req).enqueue(res)
        }

        btnCatalogo.setOnClickListener {
            startActivity(Intent(this, CatalogoActivity::class.java))
        }



    }


}