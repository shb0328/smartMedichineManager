package com.example.hyebeen.myapplication;

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
    //----------------------------------------//


    /*********************Begin of OnCreate*************************/
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.medi2_info);

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
            }
        });

        donotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:SHOW DONOT
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO:RESET
            }
        });

    }
    /**********************END of OnCreate*************************/

}
