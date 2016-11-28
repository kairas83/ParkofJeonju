package kr.co.ipdisk.home35.ParkofJeonJu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ParkListActivity extends AppCompatActivity {
    ArrayList<MyItem> arItem;
    MyItem mi;

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



        String eng_name = "parkimg_chamseam";
        String name = "";

        try{
            JSONObject root = new JSONObject(result);
            JSONArray jsonArray = root.getJSONArray("results");

            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                name = jsonObj.getString("이름");
                //eng_name = jsonObject.getString("eng_name");
            }
        }catch(JSONException e){
            e.printStackTrace();
        }


        arItem = new ArrayList<MyItem>();
        mi = new MyItem(getResources().getIdentifier(eng_name, "drawable", getPackageName()), name);
        arItem.add(mi);

/*
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_chamseam, "참새암 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_daga, "다가 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_dukjin, "덕진 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_ecocity, "에코 시티");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_garyunsan, "가련산 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_gijize, "진지제 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_girin, "기린 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_guma, "구마 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_hwasan, "화산 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_jangsung, "장성 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_jongsan, "종산 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_mansungjigu, "만성지구");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_nosong, "노송 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_sunsuchon, "선수촌 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_taepyuong_culture_park, "태평문화 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_wansan, "완산 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkimg_wolpyeong, "월평 공원");
        arItem.add(mi);
*/

        MyListAdapter myListAdapter = new MyListAdapter(this, R.layout.list_content, arItem);

        ListView myList = (ListView) findViewById(R.id.list);
        myList.setAdapter(myListAdapter);

    }


}

