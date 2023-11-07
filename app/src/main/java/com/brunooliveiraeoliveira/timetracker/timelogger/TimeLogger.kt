package com.brunooliveiraeoliveira.timetracker.timelogger

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.brunooliveiraeoliveira.timetracker.task.Task
import java.time.OffsetDateTime

@Entity(foreignKeys = [ForeignKey(entity = Task::class, parentColumns = ["id"], childColumns = ["taskId"], onDelete = ForeignKey.CASCADE)])
data class TimeLogger(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "taskId") val taskId: Int,
    @ColumnInfo(name = "dateCreated") val dateCreated: OffsetDateTime? = null,
    @ColumnInfo(name = "secondsCounted") val secondsCounted: Int = 0,
    @ColumnInfo(name = "timerType") val timerType: String
)