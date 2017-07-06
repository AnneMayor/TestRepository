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
import com.mycompany.myapp.content.DramaList;
import com.mycompany.myapp.dto.Drama;

import java.util.ArrayList;
import java.util.List;

public class DramaFragment extends Fragment {

    private ListView listView;
    private List<Drama> list = new ArrayList<>();
    private ItemAdapter itemAdapter;
    private static final String TAG = DramaFragment.class.getSimpleName();

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // list.get(position) 이 명령어도 가능.
            Drama drama = (Drama) itemAdapter.getItem(position);
            Log.i(TAG, drama.getDtitle());
            Log.i(TAG, drama.getDcomment());
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        listView = (ListView) inflater.inflate(R.layout.fragment_drama, container, false);
        itemAdapter = new ItemAdapter();
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(itemClickListener);
        return listView;
    }

    @Override
    public void onStart() {
        super.onStart();
        Drama drama = new Drama();
        Drama drama1 = new Drama();

        drama.setDtitle("쌈, 마이웨이");
        drama.setDphoto(R.drawable.drama1);
        drama.setDstar(R.drawable.star6);
        drama.setDcomment("내 스타일은 아니지만...뭐...재밌다고 함.");
        addItem(drama);

        drama1.setDtitle("군주-가면의 주인");
        drama1.setDphoto(R.drawable.drama2);
        drama1.setDstar(R.drawable.star10);
        drama1.setDcomment("유승호, 김소현, 윤소희, 엘...그중에서도 김소현, 유승호가 최고!너무 이쁘고 너무 멋있다...(하트)");
        addItem(drama1);

        for(int i = 3; i <= 5; i++) {
            Drama drama3 = new Drama();
            drama3.setDtitle("그 외");
            drama3.setDphoto(getResources().getIdentifier("drama"+i, "drawable", getContext().getPackageName()));
            drama3.setDstar(R.drawable.star1);
            drama3.setDcomment("하나도 안봐서 몰겄다...뭐 잼나겠지?");
            addItem(drama3);
        }
    }

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
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.drama_item, null);
            }

            ImageView dphoto = (ImageView) convertView.findViewById(R.id.dphoto);
            TextView dtitle = (TextView) convertView.findViewById(R.id.dtitle);
            ImageView dstar = (ImageView) convertView.findViewById(R.id.dstar);
            TextView dcomment = (TextView) convertView.findViewById(R.id.dcomment);
            Drama drama = list.get(position);
            dphoto.setImageResource(drama.getDphoto());
            dtitle.setText(drama.getDtitle());
            dstar.setImageResource(drama.getDstar());
            dcomment.setText(drama.getDcomment());

            return convertView;
        }
    }

    public void addItem(Drama item) {
        list.add(item);
        // 데이터가 변경될 시 itemAdapter에게 알려주기
        itemAdapter.notifyDataSetChanged();
    }

    public void removeItem(Drama item) {
        list.remove(item);
        // 데이터가 변경될 시 itemAdapter에게 알려주기
        itemAdapter.notifyDataSetChanged();
    }
}
