package com.example.akashsingh.content_provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1,editText2;
    Button button1,button2;
    ContentValues cv=new ContentValues();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1=findViewById(R.id.ed1);
        editText2=findViewById(R.id.ed2);
        button1=findViewById(R.id.btn1);
        button2=findViewById(R.id.btn2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              cv.put("name",editText1.getText().toString());
              cv.put("mob",Integer.parseInt(editText2.getText().toString()));
              Uri uri=getContentResolver().insert(MyContentProvider.content_uri,cv);
                Toast.makeText(MainActivity.this,uri.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cr=getContentResolver().query(MyContentProvider.content_uri,null,null,null,"name");
                String s="";
                while(cr.moveToNext())
                {
                    String s1=cr.getString(0);
                    int a=cr.getInt(1);
                    s=s+"Name is"+s1+"Pass is"+a+"\n";
                }
                Toast.makeText(MainActivity.this, ""+s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
