package com.example.copecloudreader.view.statusbar;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.view.Window;
import android.view.WindowManager;

import com.example.copecloudreader.MainActivity;

/**
 * Created by madandan on 2017/8/2.
 */

public class StatusBarUtil {

    public static int getStatusBarHeight(Context context) {
       int resourceID = context.getResources().getIdentifier("status_bar_height","dimen","android");
        return context.getResources().getDimensionPixelSize(resourceID);
    }

    /**
     * 为DrawerLayout 布局设置状态栏颜色,纯色
     *
     * @param activity     需要设置的activity
     * @param drawerLayout DrawerLayout
     * @param color        状态栏颜色值
     */
    public static  void setColorNoTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout,int color){
        setColorForDrawerLayout(activity,drawerLayout,color,0);

    }
/**
 * 为DrawerLayout布局设置状态栏变色
 * @param activity 需要设置的Activity
 * @param  drawerLayout  DrawerLayout
 * @param color 状态栏颜色
 * @param statusBarAlpha 状态栏透明度
 */
    private static void setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int color, int statusBarAlpha) {
  if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT){
      return;
  }
  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
      activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      activity.getWindow().setStatusBarColor(color);
  }
  else {
      activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
  }
    }

}
