package com.example.copecloudreader.view.statusbar;

import android.content.Context;

import com.example.copecloudreader.MainActivity;

/**
 * Created by madandan on 2017/8/2.
 */

public class StatusBarUtil {

    public static int getStatusBarHeight(Context context) {
       int resourceID = context.getResources().getIdentifier("status_bar_height","dimen","android");
        return context.getResources().getDimensionPixelSize(resourceID);
    }
}
