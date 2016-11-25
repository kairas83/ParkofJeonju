package kr.co.ipdisk.home35.ParkofJeonJu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by LG on 2016-11-23.
 */

public class SplashActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        //TODO splash.jpg 이미지 제대로 표시되게 하기
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
