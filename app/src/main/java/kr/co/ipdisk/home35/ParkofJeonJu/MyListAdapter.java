package kr.co.ipdisk.home35.ParkofJeonJu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
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

        TextView txt = (TextView) convertView.findViewById(R.id.title);
        txt.setText(arSrc.get(position).name);

        imgbtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                String str = arSrc.get(position).name + "공원을 호출합니다.";
                Toast.makeText(maincon, str, Toast.LENGTH_SHORT).show();

                //TODO 토스트 대신 ParkDetailViewActivity 호출하기 extras로 name 넘겨주기
            }
        });
        return convertView;
    }
}
