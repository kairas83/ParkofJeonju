package kr.co.ipdisk.home35.ParkofJeonJu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by LG on 2016-11-23.
 */

public class ParkDetailViewActivity extends FragmentActivity implements OnMapReadyCallback {
    String name = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_detail_view);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent intent = getIntent();
        name = intent.getStringExtra("이름");

        TextView park_name = (TextView) findViewById(R.id.park_name);
        park_name.setText(name);

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

                    ImageView image = (ImageView) findViewById(R.id.image);
                    if (jsonObj.getString("parkimg_name").equals(""))
                        image.setImageResource(getResources().getIdentifier("parkimg_default", "drawable", getPackageName()));
                    else
                        image.setImageResource(getResources().getIdentifier(jsonObj.getString("parkimg_name"), "drawable", getPackageName()));

                    ImageView bench = (ImageView) findViewById(R.id.ic_shortcut_bench);
                    if (jsonObj.getInt("bench") == 1)
                        bench.setImageResource(getResources().getIdentifier("ic_shortcut_bench", "drawable", getPackageName()));

                    ImageView camera = (ImageView) findViewById(R.id.ic_shortcut_camera);
                    if (jsonObj.getInt("camera") == 1)
                        camera.setImageResource(getResources().getIdentifier("ic_shortcut_camera", "drawable", getPackageName()));

                    ImageView parking = (ImageView) findViewById(R.id.ic_shortcut_parking);
                    if (jsonObj.getInt("parking") == 1)
                        parking.setImageResource(getResources().getIdentifier("ic_shortcut_parking", "drawable", getPackageName()));

                    ImageView playground = (ImageView) findViewById(R.id.ic_shortcut_playground);
                    if (jsonObj.getInt("playground") == 1)
                        playground.setImageResource(getResources().getIdentifier("ic_shortcut_playground", "drawable", getPackageName()));

                    ImageView pulling_up_training_silhouette = (ImageView) findViewById(R.id.ic_shortcut_pulling_up_training_silhouette);
                    if (jsonObj.getInt("pulling_up_training_silhouette") == 1)
                        pulling_up_training_silhouette.setImageResource(getResources().getIdentifier("ic_shortcut_pulling_up_training_silhouette", "drawable", getPackageName()));

                    ImageView roundabout = (ImageView) findViewById(R.id.ic_shortcut_roundabout);
                    if (jsonObj.getInt("roundabout") == 1)
                        roundabout.setImageResource(getResources().getIdentifier("ic_shortcut_roundabout", "drawable", getPackageName()));

                    ImageView toilet = (ImageView) findViewById(R.id.ic_shortcut_toilet);
                    if (jsonObj.getInt("toilet") == 1)
                        toilet.setImageResource(getResources().getIdentifier("ic_shortcut_toilet", "drawable", getPackageName()));

                    TextView p_name = (TextView) findViewById(R.id.name);
                    p_name.setText("이름 : "+jsonObj.getString("이름"));

                    TextView number = (TextView) findViewById(R.id.number);
                    number.setText("관리번호 : "+jsonObj.getString("관리번호"));

                    TextView part = (TextView) findViewById(R.id.part);
                    part.setText("구분 : "+jsonObj.getString("구분"));

                    TextView address = (TextView) findViewById(R.id.address);
                    address.setText("세부주소 : "+jsonObj.getString("세부주소"));

                    TextView road_address = (TextView) findViewById(R.id.road_address);
                    road_address.setText("도로명주소 : "+jsonObj.getString("도로명주소"));

                    TextView size = (TextView) findViewById(R.id.size);
                    size.setText("면적 : "+jsonObj.getString("면적")+"㎡");

                    TextView benefit = (TextView) findViewById(R.id.benefit);
                    benefit.setText("편익시설 : "+jsonObj.getString("편익시설"));

                    TextView exercise = (TextView) findViewById(R.id.exercise);
                    exercise.setText("운동시설 : "+jsonObj.getString("운동시설"));

                    TextView play = (TextView) findViewById(R.id.play);
                    play.setText("유희시설 : "+jsonObj.getString("유희시설"));

                    TextView refinement = (TextView) findViewById(R.id.refinement);
                    refinement.setText("교양시설 : "+jsonObj.getString("교양시설"));

                    TextView etc = (TextView) findViewById(R.id.etc);
                    etc.setText("기타시설 : "+jsonObj.getString("기타시설"));

                    TextView appoint = (TextView) findViewById(R.id.appoint);
                    appoint.setText("지정고시일 : "+jsonObj.getString("지정고시일"));

                    TextView management = (TextView) findViewById(R.id.management);
                    management.setText("관리기관명 : "+jsonObj.getString("관리기관명"));

                    TextView phoneNumber = (TextView) findViewById(R.id.phone_number);
                    phoneNumber.setText("연락처 : "+jsonObj.getString("연락처"));

                    TextView standart_date = (TextView) findViewById(R.id.standart_date);
                    standart_date.setText("데이터기준일자 : "+jsonObj.getString("데이터기준일자"));


                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void call(View view) {
        TextView phoneNumber = (TextView) findViewById(R.id.phone_number);
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber.getText().toString().substring(4, phoneNumber.getText().toString().length())));
        startActivity(intent);
    }

    @Override
    public void onMapReady(GoogleMap map) {
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

        Double Lat = null;
        Double Lng = null;
        try {
            JSONObject root = new JSONObject(result);
            JSONArray jsonArray = root.getJSONArray("results");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                if (jsonObj.getString("이름").equals(name)) {
                    Lat = jsonObj.getDouble("위도");
                    Lng = jsonObj.getDouble("경도");
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        LatLng park = new LatLng(Lat, Lng);
        map.addMarker(new MarkerOptions().position(park).title(name));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(park, 15));

    }
}


