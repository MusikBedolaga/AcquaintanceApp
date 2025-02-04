package com.example.acqapp

import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserRepository(private val userDao: UserDao) {
    val userList: LiveData<List<User>> = userDao.getUsers()

    fun addUser(user: User) {
        user.password = hashPassword(user.password)
        userDao.addUser(user)
    }

    fun authenticateUser(email: String, password: String): User? {
        val hashedPassword = hashPassword(password)
        return userDao.authenticateUser(email, hashedPassword)
    }

    suspend fun getAllUsers(): List<User> {
        return withContext(Dispatchers.IO) {
            userDao.getUsersSync() // Получаем пользователей на фоновом потоке
        }
    }

    private fun hashPassword(password: String): String {
        // Имплементация хэширования пароля, например, используя BCrypt или PBKDF2
        return password // Замените на реальный метод хэширования
    }

    fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)
    }
}
