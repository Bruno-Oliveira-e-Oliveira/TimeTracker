package com.brunooliveiraeoliveira.timetracker.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.brunooliveiraeoliveira.timetracker.pomodoro.Pomodoro
import com.brunooliveiraeoliveira.timetracker.pomodoro.PomodoroDao
import com.brunooliveiraeoliveira.timetracker.pomodoro.PomodoroTimer
import com.brunooliveiraeoliveira.timetracker.pomodoro.PomodoroTimerDao
import com.brunooliveiraeoliveira.timetracker.pomodoro.PomodoroTimerModel
import com.brunooliveiraeoliveira.timetracker.pomodoro.PomodoroTimerModelDao
import com.brunooliveiraeoliveira.timetracker.tag.Tag
import com.brunooliveiraeoliveira.timetracker.tag.TagDao
import com.brunooliveiraeoliveira.timetracker.task.Task
import com.brunooliveiraeoliveira.timetracker.task.TaskDao
import com.brunooliveiraeoliveira.timetracker.timelogger.TimeLogger
import com.brunooliveiraeoliveira.timetracker.timelogger.TimeLoggerDao
import com.brunooliveiraeoliveira.timetracker.user.User
import com.brunooliveiraeoliveira.timetracker.user.UserDao

@Database(entities = [User::class, Tag::class, Task::class, TimeLogger::class, Pomodoro::class, PomodoroTimerModel::class, PomodoroTimer::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun tagDao(): TagDao
    abstract fun taskDao(): TaskDao
    abstract fun timeLoggerDao(): TimeLoggerDao
    abstract fun pomodoroDao(): PomodoroDao
    abstract fun pomodoroTimerModelDao(): PomodoroTimerModelDao
    abstract fun pomodoroTimerDao(): PomodoroTimerDao
}