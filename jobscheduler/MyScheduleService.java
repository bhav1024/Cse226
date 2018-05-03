package com.example.jobschedulerdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationCompat.Builder;
import android.widget.Toast;

/**
 * Created by USER on 12-Apr-18.
 */

public class MyScheduleService extends JobService {

    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        Toast.makeText(this,"Job started",Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this,0,i,0);
        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder = new Builder(this);
        builder.setContentTitle("My Notification");
        builder.setContentText("My Notification Text");
        builder.setSmallIcon(R.mipmap.ic_launcher);

        builder.setContentIntent(pi);
        builder.setAutoCancel(true);

        nm.notify(0,builder.build());
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
