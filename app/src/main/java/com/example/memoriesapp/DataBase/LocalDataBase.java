package com.example.memoriesapp.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.memoriesapp.DataBase.DAos.MemoryDao;
import com.example.memoriesapp.DataBase.Model.Memory;

@Database(entities = { Memory.class},version = 1, exportSchema = false)
public abstract class LocalDataBase extends RoomDatabase {

    private static LocalDataBase LocalDataBase = null;
    private static  final String DATA_BASE_NAME = "MemoriesDataBase";
    public abstract MemoryDao memoryDao();
    

    public static LocalDataBase getInstance(Context context){
        if (LocalDataBase==null){
            //create database
            LocalDataBase= Room.databaseBuilder(context,LocalDataBase.class,DATA_BASE_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return LocalDataBase;
    }
}
