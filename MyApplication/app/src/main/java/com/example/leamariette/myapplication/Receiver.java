package com.example.leamariette.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by leamariette on 16/03/2017.
 */

public class Receiver extends BroadcastReceiver {
    public void onReceive(Context context,
                          Intent intent) {
        intent.getAction();
        intent.getStringExtra("Coucoucou");

    }
}
