package com.mycompany.myapp.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mycompany.myapp.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void handleBtnUIActivity(View v) {
        Intent intent = new Intent(this, UIActivity.class);
        startActivity(intent);
    }

    public void handleBtnWebBrowser(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://localhost:8080/SensingCarRemoteWebControl/"));
        startActivity(intent);
    }

    public void handleBtnDialActivity(View v) {
        // 안드로이드 앱을 만들 때에는 권한을 부여해야 기능이 작동하는 경우도 있음.
        // 아래코드는 현재 이 앱이 전화기능권한을 가지고 있는지를 확인하는 코드
        // 롤리팝 이전 버젼에선 물어보지않고 권한을 자동으로 부여함. 그러나 롤리팝 이후에는 사용자가 설치 시 무심코 해버릴 수 있기에 한번 더 권한을 물어보는 기능을 실행함.
        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
        if(permission == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-4110-2482"));
            startActivity(intent);
        } else {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.CALL_PHONE}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 1) {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                handleBtnDialActivity(null);
            } else {
                Toast.makeText(this, "권한을 얻지 못함", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void handleBtnMapActivity(View v) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:37.515889, 127.07275?z=16"));
        startActivity(intent);
    }
}