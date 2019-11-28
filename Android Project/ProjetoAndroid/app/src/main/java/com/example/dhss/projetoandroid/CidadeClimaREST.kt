package com.example.neto.projetoandroid

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CidadeClimaREST{

    @GET("weather")
    fun getClimaCidade(@Query("id") id: String,
                       @Query("APPID") appid:String,
                       @Query("units") units: String): Call<Cidade>
}