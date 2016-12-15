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


    /*
       아이템 리스트를 어댑터를 사용해서
       엑티비티에 뿌려주는 기능을 한다.
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
        if (arSrc.get(position).image.equals(""))
            imgbtn.setImageResource(maincon.getResources().getIdentifier("parkimg_default", "drawable", maincon.getPackageName()));
        else
            imgbtn.setImageResource(maincon.getResources().getIdentifier(arSrc.get(position).image, "drawable", maincon.getPackageName()));


        ImageView bench = (ImageView) convertView.findViewById(R.id.ic_shortcut_bench);
        if (arSrc.get(position).bench == 1)
            bench.setImageResource(maincon.getResources().getIdentifier("ic_shortcut_bench", "drawable", maincon.getPackageName()));

        ImageView camera = (ImageView) convertView.findViewById(R.id.ic_shortcut_camera);
        if (arSrc.get(position).camera == 1)
            camera.setImageResource(maincon.getResources().getIdentifier("ic_shortcut_camera", "drawable", maincon.getPackageName()));

        ImageView parking = (ImageView) convertView.findViewById(R.id.ic_shortcut_parking);
        if (arSrc.get(position).parking == 1)
            parking.setImageResource(maincon.getResources().getIdentifier("ic_shortcut_parking", "drawable", maincon.getPackageName()));

        ImageView playground = (ImageView) convertView.findViewById(R.id.ic_shortcut_playground);
        if (arSrc.get(position).playground == 1)
            playground.setImageResource(maincon.getResources().getIdentifier("ic_shortcut_playground", "drawable", maincon.getPackageName()));

        ImageView pulling_up_training_silhouette = (ImageView) convertView.findViewById(R.id.ic_shortcut_pulling_up_training_silhouette);
        if (arSrc.get(position).pulling_up_training_silhouette == 1)
            pulling_up_training_silhouette.setImageResource(maincon.getResources().getIdentifier("ic_shortcut_pulling_up_training_silhouette", "drawable", maincon.getPackageName()));

        ImageView roundabout = (ImageView) convertView.findViewById(R.id.ic_shortcut_roundabout);
        if (arSrc.get(position).roundabout == 1)
            roundabout.setImageResource(maincon.getResources().getIdentifier("ic_shortcut_roundabout", "drawable", maincon.getPackageName()));

        ImageView toilet = (ImageView) convertView.findViewById(R.id.ic_shortcut_toilet);
        if (arSrc.get(position).toilet == 1)
            toilet.setImageResource(maincon.getResources().getIdentifier("ic_shortcut_toilet", "drawable", maincon.getPackageName()));

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
