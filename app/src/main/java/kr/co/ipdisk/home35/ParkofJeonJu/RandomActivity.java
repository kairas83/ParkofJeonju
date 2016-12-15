package kr.co.ipdisk.home35.ParkofJeonJu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

/**
 * Created by J2NN on 2016-11-30.
 */

    /*
        오늘의 추천 공원을 구현한 엑티비티.
     */
public class RandomActivity extends AppCompatActivity {

    Random mRand;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        mRand = new Random(); // 랜덤하게 임의의 공원을 객체로 생성한다.

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

        /*
            인텐트를 이용해서 이전 엑티비에서 받아온 이름을 가지고 데이터베이스에서 정보를가져온다.
         */
        try {
            JSONObject root = new JSONObject(result);
            JSONArray jsonArray = root.getJSONArray("results");

            int nResult =  mRand.nextInt(jsonArray.length());

            JSONObject jsonObj = jsonArray.getJSONObject(nResult);

            Intent intent = new Intent(getApplicationContext(), ParkDetailViewActivity.class);
            intent.putExtra("이름", jsonObj.getString("이름"));
            startActivity(intent);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        finish();
    }
}
