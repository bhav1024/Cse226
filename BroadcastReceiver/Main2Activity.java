package com.example.unit3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i = getIntent();
        Bundle b1 =i.getExtras();

        if(b1!= null)
        {
            Toast.makeText(this,b1.getString("K1"),Toast.LENGTH_SHORT).show();
        }
    }
}
