package com.mycompany.myapp.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.mycompany.myapp.myapplication.R;

import org.w3c.dom.Text;

public class MqttActivity extends AppCompatActivity {

    private TextView txtDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt);
        txtDisplay = (TextView) findViewById(R.id.txtDisplay);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        txtDisplay.setText(message);
    }
}
