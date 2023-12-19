package com.example.shippingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Company  extends Activity {
Button shipment,viewship,editprofile,viewstock,logout;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.companydashboard);

        shipment=(Button)findViewById(R.id.shipment);
        shipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(Company.this,ScheduldShip.class);
                startActivity(i1);
            }
        });

        viewship=(Button)findViewById(R.id.viewship);
        viewship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(Company.this,ViewShipment.class);
                startActivity(i1);
            }
        });

        viewstock=(Button)findViewById(R.id.viewstock);
        viewstock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(Company.this,ViewStock.class);
                startActivity(i1);
            }
        });
        logout=(Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(Company.this,Login.class);
                startActivity(i1);
                finish();
            }
        });



        editprofile=(Button)findViewById(R.id.editprofile);
        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(Company.this,EditProfile.class);
                startActivity(i1);
            }
        });


    }
}
