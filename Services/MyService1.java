package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class MyService1 extends Service {
    public MyService1()
    {

    }

        public IBinder onBind(Intent intent) {
            return null;
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {


            Toast.makeText(this,"Services Started",Toast.LENGTH_SHORT).show();
            return super.onStartCommand(intent, flags, startId);

        }


        @Override
        public void onDestroy() {
            Toast.makeText(this,"Services Stopped..",Toast.LENGTH_SHORT).show();
            super.onDestroy();
        }



    }

