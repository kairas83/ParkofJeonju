package kr.co.ipdisk.home35.ParkofJeonJu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void allList(View view) {
        Intent intent;
        intent = new Intent(getApplicationContext(), ParkListActivity.class);
        startActivity(intent);
    }

    public void part(View view) {
        Intent intent;
        intent = new Intent(getApplicationContext(), PartActivity.class);
        startActivity(intent);
    }

    public void nearest(View view) {
        Intent intent;
        intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);
    }

    public void random(View view) {
        Intent intent;
        intent = new Intent(getApplicationContext(), RandomActivity.class);
        startActivity(intent);
    }
}