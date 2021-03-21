package com.example.RoomWithRxJava.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


import com.example.RoomWithRxJava.DataBase.Dao.PostsDao;
import com.example.RoomWithRxJava.DataBase.Model.Converters;
import com.example.RoomWithRxJava.DataBase.Model.Posts;

@Database(entities = Posts.class,version = 1,exportSchema = false)
@TypeConverters(Converters.class)
public abstract class PostsDataBase extends RoomDatabase {
    public abstract PostsDao postsDao();
    private static PostsDataBase instance;
    //make function synchronized to save app form crashing
    public static synchronized PostsDataBase getInstance(Context context){
         if (instance==null)//create dataBase
         {
             instance= Room.databaseBuilder(context.getApplicationContext(),
                     PostsDataBase.class,"posts-database")
                     .allowMainThreadQueries()
                     .build();
         }return instance;
    }
}
