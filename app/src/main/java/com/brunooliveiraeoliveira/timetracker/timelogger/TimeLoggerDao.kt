package com.brunooliveiraeoliveira.timetracker.timelogger

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TimeLoggerDao {
    @Query("SELECT * FROM timelogger")
    fun getAll(): List<TimeLogger>

    @Query("SELECT * FROM timelogger WHERE id = :id")
    fun getById(id: Int): TimeLogger

    @Query("SELECT * FROM timelogger WHERE taskId = :taskId")
    fun getByTaskId(taskId: Int): List<TimeLogger>

    @Insert
    fun insertAll(vararg timeLoggers: TimeLogger)

    @Update
    fun update(vararg timeLoggers: TimeLogger): Int

    @Delete
    fun delete(timeLogger: TimeLogger)
}