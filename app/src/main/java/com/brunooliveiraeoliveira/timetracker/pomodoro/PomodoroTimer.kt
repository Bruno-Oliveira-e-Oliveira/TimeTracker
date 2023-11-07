package com.brunooliveiraeoliveira.timetracker.pomodoro

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [
    ForeignKey(entity = Pomodoro::class, parentColumns = ["id"], childColumns = ["pomodoroId"], onDelete = ForeignKey.CASCADE),
    ForeignKey(entity = PomodoroTimerModel::class, parentColumns = ["id"], childColumns = ["pomodoroTimerModelId"], onDelete = ForeignKey.CASCADE)
])
data class PomodoroTimer(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "pomodoroId") val pomodoroId: Int,
    @ColumnInfo(name = "pomodoroTimerModelId") val pomodoroTimerModelId: Int,
    @ColumnInfo(name = "sequential") val sequential: Int = 0
)