package com.mycompany.myapp.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.mycompany.myapp.R;
import com.mycompany.myapp.fragment.DramaFragment;
import com.mycompany.myapp.fragment.FoodListFragment;
import com.mycompany.myapp.fragment.ReviewListFragment;

// 안드로이드에서 리소스는 정수 번호를 부여해서 관리. R객체에서는 이 번호를 가지고 관리함.
public class UIActivity extends AppCompatActivity {
    private static final String TAG = "UIActivity";
    private LinearLayout linearLayouyTop;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
        linearLayouyTop = (LinearLayout) findViewById(R.id.linearLayoutTop);
        frameLayout = (FrameLayout) findViewById(R.id.frameLayout);
    }

    public void handleRadioButton1(View v) {
        // R클래스에서 부여한 번호를 가지고 photo1.jpg 를 대신할 수 있으나 이건 안스에선 에러가 남. 이클립스에선 가능하여 주로 게임개발에 자주 쓰임.
        linearLayouyTop.setBackgroundResource(R.drawable.photo1);
    }
    public void handleRadioButton2(View v) {
        linearLayouyTop.setBackgroundResource(R.drawable.photo2);
    }
    public void handleRadioButton3(View v) {
        linearLayouyTop.setBackgroundResource(R.drawable.photo3);
    }

    public void handleButton1(View v) {
       ReviewListFragment rf = new ReviewListFragment();
        // Support가 들어가지 않으면 현재 버전에서 사용되어지고있는 fragment만 들어감. 하위호완성을 위해선 여기에 값을 넣어줘야 함.
        // Support가 들어가지 않으면 현재 버전 이상에서만 동작함.
        FragmentManager fm = getSupportFragmentManager();
        // transaction이 commit되지 않으면 아래 추가 코드는 의미가 없어짐.
        // 여러 fragment를 가져다가 붙여넣을 때 시행하는 코드
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, rf);
        ft.commit();
        // fragment의 실행 순서: onAttach, onCreate, onCreateView -> 이 라이프사이클 확인하자!
    }

    public void handleButton2(View v) {
        FoodListFragment ff = new FoodListFragment();
        // Support가 들어가지 않으면 현재 버전에서 사용되어지고있는 fragment만 들어감. 하위호완성을 위해선 여기에 값을 넣어줘야 함.
        // Support가 들어가지 않으면 현재 버전 이상에서만 동작함.
        FragmentManager fm = getSupportFragmentManager();
        // transaction이 commit되지 않으면 아래 추가 코드는 의미가 없어짐.
        // 여러 fragment를 가져다가 붙여넣을 때 시행하는 코드
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, ff);
        ft.commit();
        // fragment의 실행 순서: onAttach, onCreate, onCreateView -> 이 라이프사이클 확인하자!
    }

    public void handleButton3(View v) {
        DramaFragment df = new DramaFragment();
        // Support가 들어가지 않으면 현재 버전에서 사용되어지고있는 fragment만 들어감. 하위호완성을 위해선 여기에 값을 넣어줘야 함.
        // Support가 들어가지 않으면 현재 버전 이상에서만 동작함.
        FragmentManager fm = getSupportFragmentManager();
        // transaction이 commit되지 않으면 아래 추가 코드는 의미가 없어짐.
        // 여러 fragment를 가져다가 붙여넣을 때 시행하는 코드
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, df);
        ft.commit();
        // fragment의 실행 순서: onAttach, onCreate, onCreateView -> 이 라이프사이클 확인하자!
    }
}