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

    //localDB
    private Realm realm;
    private MediDBControler mediDBControler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance(); //사용준비
        mediDBControler = new MediDBControler();

        mediDBControler.createMediDB(realm);



        //button
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(mediDBControler.getMediData_num1(realm) == null){
                    //TODO:등록된 정보가 없다면,
                    Toast.makeText(getApplicationContext(),
                            "등록된 약 정보가 없습니다.\n새로운 약을 등록해주세요.", Toast.LENGTH_LONG).show();

                    Intent intent_x = new Intent(getApplicationContext(), Medi_setting.class);
                    intent_x.putExtra("MediData",mediDBControler); //null
                    startActivity(intent_x);
                }
                else {
                    //TODO:등록된 정보가 있다면,
                    Intent intent_o = new Intent(getApplicationContext(), MediInfo1.class);
                    intent_o.putExtra("MediData",mediDBControler); //db존재
                    startActivity(intent_o);
                }

            }
        });

        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(mediDBControler.getMediData_num2(realm) == null){
                    //TODO:등록된 정보가 없다면,
                    Toast.makeText(getApplicationContext(),
                            "등록된 약 정보가 없습니다.\n새로운 약을 등록해주세요.", Toast.LENGTH_LONG).show();

                    Intent intent_x = new Intent(getApplicationContext(), Medi_setting.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("buttonNum",b2.getText().toString());
                    bundle.putSerializable("mediDBControler",mediDBControler);
                    intent_x.putExtras(bundle);

                    startActivity(intent_x);
                }
                else {
                    //TODO:등록된 정보가 있다면,
                    Intent intent_o = new Intent(getApplicationContext(), MediInfo2.class);
                    intent_o.putExtra("mediDBControler",mediDBControler);
                    startActivity(intent_o);
                }

            }
        });

        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(mediDBControler.getMediData_num3(realm) == null){
                    //TODO:등록된 정보가 없다면,
                    Toast.makeText(getApplicationContext(),
                            "등록된 약 정보가 없습니다.\n새로운 약을 등록해주세요.", Toast.LENGTH_LONG).show();

                    Intent intent_x = new Intent(getApplicationContext(), Medi_setting.class);
                    intent_x.putExtra("MediData",mediDBControler); //null
                    startActivity(intent_x);
                }
                else {
                    //TODO:등록된 정보가 있다면,
//                    Intent intent_o = new Intent(getApplicationContext(), MediInfo3.class);
//                    intent_o.putExtra("MediData",mediDBControler); //db존재
//                    startActivity(intent_o);
                }

            }
        });

        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(mediDBControler.getMediData_num4(realm) == null){
                    //TODO:등록된 정보가 없다면,
                    Toast.makeText(getApplicationContext(),
                            "등록된 약 정보가 없습니다.\n새로운 약을 등록해주세요.", Toast.LENGTH_LONG).show();

                    Intent intent_x = new Intent(getApplicationContext(), Medi_setting.class);
                    intent_x.putExtra("MediData",mediDBControler); //null
                    startActivity(intent_x);
                }
                else {
                    //TODO:등록된 정보가 있다면,
//                    Intent intent_o = new Intent(getApplicationContext(), MediInfo4.class);
//                    intent_o.putExtra("MediData",mediDBControler); //db존재
//                    startActivity(intent_o);
                }

            }
        });


    }

    //realm 해제 (메모리누수방지)
    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
