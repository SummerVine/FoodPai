package com.green.foodpai.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.green.foodpai.MyApp;
import com.green.foodpai.R;
import com.green.foodpai.adapter.HomeAdapter;
import com.green.foodpai.bean.Feeds;
import com.green.foodpai.uri.Uri;

import java.util.ArrayList;


/**
 * Created by green on 2016/7/3.
 */
public class FirstFragment extends BaseFragment {

    private ViewPager first_Viewpager_id;
    private RecyclerView first_recycler_id;
    private LinearLayoutManager mLayoutManager;
    private HomeAdapter homeAdapter;

    private StringRequest stringrequest;
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        //获得RecycleView
        View view=inflater.inflate(R.layout.first_fragment,container,false);

        first_recycler_id = ((RecyclerView) view.findViewById(R.id.first_recycler_id));
        //获得ViewPager
        View view1=inflater.inflate(R.layout.first_hand_layout,container,false);

        first_Viewpager_id=((ViewPager) view1.findViewById(R.id.first_Viewpager_id));
//        HomeAdapter homeAdapter=new HomeAdapter();

        mLayoutManager=new LinearLayoutManager(getContext());

        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        first_recycler_id.setHasFixedSize(true);


        first_recycler_id.setLayoutManager(mLayoutManager);

        homeAdapter=  new HomeAdapter(new ArrayList<Feeds.FeedsBean>(),getContext());

        first_recycler_id.setAdapter(homeAdapter);

        LoadData();

        return view;
    }

    private void LoadData() {
        for(int i=1;i<=13;i++) {

            String string=Uri.URL_SHOW_LIST+"i";
            stringrequest = new StringRequest(string, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Gson gson = new Gson();
                    Feeds feeds = gson.fromJson(response, Feeds.class);
                    homeAdapter.addAll(feeds.getFeeds());
                }
            }, null);

        }
            stringrequest.setTag("px");
            MyApp.getApp().getRequestQueue().add(stringrequest);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MyApp.getApp().getRequestQueue().cancelAll("px");


    }
}


