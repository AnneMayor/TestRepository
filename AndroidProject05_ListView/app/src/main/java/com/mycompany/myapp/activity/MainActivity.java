package com.mycompany.myapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.mycompany.myapp.content.DramaList;
import com.mycompany.myapp.content.FoodList;
import com.mycompany.myapp.content.ReviewList;
import com.mycompany.myapp.R;
import com.mycompany.myapp.dto.Drama;
import com.mycompany.myapp.dto.Food;
import com.mycompany.myapp.dto.Review;

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
        frameLayout.removeAllViews();
        ReviewList reviewList = new ReviewList(this);
        frameLayout.addView(reviewList);

        Review review = new Review();
        review.setPhoto(R.drawable.photo1);
        review.setTitle("후...아니 왜 에러가...?!");
        review.setStar(R.drawable.star6);
        review.setContent("ㅠㅠㅠㅠㅠㅠㅠ");
        reviewList.addItem(review);
    }

    public void handleButton2(View v) {
        frameLayout.removeAllViews();
        FoodList foodList = new FoodList(this);
        frameLayout.addView(foodList);

        for(int i = 1; i <= 6; i++) {
            Food food = new Food();
            food.setFno(i);
            food.setFname("food" + i);
            food.setFphoto(getResources().getIdentifier("food"+i, "drawable", getPackageName()));
            food.setFstar(getResources().getIdentifier("star"+i, "drawable", getPackageName()));
            food.setFdesc("삼겹살이 최고야, 부대찌개 먹고파, 치느님을 숭배하라, 피자도 먹고싶네. 후...다이어트는 언제...?");
            foodList.addItem(food);
        }

    }

    public void handleButton3(View v) {
        frameLayout.removeAllViews();
        DramaList dramaList = new DramaList(this);
        frameLayout.addView(dramaList);

        Drama drama = new Drama();
        Drama drama1 = new Drama();

        drama.setDtitle("쌈, 마이웨이");
        drama.setDphoto(R.drawable.drama1);
        drama.setDstar(R.drawable.star6);
        drama.setDcomment("내 스타일은 아니지만...뭐...재밌다고 함.");
        dramaList.addItem(drama);
        drama1.setDtitle("군주-가면의 주인");
        drama1.setDphoto(R.drawable.drama2);
        drama1.setDstar(R.drawable.star10);
        drama1.setDcomment("유승호, 김소현, 윤소희, 엘...그중에서도 김소현, 유승호가 최고!너무 이쁘고 너무 멋있다...(하트)");
        dramaList.addItem(drama1);
    }
}
