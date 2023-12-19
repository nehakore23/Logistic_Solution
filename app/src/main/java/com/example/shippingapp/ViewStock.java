package com.example.shippingapp;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ViewStock extends Activity {
    SQLiteDatabase db1;
    String hname[],contact[],address[],ucon[];
    ListView lst1;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewshipment);

        try {
            lst1 = (ListView) findViewById(R.id.lst11);




            lst1.setOnItemClickListener(new AdapterView.OnItemClickListener(){

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {

                }
            });

            hname = new String[20];
            contact = new String[20];
            address = new String[20];
            ucon=new String[20];

            db1 = openOrCreateDatabase("MyDb", Context.MODE_PRIVATE, null);
            Cursor c1 = db1.rawQuery("select * from stock", null);

            int count = 0;

            while (c1.moveToNext()) {

               // String str2 = c1.getString(0);
                hname[count] = "Title : "+c1.getString(0);
                contact[count] ="Quantity  : "+c1.getString(1);
                address[count] = "Desc : "+c1.getString(2)+"\nIndate : "+c1.getString(3);
                //ucon[count]=c1.getString(2);

               // Toast.makeText(ViewComplaint.this,""+hname[count],Toast.LENGTH_LONG).show();
                count = count + 1;
            }


            LevelAdapter l1 = new LevelAdapter(ViewStock.this, hname, contact, address);
            lst1.setAdapter(l1);
        }catch(Exception e){
            Toast.makeText(ViewStock.this,""+e,Toast.LENGTH_LONG).show();
        }

    }
}
