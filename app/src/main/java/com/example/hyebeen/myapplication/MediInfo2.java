package com.example.hyebeen.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MediInfo2 extends AppCompatActivity {


    //---------------View------------------//
    private TextView mediName;
    private TextView mediInfo;
    private ImageView imageView;

    private TextView one;
    private TextView all;

    private Button cautionButton;
    private Button donotButton;

    private Button resetButton;

    private Intent intent;
    private int buttonNum=0;
    //----------------------------------------//

    /*********************Begin of OnCreate*************************/
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.medi2_info);

        //DBHelper생성
        final DBHelper dbHelper = new DBHelper(getApplicationContext(), "MoneyBooks.db", null, 1);

        //-----------------ButtonNum 받아오기---------------//
        intent = getIntent();
        buttonNum = intent.getIntExtra("ButtonNum",0);

        //-----------------findViewByld-------------------//

        mediName = (TextView) findViewById(R.id.medi2_name);
        mediInfo = (TextView) findViewById(R.id.medi2_info2);
        imageView = (ImageView) findViewById(R.id.imageView);
        one = (TextView) findViewById(R.id.one);
        all = (TextView) findViewById(R.id.all);
        cautionButton = (Button) findViewById(R.id.cautionButton);
        donotButton = (Button) findViewById(R.id.donotButton);
        resetButton = (Button) findViewById(R.id.resetButton);


        //--------------------Listener--------------------//

        cautionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:SHOW CAUTION
                Intent intent = new Intent(getApplicationContext(),PopUp_info.class);
                intent.putExtra("data",dbHelper.findcaution(buttonNum));
                startActivityForResult(intent, 1);
            }
        });

        donotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:SHOW DONOT
                Intent intent = new Intent(getApplicationContext(),PopUp_info.class);
                intent.putExtra("data",dbHelper.finddonot(buttonNum));
                startActivityForResult(intent, 1);
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:RESET
            }
        });



    }/**********************END of OnCreate*************************/

}
