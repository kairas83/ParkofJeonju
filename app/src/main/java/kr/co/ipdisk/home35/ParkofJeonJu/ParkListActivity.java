package kr.co.ipdisk.home35.ParkofJeonJu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;

public class ParkListActivity extends AppCompatActivity {
    ArrayList<MyItem> arItem;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(kr.co.ipdisk.home35.ParkofJeonJu.R.layout.activity_parklist);
        setTitle("공원 목록");

        String test = "http://home35.ipdisk.co.kr/msd/SelectAllItem.php";
        URLConnector task = new URLConnector(test);

        task.start();

        try {
            task.join();
            System.out.println("waiting... for result");
        } catch (InterruptedException e) {

        } finally {
            String result = task.getResult();
            System.out.println(result); //TODO println대신 ParkListActivity에 출력 연결
        }


        arItem = new ArrayList<MyItem>();
        MyItem mi;
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.chamseam_park, "참새암 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.daga_park, "다가 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.dukjin_park, "덕진 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.ecocity, "에코 시티");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.garyunsan_park, "가련산 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.gijize, "진지제 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.girin_park, "기린 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.guma_park, "구마 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.hwasan_park, "화산 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.jangsung_park, "장성 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.jongsan_park, "종산 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.mansungjigu, "만성지구");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.nosong_park, "노송 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.sunsuchon_park, "선수촌 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.taepyuong_culture_park, "태평문화 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.wansan_park, "완산 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.wolpyeong_park, "월평 공원");
        arItem.add(mi);


        MyListAdapter myListAdapter = new MyListAdapter(this, kr.co.ipdisk.home35.ParkofJeonJu.R.layout.list_content, arItem);

        ListView myList = (ListView) findViewById(kr.co.ipdisk.home35.ParkofJeonJu.R.id.list);
        myList.setAdapter(myListAdapter);
    }


}

