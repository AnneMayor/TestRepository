package com.mycompany.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Content1 extends LinearLayout {
    private LinearLayout itemContainer;
    public Content1(Context context) {
        super(context);
        this.setOrientation(LinearLayout.VERTICAL);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.content1, null);
        addView(view);
        itemContainer = (LinearLayout) findViewById(R.id.itemContainer);
    }

    public void addItem(Item1 item) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        // 이때, null에 현재 객체를 넣으면 부모 클래스를 리턴하여 아이디가 중복인 데이터와 충돌이 날 수 있어 다음처럼 null을 넣어줘야 함.
        // 따라서, inflator 생성 방법 4가지 다 알아놔야함.
        View view = inflater.inflate(R.layout.content1_item, null);
        ImageView photo = (ImageView) view.findViewById(R.id.photo);
        photo.setImageResource(item.getPhoto());
        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(item.getTitle());
        ImageView star = (ImageView) view.findViewById(R.id.star);
        star.setImageResource(item.getStar());
        TextView content = (TextView) view.findViewById(R.id.content);
        content.setText(item.getContent());

        itemContainer.addView(view);
    }



}
