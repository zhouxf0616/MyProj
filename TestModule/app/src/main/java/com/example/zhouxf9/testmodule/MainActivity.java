package com.example.zhouxf9.testmodule;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;

import com.example.mysdk.TestActivity;




public class MainActivity extends AppCompatActivity implements Animator.AnimatorListener{

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    boolean isFaster = false;
    int rotate = 360;
    int i = 1;
    int speed_start = 1000;
    int speed_start1 = 1500;
    int speed_start2 = 800;
    int currentSpeed = 1;
    boolean isStart = false;
    ViewPropertyAnimator animate;
    private ViewPropertyAnimator animate11;
    private ViewPropertyAnimator animate22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View img = findViewById(R.id.pic_iv);
        final View img11 = findViewById(R.id.pic_iv1);
        final View img22 = findViewById(R.id.pic_iv2);
        final View img1 = findViewById(R.id.pic_iv_1);
        final View img2 = findViewById(R.id.pic_iv_2);
        final View img3 = findViewById(R.id.pic_iv_3);
        animate = img.animate().withLayer().setInterpolator(new LinearInterpolator()).setListener(this);
        animate11 = img11.animate().withLayer().setInterpolator(new LinearInterpolator()).setListener(this);
        animate22 = img22.animate().withLayer().setInterpolator(new LinearInterpolator()).setListener(this);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSpeed = 1;
                anim(currentSpeed);
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSpeed = 2;
                anim(currentSpeed);
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSpeed = 3;
                anim(currentSpeed);
            }
        });

        findViewById(R.id.test_btn).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, TestActivity.class));
                startActivity(new Intent(MainActivity.this, TestActivity.class), ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });
    }

    private void anim(int curSp) {
        animate.rotationBy(720).setDuration(speed_start*curSp);
        animate11.rotationBy(720).setDuration(speed_start1*curSp);
        animate22.rotationBy(720).setDuration(speed_start2*curSp);
    }

    @Override
    public void onAnimationStart(Animator animation, boolean isReverse) {

    }

    @Override
    public void onAnimationEnd(Animator animation, boolean isReverse) {

    }

    @Override
    public void onAnimationStart(Animator animator) {

    }

    @Override
    public void onAnimationEnd(Animator animator) {
        anim(currentSpeed);
    }

    @Override
    public void onAnimationCancel(Animator animator) {

    }

    @Override
    public void onAnimationRepeat(Animator animator) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
