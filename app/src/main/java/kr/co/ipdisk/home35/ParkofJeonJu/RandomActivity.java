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

public class RandomActivity extends AppCompatActivity {

    Random mRand;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        mRand = new Random();

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
