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

public class AddStock extends Activity {
    EditText ptitle,qunatity,desc,indate;
    Button user_register;
    String pass11="";
    Spinner sp1,sp2;
    SQLiteDatabase db1;
    final Calendar myCalendar= Calendar.getInstance();
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addstock);

        ptitle=(EditText)findViewById(R.id.ptitle);
        qunatity=(EditText)findViewById(R.id.quantity);
        desc=(EditText)findViewById(R.id.desc);
        indate=(EditText)findViewById(R.id.indate);
        user_register=(Button)findViewById(R.id.register_user);
        sp1=(Spinner)findViewById(R.id.role);


        final DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                updateLabel();
                indate.setText(new StringBuilder().append(day).append("-")
                        .append(view.getMonth()).append("-").append(year)
                        .append(" "));
            }
        };
        indate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(AddStock.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        user_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              boolean status =true;
                try {
                    if(ptitle.getText().toString().length()==0){
                        ptitle.setText("Enter Product Title");
                        status =false;
                    }
                    if(qunatity.getText().toString().length()==0){
                        qunatity.setError("Enter Valid Quantity");
                        status =false;
                    }

                    if(desc.getText().toString().length()==0){
                        desc.setError("Enter Description");
                        desc.requestFocus();
                        status =false;
                    }
                    if(indate.getText().toString().length()==0){
                        indate.setError("Enter Valid Date");
                        indate.requestFocus();
                        status =false;
                    }

                    if(status) {

                        db1 = openOrCreateDatabase("MyDb", Context.MODE_PRIVATE, null);
                        db1.execSQL("create table  if not exists stock(Title varchar(900),Quantity varchar(900),Descr varchar(900),Indate varchar(900))");
                        ContentValues cv1 = new ContentValues();
                        cv1.put("Title", ptitle.getText().toString());
                        cv1.put("Quantity", qunatity.getText().toString());
                        cv1.put("Descr", desc.getText().toString());
                        cv1.put("Indate", indate.getText().toString());
                       // cv1.put("URole", sp1.getSelectedItem().toString());
                        db1.insert("stock", null, cv1);
                        Toast.makeText(AddStock.this, "Stock Added Sucessfully", Toast.LENGTH_LONG).show();
                        finish();
                    }
                }catch(Exception e){
                    Toast.makeText(AddStock.this,""+e,Toast.LENGTH_LONG).show();
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
