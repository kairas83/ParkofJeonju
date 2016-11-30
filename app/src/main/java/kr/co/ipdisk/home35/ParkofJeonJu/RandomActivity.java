package kr.co.ipdisk.home35.ParkofJeonJu;

import android.app.Activity;
import android.os.Bundle;

import java.util.Random;

/**
 * Created by J2NN on 2016-11-30.
 */

public class RandomActivity extends Activity {

    Random mRand;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        mRand = new Random();

    }
}
