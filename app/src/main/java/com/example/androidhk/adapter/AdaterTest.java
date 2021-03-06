package com.example.androidhk.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.androidhk.R;
import com.example.androidhk.model.Info;

import java.util.ArrayList;

public class AdaterTest extends BaseAdapter {
    private ArrayList<Info> list;
    Context context;
    private int resource;

    public AdaterTest(ArrayList<Info> list, Context context, int resource) {
        this.list = list;
        this.context = context;
        this.resource = resource;
    }

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

        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, null);
            viewHolder = new ViewHolder();
            viewHolder.id = convertView.findViewById(R.id.idnv);
            viewHolder.name = convertView.findViewById(R.id.tennv);
            convertView.setTag(viewHolder);
        }else {
           viewHolder=(ViewHolder)convertView.getTag();
        }
            Info info = list.get(position);
            viewHolder.id.setText(String.valueOf(info.getId())+"       ");
            viewHolder.name.setText(info.getTen());
            return convertView;
        }
        public class ViewHolder{
        TextView name,id;
        }
}






