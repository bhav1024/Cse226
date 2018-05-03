package com.example.jobschedulerdemo;

import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    JobInfo ji;
    JobScheduler js;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startJob(View view)
    {
        js = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        ComponentName cn = new ComponentName(this,MyScheduleService.class);
        JobInfo.Builder jib = new Builder(0,cn);

        jib.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY);
        jib.setRequiresCharging(true);
        jib.setRequiresDeviceIdle(false);

        ji = jib.build();

        js.schedule(ji);

    }

    public void stopJob(View view)
    {
        if(js != null) {
            js.cancelAll();
            js=null;
            Toast.makeText(this, "Job Cancelled ", Toast.LENGTH_SHORT).show();
        }
    }
}
