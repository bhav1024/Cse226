package com.example.unit3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        String s = intent.getAction();

        if (s != null)
        {
            if(s.equals(Intent.ACTION_POWER_CONNECTED))
                Toast.makeText(context,"Power is Connetced",Toast.LENGTH_LONG).show();
            if(s.equals(Intent.ACTION_POWER_DISCONNECTED))
                Toast.makeText(context,"Power is dis Connetced",Toast.LENGTH_LONG).show();

        }
        Toast.makeText(context,"Need to connect the power",Toast.LENGTH_LONG).show();
    }
}
