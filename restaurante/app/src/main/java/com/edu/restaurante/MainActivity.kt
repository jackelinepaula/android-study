package com.edu.restaurante

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson


class MainActivity: AppCompatActivity() {

    //ArrayList
    val lRestaurante = arrayListOf<Restaurante>();
    val gson = Gson()


    override fun onCreate(bundle : Bundle?) {
        super.onCreate(bundle)
        setContentView(R.layout.mainactivity_layout)


        //Elementos
        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtEndereco = findViewById<EditText>(R.id.edtEndereco)
        val edtTipoComida = findViewById<EditText>(R.id.edtTipoComida)
        val edtLatitude = findViewById<EditText>(R.id.edtLat)
        val edtLongitude = findViewById<EditText>(R.id.edtLongi)
        val edtDescricao = findViewById<EditText>(R.id.edtDescricao)

        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnLista = findViewById<Button>(R.id.btnLista)

        btnSalvar.setOnClickListener{

            //Get Texts e Doubles
            val nome = edtNome.text.toString()
            val endereco = edtEndereco.text.toString()
            val tpComida = edtTipoComida.text.toString()
            val lati = edtLatitude.text.toString().toDouble()
            val longi = edtLongitude.text.toString().toDouble()
            val desc = edtDescricao.text.toString()

            //Objeto 'Restaurante' criado
            val restaurante = Restaurante(1, nome, endereco, tpComida, lati, longi, desc)

            //Inserindo no arrayList
            lRestaurante.add(restaurante)

            salvarPrefs(lRestaurante)

        }

        btnLista.setOnClickListener{
            val intent: Intent = Intent(this, ListaActivity::class.java)
            startActivity(intent)
        }

    }

       //Função para salvar no shared preferences

       fun salvarPrefs(array: ArrayList<Restaurante>){

            //Shared Preferences
            val sp = getSharedPreferences("restaurantes", Context.MODE_PRIVATE)
           Log.i("getsp", sp.getString("Lista", " ").toString())
            var strRestaurante = gson.toJson(array)
       
            Log.i("Restaurantes", strRestaurante)

            sp.edit().apply{
                putString("Lista", strRestaurante)
           commit()
       }

   }
}

