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

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                mi = new MyItem(jsonObj.getString("이름"), getResources().getIdentifier(jsonObj.getString("parkimg_name"), "drawable", getPackageName()));
                /*
                mi = new MyItem(jsonObj.getString("이름"),
                        getResources().getIdentifier(jsonObj.getString("parkimg_name"), "drawable", getPackageName()),
                        (jsonObj.getBoolean("bench") ? getResources().getIdentifier("ic_shortcut_bench", "drawable", getPackageName()) : null),
                        (jsonObj.getBoolean("camera") ? getResources().getIdentifier("ic_shortcut_camera", "drawable", getPackageName()) : null),
                        (jsonObj.getBoolean("parking") ? getResources().getIdentifier("ic_shortcut_parking", "drawable", getPackageName()) : null),
                        (jsonObj.getBoolean("playground") ? getResources().getIdentifier("ic_shortcut_playground", "drawable", getPackageName()) : null),
                        (jsonObj.getBoolean("pulling_up_training_silhouette") ? getResources().getIdentifier("ic_shortcut_pulling_up_training_silhouette", "drawable", getPackageName()) : null),
                        (jsonObj.getBoolean("road_with_two_placeholders") ? getResources().getIdentifier("ic_shortcut_road_with_two_placeholders", "drawable", getPackageName()) : null),
                        (jsonObj.getBoolean("roundabout") ? getResources().getIdentifier("ic_shortcut_roundabout", "drawable", getPackageName()) : null),
                        (jsonObj.getBoolean("toilet") ? getResources().getIdentifier("ic_shortcut_toilet", "drawable", getPackageName()) : null));
                */
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