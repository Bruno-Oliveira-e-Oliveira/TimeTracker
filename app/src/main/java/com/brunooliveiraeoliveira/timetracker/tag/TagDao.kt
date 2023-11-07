package com.brunooliveiraeoliveira.timetracker.tag

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TagDao {
    @Query("SELECT * FROM tag")
    fun getAll(): List<Tag>

    @Query("SELECT * FROM tag WHERE id = :id")
    fun getById(id: Int): Tag

    @Insert
    fun insertAll(vararg tags: Tag)

    @Update
    fun update(vararg tags: Tag): Int

    @Delete
    fun delete(tag: Tag)
}