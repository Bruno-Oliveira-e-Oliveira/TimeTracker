package com.brunooliveiraeoliveira.timetracker

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import androidx.room.Update
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

@Database(entities = [User::class, Tag::class, Task::class, TimeLogger::class, Pomodoro::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun tagDao(): TagDao
    abstract fun taskDao(): TaskDao
    abstract fun timeLoggerDao(): TimeLoggerDao
    abstract fun pomodoroDao(): PomodoroDao
}

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String
)
// TODO - FirstName/LastName?

@Entity
data class Tag(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "icon") val icon: String?,
    @ColumnInfo(name = "colorTheme") val colorTheme: String?
)

@Entity(foreignKeys = [ForeignKey(entity = Tag::class, parentColumns = ["id"], childColumns = ["tagId"], onDelete = CASCADE)])
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "tagId") val tagId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "active") val active: Boolean
)

@Entity(foreignKeys = [ForeignKey(entity = Task::class, parentColumns = ["id"], childColumns = ["taskId"], onDelete = CASCADE)])
data class TimeLogger(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "taskId") val taskId: Int,
    @ColumnInfo(name = "dateCreated") val dateCreated: OffsetDateTime? = null,
    @ColumnInfo(name = "secondsCounted") val secondsCounted: Int = 0,
    @ColumnInfo(name = "timerType") val timerType: String
)

@Entity
data class Pomodoro(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String
)


@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getById(id: Int): User

    @Insert
    fun insertAll(vararg users: User)

    @Update
    fun update(vararg users: User): Int

    @Delete
    fun delete(user: User)
}

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

class Converters {
    private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    @TypeConverter
    fun fromTimestamp(value: String?): OffsetDateTime? {
        return value?.let {
            return formatter.parse(value, OffsetDateTime::from)
        }
    }

    @TypeConverter
    fun dateToTimestamp(date: OffsetDateTime?): String? {
        return date?.format(formatter)
    }
}