package com.example.hyebeen.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent mServiceintent = new Intent(context, AlarmSoundService.class);
        Toast.makeText(null,"약 먹을 시간입니다 *^^*",Toast.LENGTH_LONG).show();
        context.startService(mServiceintent);
    }
}
