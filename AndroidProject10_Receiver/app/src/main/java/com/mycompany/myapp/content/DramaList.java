package com.mycompany.myapp.content;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.mycompany.myapp.R;
import com.mycompany.myapp.dto.Drama;
import com.mycompany.myapp.dto.Food;
import com.mycompany.myapp.dto.Review;
import com.mycompany.myapp.fragment.FoodListFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class DramaList extends LinearLayout {

    private ListView listView;
    private List<Drama> list = new ArrayList<>();
    private ItemAdapter itemAdapter;
    private static final String TAG = DramaList.class.getSimpleName();

    public DramaList(Context context) {
        super(context);
        LayoutInflater inflater = LayoutInflater.from(getContext());
        listView = (ListView) inflater.inflate(R.layout.drama_list, null);
        itemAdapter = new ItemAdapter();
        listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(itemClickListener);
        addView(listView);
    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            // list.get(position) 이 명령어도 가능.
            Drama drama = (Drama) itemAdapter.getItem(position);
            Log.i(TAG, drama.getDtitle());
            Log.i(TAG, drama.getDcomment());
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