package com.example.hyebeen.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Button b2;
    Button b3;
    Button b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //TODO:등록된 정보가 있다면,
                Intent intent1_o = new Intent(getApplicationContext(), MediInfo1.class);
                startActivity(intent1_o);

                //TODO:등록된 정보가 없다면,
            }
        });

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //TODO:등록된 정보가 있다면,


                //TODO:등록된 정보가 없다면,
                Intent intent1_x = new Intent(getApplicationContext(), MediInfo2.class);
                startActivity(intent1_x);
            }
        });
    }
}
