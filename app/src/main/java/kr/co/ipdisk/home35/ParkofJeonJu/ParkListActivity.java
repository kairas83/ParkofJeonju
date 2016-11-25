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
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_chamseam, "참새암 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_daga, "다가 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_dukjin, "덕진 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_ecocity, "에코 시티");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_garyunsan, "가련산 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_gijize, "진지제 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_girin, "기린 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_guma, "구마 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_hwasan, "화산 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_jangsung, "장성 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_jongsan, "종산 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_mansungjigu, "만성지구");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_nosong, "노송 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_sunsuchon, "선수촌 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_taepyuong_culture_park, "태평문화 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_wansan, "완산 공원");
        arItem.add(mi);
        mi = new MyItem(kr.co.ipdisk.home35.ParkofJeonJu.R.drawable.parkImg_wolpyeong, "월평 공원");
        arItem.add(mi);


        MyListAdapter myListAdapter = new MyListAdapter(this, kr.co.ipdisk.home35.ParkofJeonJu.R.layout.list_content, arItem);

        ListView myList = (ListView) findViewById(kr.co.ipdisk.home35.ParkofJeonJu.R.id.list);
        myList.setAdapter(myListAdapter);
    }


}

