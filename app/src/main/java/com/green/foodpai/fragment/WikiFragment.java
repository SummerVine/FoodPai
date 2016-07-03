package com.green.foodpai.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.green.foodpai.MyApp;
import com.green.foodpai.R;
import com.green.foodpai.adapter.RvAdapter;
import com.green.foodpai.bean.Wiki;
import com.green.foodpai.uri.Uri;
import com.green.foodpai.utils.FullyGridLayoutManager;

import java.util.ArrayList;

/**
 * Created by 86724 on 2016/7/3 0003.
 */
public class WikiFragment extends BaseFragment {
    private View view;
    private RecyclerView classRV;
    private RecyclerView brandRv;
    private RecyclerView chainRv;
    private GridLayoutManager cLayoutManager;
    private RvAdapter classAdapter;
    private RvAdapter brandAdapter;
    private RvAdapter chainAdapter;
    private StringRequest stringRequest;
    private GridLayoutManager bLayoutManager;
    private GridLayoutManager ccLayoutManager;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view  = View.inflate(getContext(), R.layout.wikilayout,null);
        initView();
        classAdapter = new RvAdapter(new ArrayList<Wiki.GroupBean>(),getContext(),0);
        classRV.setAdapter(classAdapter);
        brandAdapter = new RvAdapter(new ArrayList<Wiki.GroupBean>(),getContext(),1);
        brandRv.setAdapter(brandAdapter);
        chainAdapter = new RvAdapter(new ArrayList<Wiki.GroupBean>(),getContext(),2);
        chainRv.setAdapter(chainAdapter);
        loadData();
        return view;
    }

    private void loadData() {
        stringRequest = new StringRequest(Uri.URL_WIKIS_I, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                Wiki wiki = gson.fromJson(response,Wiki.class);
                classAdapter.addAll(wiki.getGroup());
                brandAdapter.addAll(wiki.getGroup());
                chainAdapter.addAll(wiki.getGroup());
            }
        },null);
        stringRequest.setTag("qx");
        MyApp.getApp().getRequestQueue().add(stringRequest);
    }

    private void initView() {
        cLayoutManager = new FullyGridLayoutManager(getContext(),3);
        bLayoutManager = new FullyGridLayoutManager(getContext(),3);
        ccLayoutManager = new FullyGridLayoutManager(getContext(),3);
        classRV = ((RecyclerView) view.findViewById(R.id.food_class_rv));
        classRV.setHasFixedSize(true);
        classRV.setLayoutManager(cLayoutManager);
        brandRv = ((RecyclerView) view.findViewById(R.id.hot_brand_rv));
        brandRv.setHasFixedSize(true);
        brandRv.setLayoutManager(bLayoutManager);
        chainRv = ((RecyclerView) view.findViewById(R.id.food_chain_rv));
        chainRv.setHasFixedSize(true);
        chainRv.setLayoutManager(ccLayoutManager);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        MyApp.getApp().getRequestQueue().cancelAll("qx");
    }
}
