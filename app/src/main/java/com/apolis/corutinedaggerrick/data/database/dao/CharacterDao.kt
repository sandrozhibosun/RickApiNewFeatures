package com.apolis.corutinedaggerrick.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.apolis.corutinedaggerrick.data.models.Character

@Dao
interface CharacterDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCharacter(character: Character)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    fun addCharacterAll(objects:List<Character>)

    @Update
    fun updateCharacter(character: Character)

    @Delete
    fun deleteCharacter(character: Character)

    @Query("select * from table_character")
    fun getCharacter(): List<Character>

    @Query("select * from table_character where name = :name")
    fun getCharacterByName(name: String): Character

    @Query("select * from table_character where id = :id")
    fun getCharacterById(id: Int): Character

}