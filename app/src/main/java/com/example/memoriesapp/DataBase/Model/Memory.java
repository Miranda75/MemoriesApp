package com.example.memoriesapp.DataBase.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Memory {
    @PrimaryKey
    private int id;
    @ColumnInfo
    private String title;
    @ColumnInfo
    private String location ;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image;
    @ColumnInfo
    private String date ;

    public Memory() {
    }

    @Ignore
    public Memory(int id, String title, String location, byte[] image, String date) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.image = image;
        this.date = date;
    }
    @Ignore
    public Memory(int id, String title, String location, String date) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
