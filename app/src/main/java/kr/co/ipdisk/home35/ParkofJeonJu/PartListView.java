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


    /*
       분류별 공원 리스트를 보여주는 엑티비티
     */
public class PartListView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_list_view);

        Intent intent = getIntent();
        String part = intent.getStringExtra("part");  // 앞의 분류별 공원에서 덕진구 혹은 완산구를 눌렀을대 PART 로 넘겨받은

        String test = "http://home35.ipdisk.co.kr/msd/SelectAllItem.php";  // 데이터베이스 PHP 주소
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

        ArrayList<MyItem> arItem = new ArrayList<MyItem>();  // MyItem 에 있는 어레이들을 이용해서 객체를 생성한다.
        MyItem mi;



        /*
            이름을 이용해서 데이터베이스에서 데이터를 읽어온다.
         */
        try {
            JSONObject root = new JSONObject(result);
            JSONArray jsonArray = root.getJSONArray("results");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                if (jsonObj.getString("구").equals(part)) {

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
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        MyListAdapter myListAdapter = new MyListAdapter(this, R.layout.list_content, arItem);

        ListView myList = (ListView) findViewById(R.id.list);
        myList.setAdapter(myListAdapter);
    }
}
