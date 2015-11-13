package cjs.example.com.mytimeyourtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cjs on 2015-11-10.
 */
public class MainTimeAdapter extends BaseAdapter {

  Context ctx;
  int layout;
  ArrayList<MainTimeDTO> list;
  LayoutInflater inf;

  public MainTimeAdapter(Context ctx, int layout, ArrayList<MainTimeDTO> list) {
    this.ctx = ctx;
    this.layout = layout;
    this.list = list;

    inf = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
  }

  @Override
  public int getCount() { return list.size(); }

  @Override
  public Object getItem(int position) { return list.get(position); }

  @Override
  public long getItemId(int position) { return position; }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {

    if(convertView == null) { convertView = inf.inflate(layout, null); }

    TextView mainTimeTxt = (TextView)convertView.findViewById(R.id.main_time_txt);

    MainTimeDTO dto = list.get(position);

    mainTimeTxt.setText(dto.getTxt());

    return convertView;
  }
}
