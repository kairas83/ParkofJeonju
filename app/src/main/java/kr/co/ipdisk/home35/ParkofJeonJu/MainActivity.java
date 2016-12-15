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

    /*
       공원 전체 리스트를 보기 위한 메소드
       Intent 를 사용해서 다음 Activity로 넘어간다.
     */
    public void allList(View view) {
        Intent intent;
        intent = new Intent(getApplicationContext(), ParkListActivity.class);
        startActivity(intent);
    }
    /*
       분류별 공원 리스트를 보기 위한 메소드
       Intent 를 사용해서 다음 Activity로 넘어간다.
     */
    public void part(View view) {
        Intent intent;
        intent = new Intent(getApplicationContext(), PartActivity.class);
        startActivity(intent);
    }

        /*
       가장 가까운 공원을 보기 위한 메소드
       Intent 를 사용해서 다음 Activity로 넘어간다.
     */

    public void nearest(View view) {
        Intent intent;
        intent = new Intent(getApplicationContext(), MapsActivity.class);
        startActivity(intent);
    }

    /*
    오늘의 추천 공원을 보기 위한 메소드
   Intent 를 사용해서 다음 Activity로 넘어간다.
 */
    public void random(View view) {
        Intent intent;
        intent = new Intent(getApplicationContext(), RandomActivity.class);
        startActivity(intent);
    }
}