package com.example.shippingapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewRegistration extends Activity {
    EditText user_name,contact,email,pass;
    Button user_register;
    String pass11="";
    Spinner sp1,sp2;
    SQLiteDatabase db1;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newregistration);

        user_name=(EditText)findViewById(R.id.name);
        contact=(EditText)findViewById(R.id.contact);
        email=(EditText)findViewById(R.id.email);
        pass=(EditText)findViewById(R.id.password);
        user_register=(Button)findViewById(R.id.register_user);
        sp1=(Spinner)findViewById(R.id.role);


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
                   if(pass.getText().toString().length()>=8){


                       String pass1=pass.getText().toString();
                       boolean iscap=false;
                       boolean islow=false;
                       boolean isdigit=false;
                       boolean isspecial=false;
                       for (int i=0; i<pass1.length(); i++)
                       {

                           char ch = pass1.charAt(i);
                           if(Character.isUpperCase(ch)){
                               iscap=true;
                           }

                           if(Character.isLowerCase(ch)){
                               islow=true;
                           }
                           if(Character.isDigit(ch)){
                               isdigit=true;
                           }

                           if(ch=='@'|| ch=='!' || ch=='_' || ch=='?'){
                               isspecial=true;
                           }
                       }

                      // Toast.makeText(NewRegistration.this,"isd "+isdigit+"islow="+islow+"isspecial"+isspecial+"iscap"+iscap,Toast.LENGTH_LONG).show();

                       if(iscap && islow && isdigit && isspecial){
                        // Toast.makeText(NewRegistration.this,"Pass Word Valid",Toast.LENGTH_LONG).show();
                       }else{

                          // Toast.makeText(NewRegistration.this,"InVaid ",Toast.LENGTH_LONG).show();
                           pass.setError("Password Must Contain One Capital,Small and Special Character");
                           status =false;
                       }


                       }else{
                       pass.setError("Password length must be 8");
                       status =false;
                   }
                    if(status) {

                        db1 = openOrCreateDatabase("MyDb", Context.MODE_PRIVATE, null);
                        db1.execSQL("create table  if not exists userdata(Name varchar(900),Contact varchar(900),Email varchar(900),Password varchar(900),URole varchar(900),Status varchar(900))");
                        ContentValues cv1 = new ContentValues();
                        cv1.put("Name", user_name.getText().toString());
                        cv1.put("Contact", contact.getText().toString());
                        cv1.put("Email", email.getText().toString());
                        cv1.put("Password", pass.getText().toString());
                        cv1.put("URole", sp1.getSelectedItem().toString());
                        cv1.put("Status", "0");
                        db1.insert("userdata", null, cv1);
                        Toast.makeText(NewRegistration.this, "User Added Sucessfully", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }catch(Exception e){
                    Toast.makeText(NewRegistration.this,""+e,Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public boolean isValidPassword(final String password) {

        Pattern pattern;
        Matcher matcher;

        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{4,}$";

        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);

        return matcher.matches();

    }
}
