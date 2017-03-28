package com.contactlist.helper;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;

import com.contactlist.R;

public class AppUtil {

    private static final String LOG_TAG = "AppUtil";
    static DisplayMetrics displayMetrics;
    static android.app.AlertDialog no_internet_alert = null;

    public static void showMessageOKCancel(Activity activity, String message, DialogInterface.OnClickListener okListener,
                                           DialogInterface.OnClickListener cancelListener) {
        new AlertDialog.Builder(activity)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", cancelListener)
                .create()
                .show();
    }

    public static ProgressDialog createProgressDialog(Context context, String title, String msg, boolean cancelable) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        if (title != null && title.length() > 0) {
            progressDialog.setTitle(title);
        }
        progressDialog.setMessage(msg);
        progressDialog.setCancelable(cancelable);
        progressDialog.setCanceledOnTouchOutside(cancelable);
        return progressDialog;
    }

    public static boolean isWifi(Context context) {
        final ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connMgr.getActiveNetworkInfo();
        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static boolean isCellular(Context context) {
        final ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connMgr.getActiveNetworkInfo();
        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void setCustomBackgroundDrawable(Context context, View view, int drawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(context.getResources().getDrawable(drawable));
        } else {
            view.setBackgroundDrawable(context.getResources().getDrawable(drawable));
        }
    }

    public static int[] calculateImageSize(Context context, float image_width_height_ratio, int view_padding, float imageView_screen_ratio) {
        int[] scaledWidthHeight = {-1, -1};
        try {
            int padding = dpToPx((Activity) context, view_padding);
            int new_width = (int) (((getDisplaySize((Activity) context)[0]) * imageView_screen_ratio) - padding);

            int new_height = (int) ((float) new_width * (image_width_height_ratio));
            scaledWidthHeight[0] = new_width;
            scaledWidthHeight[1] = new_height;
        } catch (Exception e) {
        }
        return scaledWidthHeight;
    }

    public static int[] getDisplaySize(Activity mActivity) {
        Display display = mActivity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        int[] arr = new int[2];
        arr[0] = width;
        arr[1] = height;
        return arr;
    }

    public static int dpToPx(Activity activity, int dp) {
        if (displayMetrics == null) displayMetrics = activity.getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
    }

    public static boolean check_internet(Context context, boolean should_notify, boolean cancelable) {
        boolean is_connected = check_internet_connection(context);
        if (!is_connected && should_notify) {
            show_no_internet((Activity) context, cancelable);
        }
        return is_connected;
    }

    public static Boolean check_internet_connection(Context activity) {
        ConnectivityManager cm = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        return Boolean.valueOf(isConnected);
    }

    public static void show_no_internet(final Activity activity, final boolean cancelable) {
        try {
            no_internet_alert = (new android.app.AlertDialog.Builder(activity)).create();
            View e = activity.getLayoutInflater().inflate(R.layout.nointernet_layout_full, (ViewGroup) null);
            no_internet_alert.setView(e);
            no_internet_alert.requestWindowFeature(1);
            android.view.WindowManager.LayoutParams wmlp = no_internet_alert.getWindow().getAttributes();
            wmlp.gravity = 48;
            no_internet_alert.setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialog) {
                    if (no_internet_alert != null) {
                        no_internet_alert.dismiss();
                        no_internet_alert = null;
                    }
                    if (!cancelable)
                        activity.finish();

                }
            });
            no_internet_alert.show();
        } catch (Exception var3) {
            BLog.e("Common", "Exception - " + var3.toString(), var3);
        }
    }

    public static int getTotalFragments(int size){
        int n;
        int mod = size % 4;
        if(mod == 0){
            n = size / 4;
        }else{
            n = (size / 4) + 1;
        }
        return n;
    }


}
