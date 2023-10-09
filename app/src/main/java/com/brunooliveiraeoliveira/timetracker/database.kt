package com.brunooliveiraeoliveira.timetracker

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update

@Database(entities = [User::class, Tag::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun tagDao(): TagDao
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


@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Query("SELECT * FROM user WHERE id = :id")
    fun getById(id: Int): User

    @Insert
    fun insertAll(vararg users: User)

    @Update
    fun updateUsers(vararg users: User): Int

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
    fun updateTags(vararg tags: Tag): Int

    @Delete
    fun delete(tag: Tag)
}