package org.iptime.kairas.parkofjeonju;

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
        try{
            Thread.sleep(8000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

}
