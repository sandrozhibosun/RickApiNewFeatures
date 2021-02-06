package com.apolis.corutinedaggerrick.data.models

import androidx.annotation.NonNull
import androidx.room.*

import java.io.Serializable

@Entity(tableName = "table_character")
data class Character(
    var created: String,

    var episode: ArrayList<String>,
    var gendemr: String,
    @PrimaryKey
    @NonNull
    var id: Int,
    var image: String,
    @Embedded
    var location: Location,
    var name: String,
    @Embedded
    var origin: Origin,
    var species: String,
    var status: String,
    var type: String,
    @ColumnInfo(name="character_url")
    var url: String
):Serializable