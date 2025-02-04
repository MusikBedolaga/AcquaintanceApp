package com.example.acqapp

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "userId")
    var id: Int = 0

    @ColumnInfo(name = "userEmail")
    var email: String = ""

    @ColumnInfo(name = "userPassword")
    var password: String = ""

    constructor() {}

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }
}