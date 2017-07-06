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
import com.mycompany.myapp.content.FoodList;
import com.mycompany.myapp.dto.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodListFragment extends Fragment {
    private ListView listView;
    private List<Food> list = new ArrayList<>();
    private ItemAdapter itemAdapter;
    private static final String TAG = FoodListFragment.class.getSimpleName();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        listView = (ListView) inflater.inflate(R.layout.fragment_food_list, container, false);
        itemAdapter = new ItemAdapter();
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(itemClickListener);
        return listView;
    }

    @Override
    public void onStart() {
        super.onStart();
        for(int i = 1; i <= 6; i++) {
            Food food = new Food();
            food.setFno(i);
            food.setFname("food" + i);
            food.setFphoto(getResources().getIdentifier("food"+i, "drawable", getContext().getPackageName()));
            food.setFstar(getResources().getIdentifier("star"+i, "drawable", getContext().getPackageName()));
            food.setFdesc("삼겹살이 최고야, 부대찌개 먹고파, 치느님을 숭배하라, 피자도 먹고싶네. 후...다이어트는 언제...?");
            addItem(food);
        }
    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // list.get(position) 이 명령어도 가능.
            Food food = (Food) itemAdapter.getItem(position);
            Log.i(TAG, food.getFname());
            Log.i(TAG, food.getFdesc());
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
        public long getItemId(int position) {
            return list.get(position).getFno();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.food_item, null);
            }
            ImageView fphoto = (ImageView) convertView.findViewById(R.id.fphoto);
            TextView fname = (TextView) convertView.findViewById(R.id.fname);
            ImageView fstar = (ImageView) convertView.findViewById(R.id.fstar);
            TextView fdesc = (TextView) convertView.findViewById(R.id.fdesc);
            Food food = list.get(position);
            fphoto.setImageResource(food.getFphoto());
            fname.setText(food.getFname());
            fstar.setImageResource(food.getFstar());
            fdesc.setText(food.getFdesc());

            return convertView;
        }
    }
    public void addItem(Food item) {
        list.add(item);
        // 데이터가 변경될 시 itemAdapter에게 알려주기
        itemAdapter.notifyDataSetChanged();
    }

    public void removeItem(Food item) {
        list.remove(item);
        // 데이터가 변경될 시 itemAdapter에게 알려주기
        itemAdapter.notifyDataSetChanged();
    }
}
