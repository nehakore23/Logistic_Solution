package com.example.shippingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminDashboard extends Activity {
    Button cuser,confirmuser,logout;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admindashboard);
        cuser=(Button)findViewById(R.id.approveuser);
        cuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(AdminDashboard.this,ConfirmUser.class);
                startActivity(i1);
            }
        });

        confirmuser=(Button)findViewById(R.id.confirmuser);
        confirmuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(AdminDashboard.this,ViewConfirmUser.class);
                startActivity(i1);
            }
        });

        logout=(Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(AdminDashboard.this,Login.class);
                startActivity(i1);
                finish();
            }
        });

    }
}
