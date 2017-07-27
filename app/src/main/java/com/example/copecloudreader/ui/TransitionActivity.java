package com.example.copecloudreader.ui;

import android.content.ContentUris;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.copecloudreader.MainActivity;
import com.example.copecloudreader.R;
import com.example.copecloudreader.app.ConstantsImageUrl;
import com.example.copecloudreader.databinding.ActivityTransitionBinding;
import com.example.copecloudreader.utils.PerfectClickListener;

import java.util.Random;

public class TransitionActivity extends AppCompatActivity {
    private ActivityTransitionBinding mBinding;
    private boolean isIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding =DataBindingUtil.setContentView(this,R.layout.activity_transition);
        int i = new Random().nextInt(ConstantsImageUrl.TRANSITION_URLS.length);
        // 先显示默认图
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBinding.ivDefultPic.setImageDrawable(getResources().getDrawable(R.drawable.img_transition_default,null));
        }else {
            mBinding.ivDefultPic.setImageDrawable(getResources().getDrawable(R.drawable.img_transition_default));
        }
        Glide.with(this)
                .load(ConstantsImageUrl.TRANSITION_URLS[i])
               /* .placeholder(R.drawable.img_transition_default)
                .error(R.drawable.img_transition_default)*/
                .into(mBinding.ivPic);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
             mBinding.ivDefultPic.setVisibility(View.GONE);
            }
        },1500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               toMainActivity();
            }
        },3500);

        mBinding.tvJump.setOnClickListener(new PerfectClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                toMainActivity();
            }
        });

    }

    private void toMainActivity() {
        if (isIn){
            return;
        }else {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.screen_zoom_in,R.anim.screen_zoom_out);
            finish();
            isIn = true;
        }
    }
}
