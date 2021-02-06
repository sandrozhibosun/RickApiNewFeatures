package com.apolis.corutinedaggerrick.data.database.instance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.apolis.corutinedaggerrick.data.database.dao.CharacterDao
import com.apolis.corutinedaggerrick.data.database.dao.EpisodeDao
import com.apolis.corutinedaggerrick.data.models.Episode
import com.apolis.corutinedaggerrick.data.models.Character
import com.apolis.corutinedaggerrick.utils.Converters

@Database(entities = arrayOf(
    Character::class, Episode::class),version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class MyDatabase: RoomDatabase() {

    abstract fun getCharacterDao(): CharacterDao

    abstract fun getEpisodeDao(): EpisodeDao

    companion object{
        const val DBName="Rick_cache"
        private var myDatabase:MyDatabase?=null

    }
}