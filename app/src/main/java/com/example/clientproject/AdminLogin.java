package com.example.clientproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    EditText e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        e1 = (EditText)findViewById(R.id.adminname);
        e2 = (EditText)findViewById(R.id.adminpassword);
    }

    public void adminlogin(View view) {
        String uname = e1.getText().toString();
        String pass = e2.getText().toString();
        if(uname.equals("admin") && pass.equals("admin")){
            Intent i9 = new Intent(AdminLogin.this,AdminLoggedIn.class);
            startActivity(i9);
        }
        else{
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG).show();
        }


    }
}