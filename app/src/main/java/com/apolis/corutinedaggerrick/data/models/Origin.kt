package com.apolis.corutinedaggerrick.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.io.Serializable


data class Origin(
    @ColumnInfo(name="origin_name")
    var name: String,
    @ColumnInfo(name="origin_url")
    var url: String
):Serializable