package com.mycompany.myapp.myapplication.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mycompany.myapp.myapplication.R;
import com.mycompany.myapp.myapplication.service.MqttSubscribeService;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private EditText editText;
    private Button btnPublish;
    private String serverURI = "tcp://192.168.3.128:1883";
    private String topic = "/devices/device1/temperature";
    private int qos = 0;
    private MqttAndroidClient mqttAndroidClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.txtMessage);
        btnPublish = (Button) findViewById(R.id.btnPublish);
        //btnPublish.setFocusable(true);
        mqttAndroidClient = new MqttAndroidClient(this, serverURI, MqttClient.generateClientId());

        try {
            mqttAndroidClient.connect()
                    .setActionCallback(new IMqttActionListener() {
                        @Override
                        public void onSuccess(IMqttToken asyncActionToken) {
                            Log.i(TAG, "MQTT server connected success");
                            btnPublish.setEnabled(true);
                        }

                        @Override
                        public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                            Log.i(TAG, "MQTT server connected fail " + exception.toString());
                        }
                    });
        } catch (MqttException e) {
            Log.i(TAG, "MQTT server connected fail " + e.toString());
            // service 스스로가 죽어버리게 하는 코드
        }
    }

    public void handleBtnStartService(View v) {
        Intent intent = new Intent(this, MqttSubscribeService.class);
        startService(intent);
    }

    public void handleBtnStopService(View v) {
        Intent intent = new Intent(this, MqttSubscribeService.class);
        stopService(intent);
    }

    public void handleBtnPublish(View v) {
        String message = editText.getText().toString();
        try {
            byte[] encodedPayload = message.getBytes("UTF-8");
            MqttMessage mqttMessage = new MqttMessage(encodedPayload);
            mqttAndroidClient.publish(topic, mqttMessage).setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    Log.i(TAG, "MQTT message delivery success");
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    Log.i(TAG, "MQTT message delivery fail");
                }
            });
        } catch (UnsupportedEncodingException e) {
            Log.i(TAG, "MQTT message delivery fail " + e.toString());
        } catch (MqttPersistenceException e) {
            e.printStackTrace();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}