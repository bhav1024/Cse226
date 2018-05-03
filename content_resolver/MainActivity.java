package com.example.akashsingh.content_resolver;

import android.content.ContentProviderClient;
import android.database.Cursor;
import android.net.Uri;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebHistoryItem;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    //View q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri= Uri.parse("content://com.example.akashsingh.content_provider/info");
                ContentProviderClient cpc=getContentResolver().acquireContentProviderClient(uri);
                Toast.makeText(MainActivity.this, ""+cpc, Toast.LENGTH_SHORT).show();
                Cursor cr=null;
                try
                {
                    cr=cpc.query(uri,null,null,null,"name");
                    String s="";
                    while (cr.moveToNext())
                    {
                        String s1=cr.getString(0);
                        int a=cr.getInt(1);
                        s=s+"NAMe is"+s1+"Pass is"+a+"\n";
                    }
                    Toast.makeText(MainActivity.this,s, Toast.LENGTH_SHORT).show();
                    //Snackbar.make(,this,s,Snackbar.LENGTH_LONG).show();
                }
                catch (Exception e)
                {

                }
            }
        });
    }
}
