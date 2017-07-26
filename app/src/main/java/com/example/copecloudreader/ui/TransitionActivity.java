package com.example.copecloudreader.ui;

import android.content.ContentUris;
import android.databinding.DataBindingUtil;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.copecloudreader.R;
import com.example.copecloudreader.app.ConstantsImageUrl;
import com.example.copecloudreader.databinding.ActivityTransitionBinding;

import java.util.Random;

public class TransitionActivity extends AppCompatActivity {
    private ActivityTransitionBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding =DataBindingUtil.setContentView(this,R.layout.activity_transition);
        int i = new Random().nextInt(ConstantsImageUrl.TRANSITION_URLS.length);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mBinding.ivDefultPic.setImageDrawable(getResources().getDrawable(R.drawable.img_transition_default,null));
        }else {
            mBinding.ivDefultPic.setImageDrawable(getResources().getDrawable(R.drawable.img_transition_default));
        }

    }
}
