package com.mycompany.myapp.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.myapp.R;
import com.mycompany.myapp.dto.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewListFragment extends Fragment {
    private ListView listView;
    private List<Review> list = new ArrayList<>();
    private ItemAdapter itemAdapter;
    private static final String TAG = ReviewListFragment.class.getSimpleName();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        listView = (ListView) inflater.inflate(R.layout.fragment_review_list, container, false);
        itemAdapter = new ItemAdapter();
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(itemClickListener);
        return listView;
    }

    @Override
    public void onStart() {
        super.onStart();
        for(int i = 1; i <= 10; i++) {
            Review review = new Review();
            review.setPhoto(getResources().getIdentifier("member"+i, "drawable", getContext().getPackageName()));
            review.setTitle("후...아니 왜 에러가...?!");
            review.setStar(getResources().getIdentifier("star"+i, "drawable", getContext().getPackageName()));
            review.setContent("ㅠㅠㅠㅠㅠㅠㅠ");
            addItem(review);
        }
    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // list.get(position) 이 명령어도 가능.
            Review review = (Review) itemAdapter.getItem(position);
            Log.i(TAG, review.getTitle());
            Log.i(TAG, review.getContent());
        }
    };

    class ItemAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        // DTO 객체 안에 식별번호가 있다면 여기선 그 번호를 리턴하지만 현재 이 프로젝트의 경우 그런 식별번호가 없기에 list의 순서번호를 리턴함.
        // 여기선 position == index
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // convertView가 재사용할 것이 없을 경우
            if(convertView == null) {
                // Item UI 객체 생성(Inflation)
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.review_item, null);
                // LinearLayout으로 받아도 가능.
            }
            // 데이터 setting(convertView의 데이터만 바꿔치기 해주면 됨.)
            ImageView photo = (ImageView) convertView.findViewById(R.id.photo);
            TextView title = (TextView) convertView.findViewById(R.id.title);
            ImageView star = (ImageView) convertView.findViewById(R.id.star);
            TextView content = (TextView) convertView.findViewById(R.id.content);
            Review review = list.get(position);
            photo.setImageResource(review.getPhoto());
            title.setText(review.getTitle());
            star.setImageResource(review.getStar());
            content.setText(review.getContent());
            return convertView;
        }
    }
    public void addItem(Review item) {
        list.add(item);
        // 데이터가 변경될 시 itemAdapter에게 알려주기
     itemAdapter.notifyDataSetChanged();
    }

    public void removeItem(Review item) {
        list.remove(item);
        // 데이터가 변경될 시 itemAdapter에게 알려주기
 itemAdapter.notifyDataSetChanged();
    }


}