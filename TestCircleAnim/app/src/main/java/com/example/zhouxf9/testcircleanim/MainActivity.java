package com.example.zhouxf9.testcircleanim;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout content = new FrameLayout(this);
        content.setOnClickListener(null);
        ImageView bg = new ImageView(this);
        bg.setImageResource(R.drawable.ic_launcher_background);
        bg.setScaleType(ImageView.ScaleType.FIT_XY);
        content.addView(bg);
        final AnimationLoading loading = new AnimationLoading(this);
        content.addView(loading);
        setContentView(content);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //3s后停止加载动画
                loading.stopLoading();
            }
        }, 3000);
    }
}
