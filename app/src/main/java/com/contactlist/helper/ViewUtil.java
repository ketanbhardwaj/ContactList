package com.contactlist.helper;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.WindowManager;

public class ViewUtil {

    public static void hideKeyboard(Activity activity) {
        activity.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    private static ProgressDialog progress;

    public static void showLoadingProgressDialog(Context context){
        progress = new ProgressDialog(context);
        progress.setMessage("Loading...");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        progress.setIndeterminate(true);
        progress.setCancelable(false);
        progress.show();
    }

    public static void hideLoadingProgressDialog(){
        if(progress != null)
            progress.dismiss();
    }

}
