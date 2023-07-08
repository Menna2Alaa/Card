package com.example.card;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<User> usersList;
    private RecyclerView recyclerView;
    private Adapter.RecyclerViewClickListener listener;
    Adapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usersList=new ArrayList<>();
        setUserInfo();
        setAdapter();
        recyclerView=findViewById(R.id.recyclerView);

    }

    private void setAdapter() {
        setOnClickListener();
        Adapter adapter=new Adapter(usersList,listener);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener=new Adapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent=new Intent(getApplicationContext(),profileActivity.class);
                intent.putExtra("username",usersList.get(position).getUsername());
                startActivity(intent);
            }
        };
    }

    private void setUserInfo() {
        usersList.add(new User("John"));
        usersList.add(new User("Mark"));
        usersList.add(new User("Alice"));
        usersList.add(new User("Bob"));
        usersList.add(new User("Smith"));
    }
}