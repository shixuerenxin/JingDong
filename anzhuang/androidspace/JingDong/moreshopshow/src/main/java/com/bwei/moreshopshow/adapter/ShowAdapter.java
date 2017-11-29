package com.bwei.moreshopshow.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bwei.moreshopshow.R;
import com.bwei.moreshopshow.bean.ShopBean;

import java.util.List;

/**
 * author:Created by WangZhiQiang on 2017/11/29.
 */

public class ShowAdapter extends BaseAdapter {

    private Context context;
    private List<ShopBean.DataBean> list;

    public ShowAdapter(Context context, List<ShopBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       /* ViewHandler viewHandler=null;*/
        if (i%2==1){
            /*if (view==null){*/
                /*viewHandler=new ViewHandler();*/
            view = View.inflate(context, R.layout.layout_item2, null);
            ImageView imageView=(ImageView) view.findViewById(R.id.iv_shopshow2);
            TextView textView=(TextView) view.findViewById(R.id.tv_title2);
            TextView price=(TextView) view.findViewById(R.id.tv_price2);
            String images = list.get(i).getImages();
            String[] split = images.split("!");
            Glide.with(context).load(split[0]).into(imageView);
            textView.setText(list.get(i).getTitle());
            price.setText("￥"+list.get(i).getPrice());
        }else {
            view = View.inflate(context, R.layout.layout_item1, null);
            ImageView imageView=(ImageView) view.findViewById(R.id.iv_shopshow);
            TextView textView=(TextView) view.findViewById(R.id.tv_title1);
            TextView price=(TextView) view.findViewById(R.id.tv_price1);
            String images = list.get(i).getImages();
            String[] split = images.split("!");
            Glide.with(context).load(split[0]).into(imageView);
            textView.setText(list.get(i).getTitle());
            price.setText("￥"+list.get(i).getPrice());
        }
        return view;
    }
   /* class ViewHandler{
        TextView textView;
        ImageView imageView;
        TextView price;
    }*/
}
