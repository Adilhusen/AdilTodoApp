package com.ad.adilpracticaltask.di

import android.content.Context

import androidx.room.Room
import com.ad.adilpracticaltask.data.local.AppDatabase
import com.ad.adilpracticaltask.util.Constant.ROOM_DATA_BASE_NAME

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {



    @Provides
    @Singleton
    fun provideStockDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, ROOM_DATA_BASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}
