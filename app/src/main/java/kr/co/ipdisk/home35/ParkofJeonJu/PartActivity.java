package kr.co.ipdisk.home35.ParkofJeonJu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by kaira on 2016-11-30.
 */

    /*
       분류별 공원 리스트를 보기 위한 엑티비티
        완산구와 덕진구를 나누어 두고 그 버튼을 눌렀을 경우 다음 엑티비티로 넘어가게 구현.
     */

public class PartActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part);
    }

    // 덕진구를 눌렀을 경우 , 온클릭 기능을 수행한다
    public void dukjingoo(View view) {
        Intent intent;
        intent = new Intent(getApplicationContext(), PartListView.class);
        intent.putExtra("part", "덕진구");
        startActivity(intent);
    }

    // 완산구를 눌렀을 경우 , 온클릭 기능을 수행한다
    public void wansangoo(View view) {
        Intent intent;
        intent = new Intent(getApplicationContext(), PartListView.class);
        intent.putExtra("part", "완산구");
        startActivity(intent);
    }
}
