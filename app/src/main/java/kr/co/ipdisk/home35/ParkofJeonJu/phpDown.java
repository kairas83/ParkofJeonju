package kr.co.ipdisk.home35.ParkofJeonJu;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kairas on 2016-11-23.
 */

    /*
    Thread 를 이용해서 데이터베이스에서 자료를 가져온다.
     */
public class phpDown extends Thread {

    private String result;
    private String url;

    public phpDown(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        final String output = request(url);
        result = output;
    }

    public String getResult() {
        return result;
    }

    private String request(String urlStr) {
        StringBuilder output = new StringBuilder();

        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            if (conn != null) {
                conn.setConnectTimeout(10000);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                int resCode = conn.getResponseCode();
                if (resCode == HttpURLConnection.HTTP_OK) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line;
                    while(true) {
                        line = reader.readLine();
                        if (line == null) {
                            break;
                        }
                        output.append(line + "\n");
                    }
                    reader.close();
                    conn.disconnect();
                }
            }
        } catch (Exception e) {
            Log.e("SampleHTTP", "Exception in processing response.", e);
            e.printStackTrace();
        }
        return output.toString();
    }
}
