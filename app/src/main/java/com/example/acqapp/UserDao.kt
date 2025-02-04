package com.example.acqapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getUsers(): LiveData<List<User>>

    @Insert
    fun addUser(user: User)

    @Query("DELETE FROM users WHERE userId = :id")
    fun deleteUser(id: Int)

    @Query("SELECT * FROM users WHERE userEmail = :email AND userPassword = :password LIMIT 1")
    fun authenticateUser(email: String, password: String): User?

    @Query("SELECT * FROM users WHERE userEmail = :email LIMIT 1")
    fun getUserByEmail(email: String): User?

    @Query("SELECT * FROM users")
    fun getUsersSync(): List<User>
}