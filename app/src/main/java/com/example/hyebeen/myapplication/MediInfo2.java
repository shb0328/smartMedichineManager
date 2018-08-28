package com.example.hyebeen.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import io.realm.Realm;

public class MediInfo2 extends AppCompatActivity {

    private TextView mediName;
    private TextView mediInfo;
    private TextView one;
    private TextView all;

    //localDB
    private Realm realm;
    private Intent intent = getIntent();
    private MediDBControler mediDBControler;
//    private MediData mediData;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.medi2_info);

        realm = Realm.getDefaultInstance(); //사용준비
        mediDBControler = (MediDBControler) intent.getSerializableExtra("mediDBControler");
//        mediData = (MediData) intent.getParcelableExtra("MediData");

        mediName = (TextView) findViewById(R.id.medi2_name);
        mediInfo = (TextView) findViewById(R.id.medi2_info2);
        one = (TextView) findViewById(R.id.one);
        all = (TextView) findViewById(R.id.all);

        mediName.setText(mediDBControler.getMediData_num2(realm).getMember_name());

    }
}
