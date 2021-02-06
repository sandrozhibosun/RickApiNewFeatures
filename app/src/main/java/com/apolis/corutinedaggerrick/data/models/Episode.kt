package com.apolis.corutinedaggerrick.data.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "table_episode")
data class Episode(
    val air_date: String,
    val characters: ArrayList<String>,
    val created: String,
    val episode: String,
    @PrimaryKey
    @NonNull
    val id: Int,
    val name: String,
    val url: String
):Serializable{
    companion object{
        const val EPISODE_KEY="EPISODE"
    }
}