package com.apolis.corutinedaggerrick.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Location(

    @ColumnInfo(name="location_name")
    var name: String,
    @ColumnInfo(name="location_url")
    var url: String
):Serializable