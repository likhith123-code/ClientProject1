package com.example.clientproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    EditText e1;
    EditText e2,e3,e4,e5,e6,e7,e8,e9,e10;
    DatabaseAccess databaseAccess ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        e1 = (EditText)findViewById(R.id.name);
        e2 = (EditText)findViewById(R.id.username);
        e3 = (EditText)findViewById(R.id.password);
        e4 = (EditText)findViewById(R.id.address);
        e5 = (EditText)findViewById(R.id.carmodel);
        e6 = (EditText)findViewById(R.id.carcompany);
        e7 = (EditText)findViewById(R.id.regno);
        e8 = (EditText)findViewById(R.id.rtoarea);
        e9 = (EditText)findViewById(R.id.phonenumber);
        e10 = (EditText)findViewById(R.id.emailid);
        databaseAccess =DatabaseAccess.getInstance(getApplicationContext());

    }


    public void signin(View view) {

        Intent in = new Intent(Signup.this,MainActivity.class);
        startActivity(in);
    }

    public void signup(View view) {
        databaseAccess.open();
        String name = e1.getText().toString();
        String username = e2.getText().toString();
        String password = e3.getText().toString();
        String address = e4.getText().toString();
        String carmodel = e5.getText().toString();
        String carcompany = e6.getText().toString();
        String regno = e7.getText().toString();
        String rtoarea = e8.getText().toString();
        String phonenumber = e9.getText().toString();
        String emailid = e10.getText().toString();

        if(!name.isEmpty() && !username.isEmpty() && !password.isEmpty() && !address.isEmpty() && !carcompany.isEmpty() && !carmodel.isEmpty() && !regno.isEmpty() && !rtoarea.isEmpty() && !phonenumber.isEmpty() && !emailid.isEmpty()){

            if(phonenumber.length()!=10){
                Toast.makeText(this, "Enter Valid Phone Number", Toast.LENGTH_LONG).show();
            }
            else if(databaseAccess.checkusername(username)){
                Toast.makeText(this,"User Already Exists",Toast.LENGTH_LONG);
            }
            else{
                boolean check = databaseAccess.insertData(name,username,password,address,carmodel,carcompany,regno,rtoarea,phonenumber,emailid);
                if(check){
                    Toast.makeText(this, "Registration Done", Toast.LENGTH_LONG).show();
                    Intent in2 = new Intent(Signup.this,MainActivity.class);
                    startActivity(in2);
                }
                else{
                    Toast.makeText(this, "Registartion Failed", Toast.LENGTH_LONG).show();
                }

            }

        }
        else{
            Toast.makeText(this, "Enter Complete Details", Toast.LENGTH_LONG).show();
        }
        databaseAccess.close();
    }
}