package com.bwei.moreshopshow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.bwei.moreshopshow.adapter.ShowAdapter;
import com.bwei.moreshopshow.bean.ShopBean;
import com.bwei.moreshopshow.utils.CallBack;
import com.bwei.moreshopshow.utils.OkhttpUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lvShow;
    private List<ShopBean.DataBean> list;
    private ShowAdapter showAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvShow = (ListView) findViewById(R.id.lv_show);
        list = new ArrayList<>();
        showAdapter = new ShowAdapter(MainActivity.this, list);
        lvShow.setAdapter(showAdapter);
        addinit();
    }

    private void addinit() {
        OkhttpUtils okhttpUtils = new OkhttpUtils();
        okhttpUtils.get("http://120.27.23.105/product/getProducts?pscid=39&page=1", ShopBean.class, new CallBack() {
            @Override
            public void onSuccess(Object o) {
                ShopBean shopBean= (ShopBean) o;
                list.addAll(shopBean.getData());
                showAdapter.notifyDataSetChanged();

            }
            @Override
            public void onFailed(Exception e) {
                Toast.makeText(MainActivity.this,""+e,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
