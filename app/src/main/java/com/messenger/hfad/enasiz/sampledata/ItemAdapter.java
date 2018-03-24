package com.messenger.hfad.enasiz.sampledata;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.messenger.hfad.enasiz.R;

import java.util.List;

/**
 * Created by Nahom on 2018-03-23.
 */

public class ItemAdapter extends BaseAdapter {
    private Activity mActivity;
    private LayoutInflater mInflater;
    private List<Item> items;
    ImageLoader mImageLoader = AppController.getmInstance().getmImageLoader();
    public ItemAdapter(Activity activity, List<Item> items){
        this.mActivity =activity;
        this.items = items;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(mInflater == null){
            mInflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view == null){
            view = mInflater.inflate(R.layout.my_listview_detail,null);
        }
        if(mImageLoader == null){

            NetworkImageView imageView = (NetworkImageView) view.findViewById(R.id.imageView);
            TextView title = view.findViewById(R.id.tv_title);
            TextView rate = view.findViewById(R.id.tv_rate);
            TextView genre = view.findViewById(R.id.tv_genre);
            TextView year = view.findViewById(R.id.tv_year);
            mImageLoader = AppController.getmInstance().getmImageLoader();

            Item item = items.get(i);
            imageView.setImageUrl(item.getImage(), mImageLoader);
            title.setText(item.getTitle());
            rate.setText(item.getTitle());
            String genreStr = "";
            for (String str :item.getGenre()){
                genreStr += str +",";
            }
            year.setText(String.valueOf(item.getYear()));
        }
        return view;
    }
}