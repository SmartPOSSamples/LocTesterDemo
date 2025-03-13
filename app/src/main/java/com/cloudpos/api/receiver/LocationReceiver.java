package com.cloudpos.api.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.cloudpos.api.MainActivity;
import com.cloudpos.utils.Logger;

public class LocationReceiver extends BroadcastReceiver {
    private static final String TAG = "LockReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        ACTION = intent.getAction();
        GPS = String.format("latitude = %s, longitude = %s", intent.getDoubleExtra("latitude", -1), intent.getDoubleExtra("longitude", -1));
        Logger.debug("LocationReceiver onReceive(%s)", ACTION);
        Intent jump = new Intent(context, MainActivity.class);
        jump.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(jump);
    }

    public static String ACTION = "";
    public static String GPS = "";
}
