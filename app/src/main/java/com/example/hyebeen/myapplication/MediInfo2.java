package com.example.hyebeen.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MediInfo2 extends AppCompatActivity {

    private static String IP_ADDRESS = "192.168.43.46";

    //---------------View------------------//
    private TextView num;
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

        //----------------image 띄우기----------------------//
        imgName = dbHelper.findimg(buttonNum);
        imgUrl  = "http://"+IP_ADDRESS+"/img/"+imgName;
        task = new ShowImage();
        task.execute(imgUrl);

        //-----------------ButtonNum 받아오기---------------//
        intent = getIntent();
        buttonNum = intent.getIntExtra("ButtonNum",0);

        //-----------------findViewByld-------------------//

        num=(TextView)findViewById(R.id.num);
        mediName = (TextView) findViewById(R.id.medi2_name);
        mediInfo = (TextView) findViewById(R.id.medi2_info2);
        imageView = (ImageView) findViewById(R.id.imageView);
        one = (TextView) findViewById(R.id.eat_num2);
        all = (TextView) findViewById(R.id.total_num2);
        cautionButton = (Button) findViewById(R.id.cautionButton);
        donotButton = (Button) findViewById(R.id.donotButton);
        resetButton = (Button) findViewById(R.id.resetButton);

        //
        num.setText(Integer.toString(buttonNum));
        mediName.setText(dbHelper.findname(buttonNum));
        mediInfo.setText(dbHelper.findinfo(buttonNum));
        all.setText(Integer.toString(dbHelper.findall(buttonNum)));






        //


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
                dbHelper.delete(buttonNum);
            }
        });



    }/**********************END of OnCreate*************************/


    /**
     * image 처리
     */

    String imgName;
    String imgUrl;

    Bitmap bmImg;
    ShowImage task;

    private class ShowImage extends AsyncTask<String, Integer,Bitmap> {

        @Override
        protected Bitmap doInBackground(String... urls) {

            // TODO Auto-generated method stub

            try{

                URL myFileUrl = new URL(urls[0]);
                HttpURLConnection conn = (HttpURLConnection)myFileUrl.openConnection();
                conn.setDoInput(true);
                conn.connect();

                InputStream is = conn.getInputStream();

                bmImg = BitmapFactory.decodeStream(is);

            }catch(IOException e){
                e.printStackTrace();
            }

            return bmImg;
        }
        protected void onPostExecute(Bitmap img){

            if(img == null){
                Toast.makeText(getApplicationContext(),"이미지를 불러오는데 실패했습니다.",Toast.LENGTH_LONG).show();
            }else {
                imageView.setImageBitmap(bmImg);
            }
        }
    }

}
