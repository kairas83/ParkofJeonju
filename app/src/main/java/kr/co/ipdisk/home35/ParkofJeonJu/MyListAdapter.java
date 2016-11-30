package kr.co.ipdisk.home35.ParkofJeonJu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by kaira on 2016-11-09.
 */
public class MyListAdapter extends BaseAdapter {
    private Context maincon;
    private LayoutInflater Inflater;
    private ArrayList<MyItem> arSrc;
    int layout;

    public MyListAdapter(Context context, int alayout, ArrayList<MyItem> aarSrc) {
        maincon = context;
        Inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        arSrc = aarSrc;
        layout = alayout;

    }
    public int getCount() {
        return arSrc.size();
    }
    public String getItem(int position) {
        return arSrc.get(position).name;
    }
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = Inflater.inflate(layout, parent, false);
        }
        ImageButton imgbtn = (ImageButton) convertView.findViewById(R.id.imgbtn);
        imgbtn.setImageResource(arSrc.get(position).image);
/*
        ImageView bench = (ImageView) convertView.findViewById(R.id.ic_shortcut_bench);
        bench.setImageResource( arSrc.get(position).bench? getResources().getIdentifier("ic_shortcut_bench", "drawable", getPackageName()) : null);
        ImageView camera = (ImageView) convertView.findViewById(R.id.ic_shortcut_camera);
        camera.setImageResource( arSrc.get(position).camera? getResources().getIdentifier("ic_shortcut_camera", "drawable", getPackageName()) : null);
        ImageView parking = (ImageView) convertView.findViewById(R.id.ic_shortcut_parking);
        parking.setImageResource( arSrc.get(position).parking? getResources().getIdentifier("ic_shortcut_parking", "drawable", getPackageName()) : null);
        ImageView playground = (ImageView) convertView.findViewById(R.id.ic_shortcut_playground);
        playground.setImageResource( arSrc.get(position).playground? getResources().getIdentifier("ic_shortcut_playground", "drawable", getPackageName()) : null);
        ImageView pulling_up_training_silhouette = (ImageView) convertView.findViewById(R.id.ic_shortcut_pulling_up_training_silhouette);
        pulling_up_training_silhouette.setImageResource( arSrc.get(position).pulling_up_training_silhouette? getResources().getIdentifier("ic_shortcut_pulling_up_training_silhouette", "drawable", getPackageName()) : null);
        ImageView road_with_two_placeholders = (ImageView) convertView.findViewById(R.id.ic_shortcut_road_with_two_placeholders);
        road_with_two_placeholders.setImageResource( arSrc.get(position).road_with_two_placeholders? getResources().getIdentifier("ic_shortcut_road_with_two_placeholders", "drawable", getPackageName()) : null);
        ImageView roundabout = (ImageView) convertView.findViewById(R.id.ic_shortcut_roundabout);
        roundabout.setImageResource( arSrc.get(position).roundabout? getResources().getIdentifier("ic_shortcut_roundabout", "drawable", getPackageName()) : null);
        ImageView toilet = (ImageView) convertView.findViewById(R.id.ic_shortcut_toilet);
        toilet.setImageResource( arSrc.get(position).toilet? getResources().getIdentifier("ic_shortcut_toilet", "drawable", getPackageName()) : null);
*/
        TextView txt = (TextView) convertView.findViewById(R.id.title);
        txt.setText(arSrc.get(position).name);

        imgbtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String str = arSrc.get(position).name;

                Intent intent = new Intent(maincon, ParkDetailViewActivity.class);
                intent.putExtra("이름", str);
                maincon.startActivity(intent);
            }
        });
        return convertView;
    }
}
