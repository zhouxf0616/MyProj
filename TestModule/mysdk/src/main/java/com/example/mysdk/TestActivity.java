package com.example.mysdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.transition.Explode;
import android.view.View;
import android.widget.Toast;

import org.jetbrains.annotations.Nullable;

/**
 * Created by zhouxf9 on 2017-12-26.
 */

public class TestActivity extends Activity {

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        getWindow().setEnterTransition(new Explode().setDuration(2000));
        getWindow().setExitTransition(new Explode().setDuration(2000));
        findViewById(R.id.test_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(TestActivity.this, "调用成功！", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
