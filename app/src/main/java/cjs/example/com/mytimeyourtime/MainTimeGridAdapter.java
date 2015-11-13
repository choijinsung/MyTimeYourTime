package cjs.example.com.mytimeyourtime;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by cjs on 2015-11-12.
 */
public class MainTimeGridAdapter extends BaseAdapter {

  Context ctx;
  int layout;
  ArrayList<MainTimeGridDTO> list;
  LayoutInflater inf;

  public MainTimeGridAdapter(Context ctx, int layout, ArrayList<MainTimeGridDTO> list) {
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

    final int pos = position;
    final Context context = parent.getContext();

    if(convertView == null) { convertView = inf.inflate(layout, null); }

    MainTimeGridDTO dto = list.get(position);

    return convertView;
  }

}
