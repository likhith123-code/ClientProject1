package com.example.clientproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    EditText e2;
    DatabaseAccess databaseAccess ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.unamelogin);
        e2 = (EditText)findViewById(R.id.passwordlogin);
        databaseAccess =DatabaseAccess.getInstance(getApplicationContext());
    }

    public void loginNow(View view) {

        databaseAccess.open();
        String uname = e1.getText().toString();
        String pass = e2.getText().toString();
        if(databaseAccess.checkusernamepassword(uname,pass)){
            Intent in4 = new Intent(MainActivity.this,LoggedIn.class);
            in4.putExtra("uname",uname);
            startActivity(in4);
            e1.setText("");
            e2.setText("");
        }
        else{
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG).show();
        }
        databaseAccess.close();
    }

    public void registerNow(View view) {
        Intent in3 = new Intent(MainActivity.this,Signup.class);
        startActivity(in3);
    }

    public void adminpage(View view) {
        Intent i8 = new Intent(MainActivity.this,AdminLogin.class);
        startActivity(i8);
    }
}