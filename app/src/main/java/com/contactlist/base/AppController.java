package com.contactlist.base;

import android.app.Application;

import com.contactlist.helper.BLog;
import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by Ketan on 3/17/17.
 */

public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BLog.setShouldPrint(true);
        Fresco.initialize(this);
    }
}
