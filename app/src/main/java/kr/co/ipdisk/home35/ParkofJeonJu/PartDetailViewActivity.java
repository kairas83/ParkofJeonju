package kr.co.ipdisk.home35.ParkofJeonJu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by kaira on 2016-11-30.
 */

public class PartDetailViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_detailview);

        Intent intent = getIntent();
        String part = intent.getStringExtra("part");

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

                if (jsonObj.getString("구").equals(part)) {

                    mi = new MyItem(jsonObj.getString("이름"),
                            getResources().getIdentifier(jsonObj.getString("parkimg_name"), "drawable", getPackageName()),
                            jsonObj.getInt("bench"),
                            jsonObj.getInt("camera"),
                            jsonObj.getInt("parking"),
                            jsonObj.getInt("playground"),
                            jsonObj.getInt("pulling_up_training_silhouette"),
                            jsonObj.getInt("roundabout"),
                            jsonObj.getInt("toilet"));

                    arItem.add(mi);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MyListAdapter myListAdapter = new MyListAdapter(this, R.layout.list_content, arItem);

        ListView myList = (ListView) findViewById(R.id.list);
        myList.setAdapter(myListAdapter);
    }
}
