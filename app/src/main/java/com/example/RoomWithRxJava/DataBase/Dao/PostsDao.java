package com.example.RoomWithRxJava.DataBase.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.RoomWithRxJava.DataBase.Model.Posts;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface PostsDao {
    @Insert
    Completable insertPosts(Posts posts);
    @Delete
    public void RemovePosts(Posts posts);
    @Update
    public void UpdatePosts(Posts posts);
    @Query("select * from posts_table")
    Single<List<Posts>> getAllPosts();
}
