package shine.com.alarmpending;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Dell on 26/03/2018.
 */

public class MyReceiver extends BroadcastReceiver {
    public MyReceiver(){

    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"Alarm is ringing",Toast.LENGTH_SHORT).show();

    }
}
