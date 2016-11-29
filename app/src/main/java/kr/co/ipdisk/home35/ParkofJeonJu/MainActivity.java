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

        setTitle("전주공원");
/*

implements NavigationView.OnNavigationItemSelectedListener {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(kr.co.ipdisk.home35.ParkofJeonJu.R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(kr.co.ipdisk.home35.ParkofJeonJu.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, kr.co.ipdisk.home35.ParkofJeonJu.R.string.navigation_drawer_open, kr.co.ipdisk.home35.ParkofJeonJu.R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(kr.co.ipdisk.home35.ParkofJeonJu.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(kr.co.ipdisk.home35.ParkofJeonJu.R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(kr.co.ipdisk.home35.ParkofJeonJu.R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == kr.co.ipdisk.home35.ParkofJeonJu.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent intent;

        switch(id) {
            case R.id.park_list:
                intent = new Intent(getApplicationContext(), ParkListActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_gallery:
                intent = new Intent(getApplicationContext(), ParkListActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_slideshow:
                intent = new Intent(getApplicationContext(), ParkListActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_manage:
                intent = new Intent(getApplicationContext(), ParkListActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_share:
                intent = new Intent(getApplicationContext(), ParkListActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_send:
                intent = new Intent(getApplicationContext(), ParkListActivity.class);
                startActivity(intent);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(kr.co.ipdisk.home35.ParkofJeonJu.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
*/
    }
    public void allList(View view) {
        Intent intent;
        intent = new Intent(getApplicationContext(), ParkListActivity.class);
        startActivity(intent);
    }
}
