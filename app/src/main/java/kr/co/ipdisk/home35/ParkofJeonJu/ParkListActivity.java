package kr.co.ipdisk.home35.ParkofJeonJu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

    /*
       공원 리스트를 보여주는 엑티비티

     */

public class ParkListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(kr.co.ipdisk.home35.ParkofJeonJu.R.layout.activity_park_list_view); // 공원 리스트 레이아웃을 사용한다.

        String test = "http://home35.ipdisk.co.kr/msd/SelectAllItem.php"; // 데이터베이스 PHP 주소
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


        ArrayList<MyItem> arItem = new ArrayList<MyItem>(); // MyItem 에 있는 어레이들을 이용해서 객체를 생성한다.
        MyItem mi;

        try {
            JSONObject root = new JSONObject(result);
            JSONArray jsonArray = root.getJSONArray("results");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                mi = new MyItem(jsonObj.getString("이름"),
                        jsonObj.getString("parkimg_name"),
                        jsonObj.getInt("bench"),
                        jsonObj.getInt("camera"),
                        jsonObj.getInt("parking"),
                        jsonObj.getInt("playground"),
                        jsonObj.getInt("pulling_up_training_silhouette"),
                        jsonObj.getInt("roundabout"),
                        jsonObj.getInt("toilet"));

                arItem.add(mi);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MyListAdapter myListAdapter = new MyListAdapter(this, R.layout.list_content, arItem);  // 데이터를 가져 온 이후에 list_content에 뿌려주는 역할

        ListView myList = (ListView) findViewById(R.id.list);
        myList.setAdapter(myListAdapter);
    }
}