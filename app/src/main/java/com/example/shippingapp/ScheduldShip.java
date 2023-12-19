package com.example.shippingapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ScheduldShip extends Activity {
    EditText source,dest,date1,content,weight;
    Button user_register;
    String pass11="";
    Spinner sp1,sp2;
    SQLiteDatabase db1;
    final Calendar myCalendar= Calendar.getInstance();
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scheduledship);

        source=(EditText)findViewById(R.id.source);
        dest=(EditText)findViewById(R.id.dest);
        date1=(EditText)findViewById(R.id.date);
        content=(EditText)findViewById(R.id.content1);
        weight=(EditText)findViewById(R.id.weight);
        user_register=(Button)findViewById(R.id.register_user);

        final DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
                date1.setText(new StringBuilder().append(day).append("-")
                        .append(view.getMonth()).append("-").append(year)
                        .append(" "));
            }
        };
        date1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(ScheduldShip.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        user_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              boolean status =true;
                try {
                    if(source.getText().toString().length()==0){
                        source.setText("Enter Valid Source");
                        status =false;
                    }
                    if(dest.getText().toString().length()==0){
                        dest.setError("Enter Valid Destination");
                        status =false;
                    }

                    if(date1.getText().toString().length()==0){
                        date1.setError("Enter Valid Date");
                        date1.requestFocus();
                        status =false;
                    }
                    if(content.getText().toString().length()==0){
                       content.setError("Enter Valid Content");
                        content.requestFocus();
                        status =false;
                    }
                    if(weight.getText().toString().length()==0){
                        content.setError("Enter Valid weight");
                        content.requestFocus();
                        status =false;
                    }
                    if(status) {

                        db1 = openOrCreateDatabase("MyDb", Context.MODE_PRIVATE, null);
                        db1.execSQL("create table  if not exists shipment(source varchar(900),dest varchar(900),udate varchar(900),content varchar(900),weight varchar(900),status varchar(900))");
                        ContentValues cv1 = new ContentValues();
                        cv1.put("source", source.getText().toString());
                        cv1.put("dest", dest.getText().toString());
                        cv1.put("udate", date1.getText().toString());
                        cv1.put("content", content.getText().toString());
                        cv1.put("weight", weight.getText().toString());
                        cv1.put("status", "0");
                        db1.insert("shipment", null, cv1);
                        Toast.makeText(ScheduldShip.this, "Sipping Added Sucessfully", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }catch(Exception e){
                    Toast.makeText(ScheduldShip.this,""+e,Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void updateLabel(){
        String myFormat="dd/MM/yyyy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);

        //menudate.setText(dateFormat.format(myCalendar.getTime()));
    };
}
