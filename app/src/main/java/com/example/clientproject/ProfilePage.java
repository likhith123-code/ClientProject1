package com.example.clientproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.clientproject.LoggedIn.unames;

public class ProfilePage extends AppCompatActivity {
    String user;
    TextView t1;
    DatabaseAccess databaseAccess ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        databaseAccess =DatabaseAccess.getInstance(getApplicationContext());
        databaseAccess.open();
        user = unames;
        String busdata = databaseAccess.getUserData(user);
        t1 = (TextView)findViewById(R.id.datadisplay);
        t1.setText(busdata);
        databaseAccess.close();

    }
}