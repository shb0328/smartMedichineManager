package com.example.hyebeen.myapplication;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MediInfo1 extends AppCompatActivity{

    Button btnHome;
    Button btnReset;

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.medi1_info);

        //btnHome = (Button)findViewById(R.id.btnHome);
    }
}
