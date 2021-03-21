package com.example.RoomWithRxJava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.RoomWithRxJava.Adapter.PostsAdapter;
import com.example.RoomWithRxJava.DataBase.Model.Posts;
import com.example.RoomWithRxJava.DataBase.Model.User;
import com.example.RoomWithRxJava.DataBase.PostsDataBase;
import com.example.posts.R;

import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
   private RecyclerView recyclerView;
   RecyclerView.LayoutManager layoutManager;
   EditText title ,body;
   Button insert,getData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.posts_recycler_view);
        layoutManager=new LinearLayoutManager(this);
        final PostsAdapter adapter=new PostsAdapter();
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        title=findViewById(R.id.ed_title);
        body=findViewById(R.id.ed_body);
        insert=findViewById(R.id.bt_insert);
        getData=findViewById(R.id.bt_get);

        PostsDataBase postsDataBase=PostsDataBase.getInstance(this);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sTitle=title.getEditableText().toString();
                String sBody=body.getEditableText().toString();
                postsDataBase.postsDao().insertPosts(new Posts(new User(2,"ali"),sTitle,sBody))
                        .subscribeOn(Schedulers.computation())
                        .subscribe(new CompletableObserver() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onComplete() {
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }
                        });
            }
        });
        getData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postsDataBase.postsDao().getAllPosts()
                        .subscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new SingleObserver<List<Posts>>() {
                            @Override
                            public void onSubscribe(@NonNull Disposable d) {

                            }

                            @Override
                            public void onSuccess(@NonNull List<Posts> posts) {
                                adapter.changeData(posts);
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {

                            }
                        });
            }
        });

    }
}