package com.brunooliveiraeoliveira.timetracker.pomodoro

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PomodoroTimerDao {
    @Query("SELECT * FROM pomodoroTimer")
    fun getAll(): List<PomodoroTimer>

    @Query("SELECT * FROM pomodoroTimer WHERE id = :id")
    fun getById(id: Int): PomodoroTimer

    @Query("SELECT * FROM pomodoroTimer WHERE pomodoroId = :pomodoroId")
    fun getByPomodoroId(pomodoroId: Int): List<PomodoroTimer>

    @Insert
    fun insertAll(vararg pomodoroTimers: PomodoroTimer)

    @Update
    fun update(vararg pomodoroTimers: PomodoroTimer): Int

    @Delete
    fun delete(pomodoroTimer: PomodoroTimer)
}