package com.example.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Color;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.servicedemo.MyService.MyBinder;

public class MainActivity extends AppCompatActivity {

    MyService ms;
    boolean isbound =false;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent i = new Intent(this,MyService.class);
        bindService(i,ssc,Context.BIND_AUTO_CREATE);

    }

    public void startboundService(View v)
    {
        tv = (TextView) findViewById(R.id.tv1);
        String s = ms.gettime();
        tv.setText(s);

    }



    ServiceConnection ssc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Toast.makeText(getApplicationContext(),"On Service connected" ,Toast.LENGTH_SHORT).show();
            MyBinder mb = (MyBinder) service;
            ms = mb.getService();
            isbound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(getApplicationContext(),"Binding Destroyed" ,Toast.LENGTH_SHORT).show();
             isbound = false;
        }
    };


    public void startintentservice(View v)
    {

        Toast.makeText(this,"clicked on intentservice button" ,Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this,MyIntentService.class);
        Bundle b1 = new Bundle();
        b1.putString("Key1","My message in IntentService");
        i.putExtras(b1);
        startService(i);
    }
}
