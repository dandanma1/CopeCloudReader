package com.example.copecloudreader.app;

import android.app.Application;
import android.content.res.Resources;

/**
 * Created by madandan on 2017/7/27.
 */

public class CloudReaderApplication extends Application{
    private static CloudReaderApplication cloudReaderApplication;

    public static CloudReaderApplication getInstance() {
        return cloudReaderApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        cloudReaderApplication = this;
    }
}
