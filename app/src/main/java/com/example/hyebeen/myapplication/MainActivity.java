package com.example.hyebeen.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

//    Button b1;
    Button b2;
//    Button b3;
//    Button b4;

    //localDB
    private Realm realm;
//    private MediDataControler mediDataControler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance(); //사용준비
//        mediDataControler = new MediDataControler();


        //button
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(isCheckClassFile(realm)){
                    //TODO:등록된 정보가 있다면,
                    Intent intent_o = new Intent(getApplicationContext(), MediInfo2.class);
//                    intent_o.putExtra("MediDataControler", mediDataControler); //db존재
                    startActivity(intent_o);
                }
                else {
                    //TODO:등록된 정보가 없다면,
                    Toast.makeText(getApplicationContext(),
                            "등록된 약 정보가 없습니다.\n새로운 약을 등록해주세요.", Toast.LENGTH_LONG).show();

                    Intent intent_x = new Intent(getApplicationContext(), Medi_setting.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("ButtonNum",b2.getText().toString());
//                    bundle.putSerializable("MediDataControler", mediDataControler);
//                    intent_x.putExtras(bundle);
//                    intent_x.putExtra("MediDataControler", mediDataControler); //null
                    intent_x.putExtra("ButtonNum",Integer.parseInt(b2.getText().toString()));
                    startActivity(intent_x);
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

    //DB 에 내용이 있는지 체크 (파일이 존재하는지 확인)
    public boolean isCheckClassFile(Realm realm) {
        final Boolean[] result = {false};
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                //db의 첫번째 값을 가져와라
                MediData currentMediData = realm.where(MediData.class).findFirst();

                if(currentMediData == null) { //값이 없으면
                    result[0] = false;
                }
                else { //값이 있으면
                    result[0] = true;
                }
            }
        });

        return  result[0];
    }

}
