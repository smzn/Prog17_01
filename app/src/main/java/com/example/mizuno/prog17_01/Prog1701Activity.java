package com.example.mizuno.prog17_01;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Prog1701Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prog1701);

        ListView listView = (ListView)findViewById(R.id.ListView);
        TelephonyManager telephonyManager = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String[] members = {
            "DeviceID: " + telephonyManager.getDeviceId(),
            "SERIAL: " + Build.SERIAL,
            "ANDROID_ID " + android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID),
            "BOARD: " + Build.BOARD,
            "BOOTLOADER: " + Build.BOOTLOADER,
            "CPU_ABI: " + Build.CPU_ABI,
            "CPU_ABI2: " + Build.CPU_ABI2,
            "DEVICE: " + Build.DEVICE,
            "DISPLAY: " + Build.DISPLAY,
            "FINGERPRINT: " + Build.FINGERPRINT,
            "HARDWARE: " + Build.HARDWARE,
            "HOST: " + Build.HOST,
            "MANUFACTURER: " + Build.MANUFACTURER,
            "MODEL: " + Build.MODEL,
            "PRODUCT: " + Build.PRODUCT,
            "RADIO: " + Build.RADIO,
            "TAGS: " + Build.TAGS,
            "TIME: " + Build.TIME,
            "TYPE: " + Build.TYPE,
            "CODENAME: " + Build.VERSION.CODENAME,
            "INCREMENTAL: " + Build.VERSION.INCREMENTAL,
            "RELEASE: " + Build.VERSION.RELEASE,
            "SDK: " + Build.VERSION.SDK,
            "SDK_INT: " + Build.VERSION.SDK_INT
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, members);
        listView.setAdapter(adapter);
        AsyncHttp post = new AsyncHttp(android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID),"mizunolab005");
        post.execute();
    }
}
