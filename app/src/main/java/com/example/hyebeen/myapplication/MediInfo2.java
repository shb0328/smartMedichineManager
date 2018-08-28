package com.example.hyebeen.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;

public class MediInfo2 extends AppCompatActivity {

    private TextView mediName;
    private TextView mediInfo;
    private TextView one;
    private TextView all;

    ImageButton resetButton;

    //localDB
    private Realm realm;
    private Intent intent = getIntent();
    private MediDataControler mediDataControler;
//    private MediData mediData;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.medi2_info);

        Bundle bundle = intent.getExtras();

        realm = Realm.getDefaultInstance(); //사용준비
        realm.beginTransaction();
        realm.commitTransaction();

        mediDataControler = (MediDataControler)bundle.getSerializable("MediDataControler");
//        mediData = (MediData) intent.getParcelableExtra("MediData");

        mediName = (TextView) findViewById(R.id.medi2_name);
        mediInfo = (TextView) findViewById(R.id.medi2_info2);
        one = (TextView) findViewById(R.id.one);
        all = (TextView) findViewById(R.id.all);
        resetButton = (ImageButton) findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediDataControler.clear(realm);
            }
        });

        RealmResults<MediData> mediDatas = realm.where(MediData.class)
                .equalTo("num", 2)
                .findAll();
//        MediData mediData = mediDataControler.;

        MediData mediData = mediDatas.where().equalTo("num",2).findAll();
        mediName.setText(mediData.getMember_name());

    }
}
