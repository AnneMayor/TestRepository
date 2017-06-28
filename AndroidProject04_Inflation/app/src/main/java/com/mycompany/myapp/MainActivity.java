package com.mycompany.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

// 안드로이드에서 리소스는 정수 번호를 부여해서 관리. R객체에서는 이 번호를 가지고 관리함.
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private LinearLayout linearLayouyTop;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayouyTop = (LinearLayout) findViewById(R.id.linearLayoutTop);
        frameLayout = (FrameLayout) findViewById(R.id.framelayout);
    }

    public void handleRadioButton1(View v) {
        linearLayouyTop.setBackgroundResource(R.drawable.photo1);
    }
    public void handleRadioButton2(View v) {
        linearLayouyTop.setBackgroundResource(R.drawable.photo2);
    }
    public void handleRadioButton3(View v) {
        linearLayouyTop.setBackgroundResource(R.drawable.photo3);
    }

    public void handleButton1(View v) {


//        // 1번과 2번은 현재 객체가 activity일 경우에만 가능. 이거 상당히 많이 쓴다.
//        // LayoutInflator를 받는 방법 중 하나.(현재 객체에서 얻는다.)
//        //1)LayoutInflater layoutInflater = LayoutInflater.from(this);
//        // LayouyInflator를 받는 방법 중 둘.
//        LayoutInflater inflater = getLayoutInflater();
//        //------------------------------------------------------------
//        //위의 두 방법으로도 얻을 수 없는 경우가 있음.
//        // LayoutInflator를 받는 방법 중 셋.
//        LayoutInflater layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        // content1.xml에서 선언된 제일 첫번째 태그를 리턴함.
//        // 1)-> 요거 강추!!이렇게 배워야 함.
//        View view = inflater.inflate(R.layout.content1, null);
////        2)View view = layoutInflater.inflate(R.layout.content1, frameLayout, false);
//        frameLayout.addView(view);
//        // null이 아닌 다른 값이 들어가 있으면 부모를 리턴함. 거기다 frameLayout에 값을 대입해줌.
////        3)layoutInflater.inflate(R.layout.content1, frameLayout);
//        //4)layoutInflater.inflate(R.layout.content1, frameLayout, true);
        frameLayout.removeAllViews();
        Content1 content1 = new Content1(this);
        frameLayout.addView(content1);
        Item1 item = new Item1();
        for(int i = 1; i <=10; i++) {
            item.setPhoto(getResources().getIdentifier("member"+i, "drawable", getPackageName()));
            item.setStar(getResources().getIdentifier("star"+i, "drawable", getPackageName()));
            item.setTitle("후...좀 피곤하다" + i);
            item.setContent("후...내 아이폰 액정...ㅜㅠㅠ나가버렸다ㅠㅠ개우울한데 피곤까지...허류...");
            content1.addItem(item);
        }
    }

    public void handleButton2(View v) {

    }

    public void handleButton3(View v) {

    }
}
