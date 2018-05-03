package com.example.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.icu.text.SimpleDateFormat;
import android.os.Binder;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;

import java.util.Date;
import java.util.Locale;

public class MyService extends Service  {
    public MyService() {
    }

     IBinder myibinder  = new MyBinder();
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       // throw new UnsupportedOperationException("Not yet implemented");
        return myibinder;

    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        super.unbindService(conn);
    }

    String gettime()
    {
        Date d = new Date();
        return d.toString();

    }


    class MyBinder extends Binder
    {
        MyService getService()
        {
            return MyService.this;
        }

    }



}
