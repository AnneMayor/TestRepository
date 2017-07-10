package com.mycompany.myapp.myapplication.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

// 여기서 말하는 service = bindingservice
// 에러가 났을 때의 대처법: 1. 윈도우 방화벽 풀어주기 2. 네트워크 연결상태 확인(Wi-Fi)

import com.mycompany.myapp.myapplication.R;
import com.mycompany.myapp.myapplication.activity.MqttActivity;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class MqttSubscribeService extends Service {

    private static final String TAG = "MqttSubscribeService";
    private String serverURI = "tcp://192.168.3.128:1883";
    private String topic = "/devices/#";
    private int qos = 0;
    private MqttAndroidClient mqttAndroidClient;

    // Service에서 생성자는 잘 사용이 안된다. 이거 저번에도 들은 것 같은데...암튼 기억해놓자!
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


    // 앱이 시작할 때 한 번 시행
    @Override
    public void onCreate() {
        super.onCreate();
        // service는 그 자체가 context
        mqttAndroidClient = new MqttAndroidClient(this, serverURI, MqttClient.generateClientId());
        mqttAndroidClient.setCallback(mqttCallback);
    }

    private MqttCallback mqttCallback = new MqttCallback() {
        @Override
        public void connectionLost(Throwable cause) {
        }

        @Override
        public void messageArrived(String topic, MqttMessage message) throws Exception {
            Log.i(TAG, message.toString());
            String strMessage = message.toString();

            Intent intent = new Intent(MqttSubscribeService.this, MqttActivity.class);
            intent.putExtra("message", strMessage);
            PendingIntent pendingIntent = TaskStackBuilder.create(MqttSubscribeService.this)
                    .addParentStack(MqttActivity.class) // Manifest 파일에서 이전 화면의 정보를 얻어 스택에 넣음
                    .addNextIntent(intent)
                    // notification은 하나만 만들고 내용을 바꿔치기 하는 코드
                    .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            // NotificationCompat: 호환성을 위한 notification
            // Notification을 관리하는 통지관리자가 있음.
            Notification notification = new NotificationCompat.Builder(MqttSubscribeService.this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("MQTT 알림")
                    .setContentText("MQTT message arrived")
                    .setContentIntent(pendingIntent)
                    // 공지를 눌렀을 때 화면전환이 되면서 사라지게 하는 코드
                    .setAutoCancel(true)
                    .setVibrate(new long[] {1000, 500, 1000, 500})
                    .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                    .build();

            NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            // id를 주게되면 업데이트 할 때마다 덮어쓰기가 됨.
            nm.notify(1, notification);
//        nm.notify(2, notification);


        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken token) {
        }
    };

    // service가 실행이 될 때마다 시행
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(!mqttAndroidClient.isConnected()) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    try {
                        mqttAndroidClient.connect()
                                .setActionCallback(new IMqttActionListener() {
                                    @Override
                                    public void onSuccess(IMqttToken asyncActionToken) {
                                        Log.i(TAG, "MQTT server connected success");
                                        subscribe();
                                    }

                                    @Override
                                    public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                                        Log.i(TAG, "MQTT server connected fail " + exception.toString());
                                    }
                                });
                    } catch (MqttException e) {
                        Log.i(TAG, "MQTT server connected fail " + e.toString());
                        // service 스스로가 죽어버리게 하는 코드
                        stopSelf();
                    }
                }
            };
            thread.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    private void subscribe() {
        try {
            mqttAndroidClient.subscribe(topic, qos).setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Log.i(TAG, "MQTT subscription start");
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.i(TAG, "MQTT subscription fail " + exception.toString());
                    stopSelf();
                }
            });
        } catch (MqttException e) {
            Log.i(TAG, "MQTT subscription fail " + e.toString());
            stopSelf();
        }
    }

    // service가 파괴될 때
    @Override
    public void onDestroy() {
        if(mqttAndroidClient.isConnected()) {
            try {
                mqttAndroidClient.unsubscribe(topic);
                Log.i(TAG, "MQTT subscription stop");
                mqttAndroidClient.disconnect();
                Log.i(TAG, "MQTT subscription disconnection");
            } catch (MqttException e) {
            }

        }
        super.onDestroy();
    }


}
