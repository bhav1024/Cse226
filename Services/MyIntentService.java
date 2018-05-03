package com.example.servicedemo;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by USER on 22-Feb-17.
 */

public class MyIntentService extends IentService{nt

    public MyIntentService()
    {
        super("My Intent Service Demo");
    }

    @Override
    public void onCreate() {
        Log.d("Hello","In On create");
        super.onCreate();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Bundle b1 =intent.getExtras();
        Log.d("Hello",b1.getString("Key1"));

    }
}
