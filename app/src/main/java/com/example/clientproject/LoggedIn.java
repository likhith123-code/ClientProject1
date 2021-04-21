package com.example.clientproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import java.util.Map;

public class LoggedIn extends AppCompatActivity {
    static String unames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        Intent in5 = getIntent();
        unames = in5.getStringExtra("uname");
        System.out.println("data is "+unames);
    }

    public void maps(View view) {
            Intent i6= new Intent(LoggedIn.this, MapActivity.class);
            startActivity(i6);
    }

    public void profileShow(View view) {
            Intent i5 = new Intent(LoggedIn.this,ProfilePage.class);
            startActivity(i5);
    }

    public void directions(View view) {
//        Intent i10 = new Intent(LoggedIn.this,GetDirections.class);
//        startActivity(i10);
    }
}