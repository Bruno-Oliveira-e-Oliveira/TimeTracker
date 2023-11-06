package com.brunooliveiraeoliveira.timetracker.pomodoro

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PomodoroDao {
    @Query("SELECT * FROM pomodoro")
    fun getAll(): List<Pomodoro>

    @Query("SELECT * FROM pomodoro WHERE id = :id")
    fun getById(id: Int): Pomodoro

    @Insert
    fun insertAll(vararg pomodoros: Pomodoro)

    @Update
    fun update(vararg pomodoros: Pomodoro): Int

    @Delete
    fun delete(pomodoro: Pomodoro)
}