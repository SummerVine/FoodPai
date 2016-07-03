package com.green.foodpai.welcome;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.green.foodpai.MainActivity;
import com.green.foodpai.R;


/**
 * Created by green on 2016/7/2.
 */
public class Welcomeface extends AppCompatActivity{
    private ImageView iv_welcome_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        iv_welcome_id = ((ImageView) findViewById(R.id.iv_welcome_id));
        new Thread() {
            @Override
            public void run() {
                SystemClock.sleep(1000);
                Welcomeface.this.startActivity(new Intent(
                        Welcomeface.this, MainActivity.class));
                finish();
            }
        }.start();
    }

}
