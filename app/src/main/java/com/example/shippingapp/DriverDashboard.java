package com.example.shippingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DriverDashboard extends Activity {
Button shipment,accshipment,editprofile,logout;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.driverdashboard);

        shipment=(Button)findViewById(R.id.shipment);
        shipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(DriverDashboard.this,ViewAvailableShipment.class);
                startActivity(i1);
            }
        });

        accshipment=(Button)findViewById(R.id.acceptedshipment);
        accshipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(DriverDashboard.this,ViewAcceptedShipment.class);
                startActivity(i1);
            }
        });

        editprofile=(Button)findViewById(R.id.editprofile);
        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(DriverDashboard.this,EditDriverProfile.class);
                startActivity(i1);
            }
        });

        logout=(Button)findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(DriverDashboard.this,Login.class);
                startActivity(i1);
                finish();
            }
        });
    }
}
