package com.contactlist.helper;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.support.v4.app.ActivityCompat;

import com.contactlist.model.CallLogsModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ketan on 3/19/17.
 */

public class PhonebookUtil {

    private static final String LOG_TAG = "PhonebookUtil" ;

    public static String getContactName(Context context, String number) {
        String name = null;
        String[] projection = new String[]{
                ContactsContract.PhoneLookup.DISPLAY_NAME,
                ContactsContract.PhoneLookup._ID};

        Uri contactUri = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(number));

        Cursor cursor = context.getContentResolver().query(contactUri, projection, null, null, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                name = cursor.getString(cursor.getColumnIndex(ContactsContract.PhoneLookup.DISPLAY_NAME));
                BLog.e(LOG_TAG, "Started uploadcontactphoto: Contact Found @ " + number);
                BLog.e(LOG_TAG, "Started uploadcontactphoto: Contact name  = " + name);
            } else {
                BLog.e(LOG_TAG, "Contact Not Found @ " + number);
            }
            cursor.close();
        }
        return name;
    }

    public static String getDurationString(int seconds) {
        BLog.e(LOG_TAG, "Enter value - "+seconds);
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        seconds = seconds % 60;
        return twoDigitString(hours) + " : " + twoDigitString(minutes) + " : " + twoDigitString(seconds);
    }

    private static String twoDigitString(int number) {
        if (number == 0) {
            return "00";
        }

        if (number / 10 == 0) {
            return "0" + number;
        }

        return String.valueOf(number);
    }

}
