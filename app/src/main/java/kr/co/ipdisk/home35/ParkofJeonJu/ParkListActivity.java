package kr.co.ipdisk.home35.ParkofJeonJu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParkListActivity extends AppCompatActivity {

    @Override
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

        ArrayList<MyItem> arItem = new ArrayList<MyItem>();
        MyItem mi;

        try {
            JSONObject root = new JSONObject(result);
            JSONArray jsonArray = root.getJSONArray("results");
            String[] name = new String[jsonArray.length()];
            String[] parkimg_name = new String[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                name[i] = jsonObj.getString("이름");
                parkimg_name[i] = jsonObj.getString("parkimg_name");
            }

            for (int i = 0; i < jsonArray.length(); i++) {
                mi = new MyItem(getResources().getIdentifier(parkimg_name[i], "drawable", getPackageName()), name[i]);
                arItem.add(mi);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MyListAdapter myListAdapter = new MyListAdapter(this, R.layout.list_content, arItem);

        ListView myList = (ListView) findViewById(R.id.list);
        myList.setAdapter(myListAdapter);
    }
}