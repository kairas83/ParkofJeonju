package kr.co.ipdisk.home35.ParkofJeonJu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by kaira on 2016-11-30.
 */

public class PartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part);
    }

    public void dukjingoo(View view) {
        Intent intent;
        intent = new Intent(getApplicationContext(), PartDetailViewActivity.class);
        intent.putExtra("part", "덕진구");
        startActivity(intent);
    }

    public void wansangoo(View view) {
        Intent intent;
        intent = new Intent(getApplicationContext(), PartDetailViewActivity.class);
        intent.putExtra("part", "완산구");
        startActivity(intent);
    }
}
