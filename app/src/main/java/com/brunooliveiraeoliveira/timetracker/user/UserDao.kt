package com.brunooliveiraeoliveira.timetracker.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

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