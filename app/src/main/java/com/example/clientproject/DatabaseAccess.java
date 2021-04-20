package com.example.clientproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;

    DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }
    Cursor c = null;
    public static DatabaseAccess getInstance(Context context){
        if(instance==null)
            instance = new DatabaseAccess(context);
        return instance;
    }

    public void open(){

        this.db = openHelper.getWritableDatabase();
    }

    public void close(){
        if(db!=null)
            this.db.close();
    }


    public Boolean insertData(String name,String username,String password, String address,
    String carmodel,String carcompany,String regno,String rtoarea, String phonenumber,String emailid){

        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("username",username);
        contentValues.put("password",password);
        contentValues.put("address",address);
        contentValues.put("carmodel",carmodel);
        contentValues.put("carcompany",carcompany);
        contentValues.put("regno",regno);
        contentValues.put("rtoarea",rtoarea);
        contentValues.put("phonenumber",phonenumber);
        contentValues.put("emailid",emailid);

        long result  = db.insert("UsersData",null,contentValues);

        if(result==-1)
            return false;
        return true;

    }

    public Boolean checkusername(String username){
        Cursor cursor = db.rawQuery("select * from UsersData where username ='"+username+"'",new String[]{});
        if(cursor.getCount()>0){
            return true;
        }
        return false;
    }

    public Boolean checkusernamepassword(String username,String password){

        c = db.rawQuery("select * from UsersData where username ='"+username+"' and password = '"+password+"'",new String[]{});
        if(c.getCount()>0){
            return true;
        }
        return false;
    }

    String getUserData(String username){
        // %sourcename%destinationname%
        Cursor cursor = db.rawQuery("select * from UsersData where username ='"+username+"'",new String[]{});
        String ans = "";
        while(cursor.moveToNext()){
            ans += "Name : "+cursor.getString(0)+"\n\n";
            ans += "Username : "+cursor.getString(1)+"\n\n";
            ans += "Password : "+cursor.getString(2)+"\n\n";
            ans += "Address : "+cursor.getString(3)+"\n\n";
            ans += "Car Model : "+cursor.getString(4)+"\n\n";
            ans += "Car Company : "+cursor.getString(5)+"\n\n";
            ans += "Reg NO : "+cursor.getString(6)+"\n\n";
            ans += "RTO Area : "+cursor.getString(7)+"\n\n";
            ans += "PhoneNumber : "+cursor.getString(8)+"\n\n";
            ans += "Email Id : "+cursor.getString(9);

        }
        return ans;
    }

}
