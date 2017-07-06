package com.mycompany.myapp.activity;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mycompany.myapp.R;

public class HomeActivity extends AppCompatActivity {
    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    // 방송을 수신하기 위한 receiver를 만들기. 해당 방송식별이름과 동일한 receiver를 만들어야 방송수신이 가능.
    public void handleBtnSendNotification(View v) {
        // 방송 발생
        Intent intent = new Intent("com.mycompany.myapp.SelfBroadcast");
        sendBroadcast(intent);

    }
}