package com.example.acqapp

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

sealed class UserResult {
    object Success : UserResult()
    data class Error(val message: String) : UserResult()
}

class UserViewModel(application: Application) : ViewModel() {
    val userList: MutableLiveData<List<User>> = MutableLiveData()
    private val repository: UserRepository
    var userEmail by mutableStateOf("")
    var userPassword by mutableStateOf("")
    var currentUserIndex by mutableStateOf(0)

    init {
        val userDb = UserRoomDatabase.getInstance(application)
        val userDao = userDb.userDao()
        repository = UserRepository(userDao)
        loadAllUsers()
    }

    private fun loadAllUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val users = repository.getAllUsers() // Получаем всех пользователей
            userList.postValue(users) // Обновляем LiveData
            // Устанавливаем индекс текущего пользователя
            currentUserIndex = if (users.isNotEmpty()) 0 else -1
        }
    }

    fun nextUser() {
        val users = userList.value ?: return
        if (currentUserIndex < users.size - 1) {
            currentUserIndex++
        }
    }

    fun previousUser() {
        if (currentUserIndex > 0) {
            currentUserIndex--
        }
    }

    fun getCurrentUser(): User? {
        return userList.value?.get(currentUserIndex)
    }

    fun changeEmail(value: String) {
        userEmail = value
    }

    fun changePassword(value: String) {
        userPassword = value
    }

    fun addUser() {
        repository.addUser(User(userEmail, userPassword))
    }

    fun authenticateUser(email: String, password: String): User? {
        return repository.authenticateUser(email, password)
    }

    fun authenticateUserAsync(email: String, password: String, callback: (UserResult) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = repository.authenticateUser(email, password) // Проверяем существование пользователя
            withContext(Dispatchers.Main) {
                if (user != null) {
                    callback(UserResult.Success) // Успешно аутентифицирован
                } else {
                    callback(UserResult.Error("Неправильный email или пароль")) // Ошибка аутентификации
                }
            }
        }
    }

    fun addUserAsync(email: String, password: String, callback: (UserResult) -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            changeEmail(email)
            changePassword(password)
            try {
                addUser() // добавляем пользователя в базу данных
                withContext(Dispatchers.Main) {
                    callback(UserResult.Success)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    callback(UserResult.Error(e.message ?: "Unknown error"))
                }
            }
        }
    }

    fun getAllUsers(callback: (List<User>) -> Unit) {
        viewModelScope.launch {
            val users = repository.getAllUsers()
            callback(users)
        }
    }
}
