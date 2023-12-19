package com.example.shippingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WareHouseDashboard extends Activity {
Button addstock,viewstock,editprofile,logout;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.warehouse);

        addstock=(Button)findViewById(R.id.stockorder);
        addstock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(WareHouseDashboard.this,AddStock.class);
                startActivity(i1);
            }
        });

        viewstock=(Button)findViewById(R.id.viewstock);
        viewstock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(WareHouseDashboard.this,ViewStock.class);
                startActivity(i1);
            }
        });

        editprofile=(Button)findViewById(R.id.editprofile);
        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(WareHouseDashboard.this,EditDriverProfile.class);
                startActivity(i1);
            }
        });

        logout=(Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(WareHouseDashboard.this,Login.class);
                startActivity(i1);
                finish();
            }
        });
    }
}
