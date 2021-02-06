package com.apolis.corutinedaggerrick.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.apolis.corutinedaggerrick.data.models.Episode


@Dao
interface EpisodeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addEpisode(episode: Episode)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    @JvmSuppressWildcards
    fun addEpisodeAll(objects: List<Episode>)

    @Update
    fun updateEpisode(episode: Episode)

    @Delete
    fun deleteEpisode(episode: Episode)

    @Query("select * from table_episode")
    fun getEpisode(): LiveData<List<Episode>>

    @Query("select * from table_episode where name = :name")
    fun getEpisodeByName(name: String): LiveData<Episode>
}
