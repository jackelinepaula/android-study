package com.example.booksystem_mobile

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class CatalogoActivity : AppCompatActivity(){
    val okhttp = OkHttpClient()
    val gson = Gson()

    val dados = ArrayList<Livro>()

    override fun onCreate(bundle: Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.catagolo_layout);

        val recycle = findViewById<RecyclerView>(R.id.rcvLivros)

        val adapter = RecyclerViewAdapter(dados)

        recycle.adapter = adapter

        recycle.layoutManager = LinearLayoutManager(this)

        val req = Request.Builder()
            .get()
            .url("https://android-jaaj-default-rtdb.firebaseio.com/livros.json")
            .build()

        val res = object : Callback{

            override fun onFailure(call: Call, e: IOException) {
                Log.i("failcatalogo", "call $call | Exception: ${e.localizedMessage}")
            }

            override fun onResponse(call: Call, response: Response) {
                val resposta = response.body
                Log.i("rescatalogo", "call $call | \n Resposta: ${resposta}")

                //Pegando o tipo HashMap para o Gson converter o JSON
                val type = object : TypeToken<HashMap<String?, Livro?>?>(){}.type
                //Fazendo a conversão
                val mapConvertido : HashMap<String, Livro> = gson.fromJson(resposta?.string(), type)

                val lista = ArrayList<Livro>()

                mapConvertido.keys.forEach{
                    val livro = mapConvertido[it]

                    if(livro != null){
                        livro.id = it
                        lista.add(livro)
                    }

                }

                this@CatalogoActivity.runOnUiThread(
                    java.lang.Runnable {
                        dados.clear()
                        Log.i("rescatalogo", mapConvertido.toString())
                        dados.addAll(lista)

                        recycle.adapter?.notifyDataSetChanged()
                    }
                )
            }

        }

        okhttp.newCall(req).enqueue(res)
    }


}