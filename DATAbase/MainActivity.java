package com.example.krishn.databasemy;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1,e2,e3;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        e1=findViewById(R.id.email);
        e2=findViewById(R.id.pass);
        e3=findViewById(R.id.cpass);
        b1=findViewById(R.id.save);
        b2=findViewById(R.id.show);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=e1.getText().toString();
                String s2=e2.getText().toString();
                String s3=e3.getText().toString();
                if(s1.equals("")||s2.equals("")||e3.equals("")){
                    Toast.makeText(MainActivity.this,"Fields are empty",Toast.LENGTH_LONG).show();
                }
                else{
                    if(s2.equals(s3)){
                        Boolean chkmail=db.chkmail(s1);
                        if(chkmail==true){
                            Boolean insert=db.insert(s1,s2);
                            if(insert==true){
                                Toast.makeText(MainActivity.this,"Registered success",Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                                Toast.makeText(MainActivity.this,"email already existed",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=db.get();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this,"Nothing Found",Toast.LENGTH_LONG).show();
                }
               StringBuffer buffer=new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Name: "+res.getString(0)+"\n");
                    buffer.append("pass: "+res.getString(1)+"\n");
                }
                showM("SEARCHED DATA",buffer.toString());

            }
        });
    }
    public void showM(String data,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(data);
        builder.setMessage(message);
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
