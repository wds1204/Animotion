package com.example.wds.animotion;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LayoutAnimationActivity extends Activity {
    private ListView list_item;
    private ArrayList<String> lists = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_animation);
        getData();
        list_item = (ListView) findViewById(R.id.list_item);
        list_item.setAdapter(new MyListAdapter());
        /*用代码的方式*/
//        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_item);
//        LayoutAnimationController controller = new LayoutAnimationController(animation);
//        controller.setDelay(0.5f);
//        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
//        list_item.setLayoutAnimation(controller);


    }

    public ArrayList<String> getData() {
        for (int i = 0; i < 50; i++) {
            lists.add("测试数据" + i);
        }
        return lists;
    }

    private class MyListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return lists.size() > 0 ? lists.size() : 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(LayoutAnimationActivity.this).inflate(R.layout.list_item, null);
                holder.item_tv = (TextView) convertView.findViewById(R.id.item_tv);
                convertView.setTag(holder);

            } else {
                holder= (ViewHolder) convertView.getTag();
            }
            holder.item_tv.setText(lists.get(position));

            return convertView;
        }

        class ViewHolder {
            private TextView item_tv;
        }
    }
}
