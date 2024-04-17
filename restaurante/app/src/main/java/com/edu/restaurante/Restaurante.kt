package com.edu.restaurante

data class Restaurante (
    val id: Long,
    val nome: String,
    val endereco: String,
    val tipoComida: String,
    val latitude: Double,
    val longitude: Double,
    val descricao: String )