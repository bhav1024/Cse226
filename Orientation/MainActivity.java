package com.example.krishn.orientation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button but1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1=(Button)findViewById(R.id.but1);
        tv=(TextView)findViewById(R.id.text1);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        int a=Integer.parseInt(""+tv.getText());
        outState.putInt("k1",a);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int a=savedInstanceState.getInt("k1");
        tv.setText(""+a);
    }

    public void next(View v)
{
    int i=Integer.parseInt(""+tv.getText());
    i=i+1;
    tv.setText(""+i);
}
}
