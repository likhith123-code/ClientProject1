package com.example.clientproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.clientproject.LoggedIn.unames;

public class AdminLoggedIn extends AppCompatActivity {
    EditText e1;
    DatabaseAccess databaseAccess ;
    String user2;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_logged_in);
        e1 = (EditText)findViewById(R.id.detailsadminwant);
        databaseAccess =DatabaseAccess.getInstance(getApplicationContext());
    }

    public void displaydata(View view) {
        databaseAccess.open();
        user2 = e1.getText().toString();
        String busdata = databaseAccess.getUserData(user2);
        t1 = (TextView)findViewById(R.id.getdetailsnow);
        if(busdata.length()==0){
            t1.setText("No Data Found");
        }
        else{
            t1.setText(busdata);
        }
        databaseAccess.close();
    }
}