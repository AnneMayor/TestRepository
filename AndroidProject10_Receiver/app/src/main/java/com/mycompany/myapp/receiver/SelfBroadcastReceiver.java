package com.mycompany.myapp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SelfBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "SelfBroadcastReceiver";

    // Manifest에 등록이 되어있다면 앱이 죽은 상태에서도 방송수신이 가능해짐. 코드상에서 등록하면 이건 앱이 가동될 때만 방송수신이 가능.
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "방송 수신");
    }
}
