package kr.co.ipdisk.home35.ParkofJeonJu;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kairas on 2016-11-23.
 */


class phpDown extends AsyncTask<String> {

    @Override
    protected String doInBackground(String urls) {
        StringBuilder jsonHtml = new StringBuilder();
        try{
            // 연결 url 설정
            URL url = new URL(urls[0]);
            // 커넥션 객체 생성
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            // 연결되었으면.
            if(conn != null){
                conn.setConnectTimeout(10000);
                conn.setUseCaches(false);
                // 연결되었음 코드가 리턴되면.
                if(conn.getResponseCode() == HttpURLConnection.HTTP_OK){
                    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                    for(;;){
                        // 웹상에 보여지는 텍스트를 라인단위로 읽어 저장.
                        String line = br.readLine();
                        if(line == null) break;
                        // 저장된 텍스트 라인을 jsonHtml에 붙여넣음
                        jsonHtml.append(line + "\n");
                    }
                    br.close();
                }
                conn.disconnect();
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return jsonHtml.toString();

    }

    protected void onPostExecute(String str){

        String imgurl;
        String txt1;
        String txt2;
        try{

            JSONObject root = new JSONObject(str);
            JSONArray ja = root.getJSONArray("results");
            for(int i=0; i<ja.length(); i++){
                JSONObject jo = ja.getJSONObject(i);
                imgurl = jo.getString("imgurl");
                txt1 = jo.getString("txt1");
                txt2 = jo.getString("txt2");
                listItem.add(new ListItem(imgurl,txt1,txt2));
            }
        }catch(JSONException e){
            e.printStackTrace();
        }
        txtView.setText("urlimg :"+listItem.get(0).getData(0)+"\ntxt1:"+ listItem.get(0).getData(1)+"\ntxt2:"+listItem.get(0).getData(2));
    }


}



}

/*
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
                    String line = null;
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
*/