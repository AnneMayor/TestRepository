package com.mycompany.myapp.myapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.mycompany.myapp.myapplication.service.BackgroundService;

public class BootCompletedReceiver extends BroadcastReceiver {
    private static final String TAG = "BootCompletedReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "onReceive");
        Intent intent1 = new Intent(context, BackgroundService.class);
        context.startService(intent1);
    }
}
