package com.example.shippingapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditProfile extends Activity {
    EditText user_name,contact,email,pass;
    Button user_register;
    String pass11="";

    SQLiteDatabase db1;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofile);

        SharedPreferences shr= PreferenceManager.getDefaultSharedPreferences(EditProfile.this);
        String name=shr.getString("name","na").toString();

        user_name=(EditText)findViewById(R.id.name);
        contact=(EditText)findViewById(R.id.contact);
        email=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.password);
        user_register=(Button)findViewById(R.id.register_user);
      //  sp1=(Spinner)findViewById(R.id.role);

        db1 = openOrCreateDatabase("MyDb", Context.MODE_PRIVATE, null);
        Cursor c1=db1.rawQuery("select * from userdata",null);
        while(c1.moveToNext()) {

            if(c1.getString(0).contentEquals(name)){

                user_name.setText(c1.getString(0));
                contact.setText(c1.getString(1));
                email.setText(c1.getString(2));
                pass.setText(c1.getString(3));
            }

        }

            user_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              boolean status =true;
                try {
                    if(user_name.getText().toString().length()==0){
                        user_name.setText("Enter Valid Name");
                        status =false;
                    }
                    if(contact.getText().toString().length()!=10){
                        contact.setError("Enter Valid Number");
                        status =false;
                    }

                    if(email.getText().toString().length()==0){
                        email.setError("Enter Valid Email");
                        email.requestFocus();
                        status =false;
                    }
                    if(pass.getText().toString().length()==0){
                        pass.setError("Enter Valid Password");
                        pass.requestFocus();
                        status =false;
                    }

                    if(status) {

String name11=user_name.getText().toString();
String cn11=contact.getText().toString();
String email11=email.getText().toString();
String pass11=pass.getText().toString();




String q1="update userdata set Name='"+name11+"',Contact='"+cn11+"',Email='"+email11+"',Password='"+pass11+"' where Name='"+name11+"'";
db1.execSQL(q1);
                        /*
                        db1.execSQL("create table  if not exists userdata(Name varchar(900),Contact varchar(900),Email varchar(900),Password varchar(900),URole varchar(900))");
                        ContentValues cv1 = new ContentValues();
                        cv1.put("Name", user_name.getText().toString());
                        cv1.put("Contact", contact.getText().toString());
                        cv1.put("Email", email.getText().toString());
                        cv1.put("Password", pass.getText().toString());
                       // cv1.put("URole", sp1.getSelectedItem().toString());
                       */
                      //  db1.insert("userdata", null, cv1);
                        Toast.makeText(EditProfile.this, "User Added Sucessfully", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }catch(Exception e){
                    Toast.makeText(EditProfile.this,"Exception"+e,Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
