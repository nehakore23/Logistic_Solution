package com.example.shippingapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Starpage extends Activity {
Button admin,ware,comp,driver;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage);

        admin=(Button)findViewById(R.id.admin);
        ware=(Button)findViewById(R.id.ware);
        comp=(Button)findViewById(R.id.company);
        driver=(Button)findViewById(R.id.driver);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1= new Intent(Starpage.this,Login.class);
                i1.putExtra("uname","Admin");
                startActivity(i1);
            }
        });

        ware.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1= new Intent(Starpage.this,Login.class);
                i1.putExtra("uname","Warehouse");
                startActivity(i1);
            }
        });
        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1= new Intent(Starpage.this,Login.class);
                i1.putExtra("uname","Company");
                startActivity(i1);
            }
        });

        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1= new Intent(Starpage.this,Login.class);
                i1.putExtra("uname","Driver");
                startActivity(i1);
            }
        });
    }
}
