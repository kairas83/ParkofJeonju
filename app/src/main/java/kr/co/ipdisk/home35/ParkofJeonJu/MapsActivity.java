package kr.co.ipdisk.home35.ParkofJeonJu;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    // GPSTracker class
    //private GpsInfo gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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

        String[] name = {};
        Double[] Lat = {};
        Double[] Lng = {};
        try {
            JSONObject root = new JSONObject(result);
            JSONArray jsonArray = root.getJSONArray("results");

            name = new String[jsonArray.length()];
            Lat = new Double[jsonArray.length()];
            Lng = new Double[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i);

                name[i] = jsonObj.getString("이름");
                Lat[i] = jsonObj.getDouble("위도");
                Lng[i] = jsonObj.getDouble("경도");

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        double latitude = 35.8241932;
        double longitude = 127.1480005;
/*        gps = new GpsInfo(this);
        // GPS 사용유무 가져오기
        if (gps.isGetLocation()) {

            latitude = gps.getLatitude();
            longitude = gps.getLongitude();


        } else {
            // GPS 를 사용할수 없으므로
            gps.showSettingsAlert();
        }

*/
        for (int i = 0; i < name.length; i++) {
            LatLng park = new LatLng(Lat[i], Lng[i]);
            map.addMarker(new MarkerOptions().position(park).title(name[i]));
        }
        LatLng here = new LatLng(latitude, longitude);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(here, 14));


    }
}