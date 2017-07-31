package com.example.copecloudreader.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.example.copecloudreader.app.CloudReaderApplication;


/**
 * Created by madandan on 2017/7/26.
 */

public class CommonUtils {
    public static Drawable getDrawable(int resId, Resources.Theme theme) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return getResource().getDrawable(resId, theme);
        } else {
            return getResource().getDrawable(resId);
        }
    }

    public static Resources getResource() {
        return CloudReaderApplication.getInstance().getResources();
    }

}