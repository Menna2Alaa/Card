package com.example.card;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class profileActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        TextView name=findViewById(R.id.text);

        String username="username not set";
        Bundle extras=getIntent().getExtras();
        if (extras!=null)
        {
            username=extras.getString("username");
        }
        name.setText(username);
    }
}
