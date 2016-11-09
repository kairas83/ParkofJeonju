package org.iptime.kairas.parkofjeonju;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ParkListActivity extends AppCompatActivity {
    ArrayList<MyItem> arItem;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parklist);
        setTitle("공원 목록");

        arItem = new ArrayList<MyItem>();
        MyItem mi;
        mi = new MyItem(R.drawable.chamseam_park, "참새암공원");
        arItem.add(mi);

        MyListAdapter myListAdapter = new MyListAdapter(this, R.layout.list_contentl, arItem);

        ListView myList = (ListView) findViewById(R.id.list);
        myList.setAdapter(myListAdapter);
    }


}

class MyItem {
    MyItem(int aimage, String aName) {
        image = aimage;
        name = aName;
    }
    int image;
    String name;
}