package com.brunooliveiraeoliveira.timetracker.task

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TaskDao {
    @Query("SELECT * FROM task")
    fun getAll(): List<Task>

    @Query("SELECT * FROM task WHERE id = :id")
    fun getById(id: Int): Task

    @Query("SELECT * FROM task WHERE tagId = :tagId")
    fun getByTagId(tagId: Int): List<Task>

    @Insert
    fun insertAll(vararg tasks: Task)

    @Update
    fun update(vararg tasks: Task): Int

    @Delete
    fun delete(task: Task)
}