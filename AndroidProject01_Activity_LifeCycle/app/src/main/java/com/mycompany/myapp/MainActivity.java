package com.mycompany.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    @Override
    // inflat()의 역할: MainActivity에 xml해석 내용을 제공.
    protected void onCreate(Bundle savedInstanceState) {
        // 개발자들이 주로 사용하는 Log.d 메소드
        Log.i(Utils.getTag(), "실행");
        // Log.d: .d 여기선 debug를 의미. LOG 레벨에 해당하는 이니셜이 존재.
        // Log.d("1", "gg"); : "1" : Log 태그이름, "gg": Log 값(출력값)
        // 결과에서 D라고 출력될 경우 이건 Debug에 해당.
        //Log.d("MainActivity", "실행");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.i(Utils.getTag(),"실행");
        super.onStart();
    }

    // 잘 사용되지는 않는 부분
    // 앱을 시행한 후 홈버튼을 누른 뒤 작업관리자에서 다시 어플을 시행하면 이것이 시행됨.
    @Override
    protected void onRestart() {
        Log.i(Utils.getTag(), "실행");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i(Utils.getTag(),"실행");
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(Utils.getTag(),"실행");
        // xml파일 내용을 해석하는 코드(parsing) ->  안드로이드에선 inflate()
        // AppCompatActivity가 가지고 있는 메소드인 getMenuInflater()를 호출.
        // xml파일에서 해석한 내용을 menu 객체에 저장하는 역할.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(Utils.getTag(),"실행");
        if(item.getItemId()==R.id.action_full_activity) {
            Intent intent = new Intent(this, FullActivity.class);
            startActivity(intent);
        } else if(item.getItemId()==R.id.action_dialog_activity1) {
            Intent intent = new Intent(this, DialogActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    // 사용자가 화면을 보는 시점
    //##############################################################################################
    // 사용자가 어플을 종료하는 시점

    @Override
    protected void onPause() {
        Log.i(Utils.getTag(), "실행");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(Utils.getTag(), "실행");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d(Utils.getTag(), "실행");
        super.onDestroy();
    }
}