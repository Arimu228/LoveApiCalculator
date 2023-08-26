package com.example.loveapicalculator.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun getPercentage(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "f94edca1f7msh988eccc1f598595p1c3aedjsn4fa41b4faffc",
        @Header("X-RapidAPI-Host") host: String = "love-calculator.p.rapidapi.com"
        ): Call<LoveModel>
}