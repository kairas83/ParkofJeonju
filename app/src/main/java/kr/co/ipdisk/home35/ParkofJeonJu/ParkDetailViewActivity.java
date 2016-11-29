package kr.co.ipdisk.home35.ParkofJeonJu;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by LG on 2016-11-23.
 */

public class ParkDetailViewActivity extends AppCompatActivity {
    //TODO 공원이름을 받아서 해당공원의 상세뷰를 출력해주는 클래스 만들기

    Intent intent = getIntent();
    String name = intent.getExtras().getString("이름");
    

}


