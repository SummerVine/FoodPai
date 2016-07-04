package com.green.foodpai.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.green.foodpai.R;
import com.green.foodpai.fragment.BaseFragment;
import com.green.foodpai.fragment.FirstFragment;
import com.green.foodpai.fragment.WikiFragment;
import com.green.foodpai.utils.TabFragmentsUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private List<BaseFragment> fragments;
    private FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup = ((RadioGroup) findViewById(R.id.gr_id));
        initFragment();
        TabFragmentsUtils tabfragmentUtiles=new TabFragmentsUtils(radioGroup,fragments,fragmentManager,R.id.main_rlfragment);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new FirstFragment());
        fragments.add(new WikiFragment());
        fragments.add(new FirstFragment());

    }

}
