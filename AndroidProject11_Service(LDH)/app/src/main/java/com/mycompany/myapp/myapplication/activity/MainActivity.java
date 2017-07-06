package com.mycompany.myapp.myapplication.activity;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

        import com.mycompany.myapp.myapplication.R;
        import com.mycompany.myapp.myapplication.service.BackgroundService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleBtnStartService(View v) {
        Intent intent = new Intent(this, BackgroundService.class);
        startService(intent);
    }

    public void handleBtnStopService(View v) {
        Intent intent = new Intent(this, BackgroundService.class);
        stopService(intent);
    }
}