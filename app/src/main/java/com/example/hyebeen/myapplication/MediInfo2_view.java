package com.example.hyebeen.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MediInfo2_view extends AppCompatActivity {

    private TextView mediName;
    private TextView mediInfo;
    private TextView one;
    private TextView all;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.medi2_info);

        mediName = (TextView) findViewById(R.id.medi2_name);
        mediInfo = (TextView) findViewById(R.id.medi2_info2);
        one = (TextView) findViewById(R.id.one);
        all = (TextView) findViewById(R.id.all);

        mediName.setText();

    }
}
