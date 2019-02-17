package me.mvvm.com.myapplication.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by Alexander Karpenko on 09.09.18.
 * java.karpenko@gmail.com
 */

@Database(version = 1, entities = arrayOf(User::class), exportSchema = false)
abstract class LocalDatabase :RoomDatabase(){
    abstract fun localUserDao(): UserLocalDao
}