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

    public void handleBtnNotification(View v) {
        Intent intent = new Intent(this, UIActivity.class);
        // 지금 당장 intent로 이동하는 것이 아니라 미래에 어느 시점에서 이동하겠다는 의미
        // Flag_Update_Current: 이건 pendingintent가 여러개 만들어질 경우 마지막 하나만 업데이트 하겠다는 의미
        // Back버튼을 클릭했을 경우 마지막 화면이 기본적으로 나옴
        // PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        // Back버튼 클릭했을 경우 UIActivity 화면의 이전 화면(HomeActivity)이 나오도록 함.
        PendingIntent pendingIntent = TaskStackBuilder.create(this)
                .addParentStack(UIActivity.class) // Manifest 파일에서 이전 화면의 정보를 얻어 스택에 넣음
                .addNextIntent(intent)
                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        // NotificationCompat: 호환성을 위한 notification
        // Notification을 관리하는 통지관리자가 있음.
        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("MQTT 알림")
                .setContentText("온도가 비정상적으로 높습니다.")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .setVibrate(new long[] {1000, 500, 1000, 500})
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .build();

        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        // id를 주게되면 업데이트 할 때마다 덮어쓰기가 됨.
        nm.notify(1, notification);
//        nm.notify(2, notification);

    }
}