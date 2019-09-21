package com.example.memoriesapp.DataBase.DAos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.memoriesapp.DataBase.Model.Memory;

import java.util.List;

@Dao
public interface MemoryDao {
    @Query("select * from Memory")
    List<Memory> getAllMemories();

    @Query("select * from Memory where title =:title")
    Memory getMemoryByTitle (String title);

    @Insert
    void addMemory(Memory memory);

    @Delete
    void deleteMemory(Memory memory);

    @Query("delete from Memory where id=:id")
    void deleteMemory(int id);

    @Update
    void updateMemory(Memory memory);

}
