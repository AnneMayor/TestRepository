package com.mycompany.myapp.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class BackgroundService extends Service {
    private static final String TAG = "BackgroundService";
    private Thread thread;
    // MQTT 라이브러리는 자체적으로 스레드를 사용하기에 이 통신할 적에는 스레드 쓸 필요는 없다.

    // exported: 외부에서 접근하여 사용할 수 있게끔 하겠다는 의미
    // enabled: 내부에서 사용가능할 수 있게끔 한다.
    // service:  추상 클래스 , onBind(Intent intent): 추상 메소드
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // 최초로 startService()를 호출할 때 실행
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate");
    }

    // startService()를 호출할 때마다 실행
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand");
        Log.i(TAG, "startId: " + startId);
        if(thread == null || thread.isAlive()) {
            thread = new Thread() {
                private int count;
                @Override
                public void run() {
                    while(true) {
                        Log.i(TAG, "count: " + count++);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            break;
                        }
                    }
                    stopSelf();
                }
            };
            thread.start();
        }
        // 여기서만 stopSelf() 호출해야 함.
        // 네트워크 통신이 안될 때 시행할 것이 바로 이 stopSelf().
        // return START_STICKY : 이건 디폴트 리턴값(얘는 앱이 꺼져도 실행을 계속하고 있음). 메모리 부족 현상이 생기면 안쓰는 서비스를 죽였다가 나중에 여유가 생기면 다시 살리는 역할이 바로 STICKY
        // 서비스를 강제로 종료하지않은 상태에서 강제 종료를 시켜버리면 서비스를 안드로이드가 강제적으로 실행시키지 않는다.
        return super.onStartCommand(intent, flags, startId);
    }

    // 작업 관리자에서 앱을 종료시켰을 때
    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy");
        if(thread != null && thread.isAlive()) {
            thread.interrupt();
            thread = null;
        }
        super.onDestroy();
    }
}