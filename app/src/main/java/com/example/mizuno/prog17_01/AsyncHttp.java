package com.example.mizuno.prog17_01;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mizuno on 2017/02/22.
 */

public class AsyncHttp extends AsyncTask<String, Integer, Boolean> {
    String id, name;

    public AsyncHttp(String id, String name) {
        this.id = id;
        this.name = name;
    }

    HttpURLConnection urlConnection = null; //HTTPコネクション管理用
    Boolean flg = false;

    @Override
    protected Boolean doInBackground(String... params) {
        String urlinput = "http://ms000.sist.ac.jp/oc/devices/add";

        URL url = null;
        try {
            url = new URL(urlinput);
            urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            String postDataSample = "id="+this.id+"&name="+this.name;
            OutputStream out = urlConnection.getOutputStream();
            out.write(postDataSample.getBytes());
            out.flush();
            out.close();
            urlConnection.getInputStream();
            flg = true;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flg;
    }
}
