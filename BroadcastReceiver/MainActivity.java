package com.example.unit3;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    NotificationManager nim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public  void dothis(View v)
    {


        Intent i = new Intent(this,MyReceiver.class);
        sendBroadcast(i);

    }

    public  void startnotification(View v)
    {

    Intent i = new Intent(this,Main2Activity.class);


        Bundle b = new Bundle();
        b.putString("K1","LPU");
        i.putExtras(b);

        PendingIntent pi = PendingIntent.getActivity(this,0,i,0);


      NotificationCompat.Builder nib = new NotificationCompat.Builder(this);

        nib.setSmallIcon(R.mipmap.ic_launcher);
        nib.setContentTitle("My Notification");
        nib.setContentText("Hello...");

        nib.setContentIntent(pi);
        nib.addAction(R.mipmap.ic_launcher,"This is first Notification",pi);

        Notification ni = nib.build();


         nim = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nim.notify(0,ni);


    }





}
