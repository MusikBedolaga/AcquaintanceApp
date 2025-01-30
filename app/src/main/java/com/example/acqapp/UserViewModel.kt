package com.example.acqapp

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class UserViewModel(application: Application) : ViewModel() {

    val userList: LiveData<List<User>>
    private val repository: UserRepository
    var userEmail by mutableStateOf("")
    var userPassword by mutableStateOf(0)

    init {
        val userDb = UserRoomDatabase.getInstance(application)
        val userDao = userDb.userDao()
        repository = UserRepository(userDao)
        userList = repository.userList
    }
    fun changeEmail(value: String){
        userEmail = value
    }
    fun changePasswoed(value: String){
        userPassword = value.toIntOrNull()?:userPassword
    }
    fun addUser() {
        repository.addUser(User(userEmail, userPassword))
    }
    fun deleteUser(id: Int) {
        repository.deleteUser(id)
    }
}