package com.apolis.corutinedaggerrick.app.di

import com.apolis.corutinedaggerrick.data.models.GetCharacterResponse
import com.apolis.corutinedaggerrick.data.models.GetEpisodeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RickNMortyService{
    @GET("character")
    suspend fun getBasicCharacter(): Call<GetCharacterResponse>

    //query by pages
    @GET("character/")
    suspend fun getCharacterByPage(@Query("page") page:Int): Call<GetCharacterResponse>

    @GET("episode")
    suspend fun getBasicEpisode(): Call<GetEpisodeResponse>

    //query by pages
    @GET("episode/")
    suspend fun getEpisodeByPage(@Query("page") page:Int): Call<GetEpisodeResponse>


}