package com.example.hyebeen.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    Button b1;
    Button b2;
    Button b3;
    Button b4;

    //local DB
    private Realm realm;
    private AllMediDatasControler allMediDatasControler;

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
                Toast.makeText(getApplicationContext(),
                        "등록된 약 정보가 없습니다.\n새로운 약을 등록해주세요.", Toast.LENGTH_LONG).show();
                Intent intent1_x = new Intent(getApplicationContext(), MediInfo2_setting.class);
                startActivity(intent1_x);
            }
        });

    }
}
