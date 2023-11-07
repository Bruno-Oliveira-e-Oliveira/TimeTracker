package com.brunooliveiraeoliveira.timetracker.pomodoro

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PomodoroTimerModelDao {
    @Query("SELECT * FROM pomodorotimermodel")
    fun getAll(): List<PomodoroTimerModel>

    @Query("SELECT * FROM pomodorotimermodel WHERE id = :id")
    fun getById(id: Int): PomodoroTimerModel

    @Insert
    fun insertAll(vararg pomodoroModels: PomodoroTimerModel)

    @Update
    fun update(vararg pomodoroModels: PomodoroTimerModel): Int

    @Delete
    fun delete(pomodoroModel: PomodoroTimerModel)
}