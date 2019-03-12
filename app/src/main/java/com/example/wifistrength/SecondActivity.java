package com.example.wifistrength;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        WifiManager wifiManager = (WifiManager) this.getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        int rssi = wifiManager.getConnectionInfo().getRssi();

        int calc = wifiManager.calculateSignalLevel(rssi,5);
        String ssid;
        WifiInfo info = wifiManager.getConnectionInfo ();

        ssid = info.getSSID();


        TextView textView = findViewById(R.id.val);
        textView.setText(calc);

        String Mytextmessage  = ssid;
        try {
            FileOutputStream fileOutputStream = openFileOutput("myText.txt",MODE_PRIVATE);
            fileOutputStream.write(Mytextmessage.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(),"Text Saved", Toast.LENGTH_LONG).show();
            //editTex.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
