package com.example.hyebeen.myapplication;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.GregorianCalendar;

public class PopUp_alamSetting  extends Activity {


    // 알람 메니저
    private AlarmManager mManager;

    // 설정 일시
    private GregorianCalendar mCalendar;

    //일자 설정 클래스
    private DatePicker mDate;

    //시작 설정 클래스
    private TimePicker mTime;

    //통지 관련 맴버 변수
    private NotificationManager mNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.pop_up_alam_setting);



    }
}
