package com.example.mayankchauhan.sqlitesharedprefs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SQLite helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = new SQLite(this);
        helper.insertStudent("MAYANK","7042736752");
    }
}
