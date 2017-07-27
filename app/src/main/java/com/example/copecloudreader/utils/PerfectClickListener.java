package com.example.copecloudreader.utils;

import android.content.DialogInterface;
import android.view.View;

/**
 * Created by madandan on 2017/7/27.
 */

public abstract class PerfectClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {

    }
    protected abstract void onNoDoubleClick(View v);
}
