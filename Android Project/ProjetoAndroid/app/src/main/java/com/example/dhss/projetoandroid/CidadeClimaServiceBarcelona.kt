package com.example.neto.projetoandroid

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CidadeClimaServiceBarcelona {
    val BASE_URL = "http://api.openweathermap.org/data/2.5/"
    val service: CidadeClimaREST

    init {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(CidadeClimaREST::class.java)
    }

    fun getClimaCidade(): Cidade?{
        var call = service.getClimaCidade("3128760",
            "ebcd5f22de37cd5cc792c516ad60a62b",
            "metric")
        var cidade = call.execute().body()
        return cidade
    }
}