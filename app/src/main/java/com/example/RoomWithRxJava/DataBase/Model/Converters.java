package com.example.RoomWithRxJava.DataBase.Model;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

public class Converters {
    @TypeConverter
    public String formUserToString (User user){
        return new Gson().toJson(user);
    }
    @TypeConverter
    public User fromStringToUser(String stringUser){
        return new Gson().fromJson(stringUser,User.class);
    }
}
