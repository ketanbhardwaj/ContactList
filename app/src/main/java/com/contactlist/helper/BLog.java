package com.contactlist.helper;

import android.util.Log;

/**
 * Created by ketan on 3/13/17.
 */

public class BLog {

    private static final String LOG_TAG = "BLOG";
    public static boolean should_print;

    public BLog() {
    }

    public static void setShouldPrint(boolean set) {
        should_print = set;
        if(should_print) {
            e("BLOG", "BLOG is enabled!");
        }

    }

    public static void i(String tag, String message) {
        if(should_print && tag != null && message != null) {
            Log.i(tag, message);
        }

    }

    public static void e(String tag, String message) {
        if(should_print && tag != null && message != null) {
            Log.e(tag, message);
        }

    }

    public static void d(String tag, String message) {
        if(should_print && tag != null && message != null) {
            Log.e(tag, message);
        }

    }

    public static void e(String tag, String message, Throwable tr) {
        if(should_print && tag != null && message != null) {
            Log.e(tag, message, tr);
        }

    }

    public static void l(String tag, String str) {
        if(should_print && str != null) {
            if(str.length() > 4000) {
                i(tag, str.substring(0, 4000));
                l(tag, str.substring(4000));
            } else {
                i(tag, str);
            }
        }

    }

}
