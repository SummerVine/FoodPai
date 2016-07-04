package com.green.foodpai.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;

/**
 * Created by green on 2016/7/3.
 */
public class HeadAdapter extends PagerAdapter {
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return false;
    }
}
