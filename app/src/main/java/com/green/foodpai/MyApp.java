package com.green.foodpai;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by 86724 on 2016/7/3 0003.
 */
public class MyApp extends Application {
    private static MyApp app;
    private RequestQueue requestQueue;

    public static MyApp getApp() {
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.app = this;
        initVolley();
    }

    private void initVolley() {
        requestQueue = Volley.newRequestQueue(this);
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}