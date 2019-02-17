package me.mvvm.com.myapplication.di

import dagger.Module
import dagger.Provides
import me.mvvm.com.myapplication.AndroidApplication
import javax.inject.Singleton


@Module
class AppModule(private val application: AndroidApplication?) {

    @Provides
    @Singleton
    fun provideApplicationContext(): AndroidApplication? = application


}