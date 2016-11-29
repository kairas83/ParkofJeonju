package kr.co.ipdisk.home35.ParkofJeonJu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParkListActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(kr.co.ipdisk.home35.ParkofJeonJu.R.layout.activity_parklist);
        setTitle("공원 목록");

        String test = "http://home35.ipdisk.co.kr/msd/SelectAllItem.php";
        phpDown task = new phpDown(test);

        task.start();
        String result;

        try {
            task.join();
            System.out.println("waiting... for result");
        } catch (InterruptedException e) {

        } finally {
            result = task.getResult();
        }


        String parkimg_name = "parkimg_chamseam";
        String[] name = {};
        JSONObject root;
        JSONArray jsonArray = null;
        JSONObject jsonObj;
        ArrayList<MyItem> arItem;
        MyItem mi;

        try {
            root = new JSONObject(result);
            jsonArray = root.getJSONArray("results");
            name = new String[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObj = jsonArray.getJSONObject(i);

                name[i] = jsonObj.getString("이름");
                //parkimg_name = jsonObject.getString("parkimg_name");//TODO DB에 parkimg_name 칼럼 추가
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            arItem = new ArrayList<MyItem>();
            for (int i = 0; i < jsonArray.length(); i++) {
                mi = new MyItem(getResources().getIdentifier(parkimg_name, "drawable", getPackageName()), name[i]);
                arItem.add(mi);
            }
        }

        MyListAdapter myListAdapter = new MyListAdapter(this, R.layout.list_content, arItem);

        ListView myList = (ListView) findViewById(R.id.list);
        myList.setAdapter(myListAdapter);
    }
}

