package com.example.RoomWithRxJava.DataBase.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "posts_table")
public class Posts {
    @PrimaryKey(autoGenerate = true)
     int id ;

     User user;
    @ColumnInfo
     String title;
    @ColumnInfo
     String body;

    public Posts() {
    }
    @Ignore
    public Posts( User user, String title, String body) {
        this.user = user;
        this.title = title;
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
