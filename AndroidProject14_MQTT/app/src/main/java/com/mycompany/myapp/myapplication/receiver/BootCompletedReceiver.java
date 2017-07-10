package com.mycompany.myapp.myapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.mycompany.myapp.myapplication.service.MqttSubscribeService;

public class BootCompletedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, MqttSubscribeService.class);
        context.startService(i);
    }
}
