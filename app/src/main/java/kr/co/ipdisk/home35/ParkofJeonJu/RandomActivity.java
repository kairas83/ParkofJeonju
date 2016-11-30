package kr.co.ipdisk.home35.ParkofJeonJu;

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

        int nResult = getRandom(27, 0); //랜덤 int 출력

        String name; // nResult 포지션에 있는 공원 이름

        TextView _name = (TextView) findViewById(R.id.park_name);
        _name.setText(name);

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

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                if (jsonObj.getString("이름").equals(name)) {
                    ImageView p_image = (ImageView) findViewById(R.id.image);
                    p_image.setImageResource(getResources().getIdentifier(jsonObj.getString("parkimg_name"), "drawable", getPackageName()));

                    TextView p_name = (TextView) findViewById(R.id.name);
                    p_name.setText(jsonObj.getString("이름"));

                    TextView p_part = (TextView) findViewById(R.id.part);
                    p_part.setText(jsonObj.getString("구분"));

                    TextView p_place = (TextView) findViewById(R.id.address);
                    p_place.setText(jsonObj.getString("세부주소"));

                    TextView p_size = (TextView) findViewById(R.id.size);
                    p_size.setText(jsonObj.getString("면적")+"m2");

                    TextView p_phoneNumber = (TextView) findViewById(R.id.phone_number);
                    p_phoneNumber.setText(jsonObj.getString("연락처"));


                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getRandom(int max, int offset) {

        int nResult = mRand.nextInt(max) + offset;

        return nResult;

    }
}
