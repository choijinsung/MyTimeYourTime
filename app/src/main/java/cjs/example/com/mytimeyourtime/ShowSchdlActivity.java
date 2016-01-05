package cjs.example.com.mytimeyourtime;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cjs on 2016-01-05.
 */
public class ShowSchdlActivity extends Activity implements View.OnClickListener {

  private String[] testStringArray;
  private ListView scheduleListView;
  CourseDBHandler handler;
  UserDBHandler uhandler;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_show_schdl);

    Button del_schdl_btn = (Button)findViewById(R.id.del_schdl_btn);
    del_schdl_btn.setOnClickListener(this);

    testStringArray = new String[]{ "독서\n월요일 9:00 am ~ 10:00 am",
                                       "운동\n수요일 1:00 pm ~ 2:00 pm",
                                       "공부\n목요일 3:00 pm ~ 6:00 pm",
                                       "독서\n월요일 9:00 am ~ 10:00 am",
                                       "운동\n수요일 1:00 pm ~ 2:00 pm",
                                       "공부\n목요일 3:00 pm ~ 6:00 pm",
                                       "독서\n월요일 9:00 am ~ 10:00 am",
                                       "운동\n수요일 1:00 pm ~ 2:00 pm",
                                       "공부\n목요일 3:00 pm ~ 6:00 pm",
                                       "독서\n월요일 9:00 am ~ 10:00 am",
                                       "운동\n수요일 1:00 pm ~ 2:00 pm",
                                       "공부\n목요일 3:00 pm ~ 6:00 pm",
                                       "독서\n월요일 9:00 am ~ 10:00 am",
                                       "운동\n수요일 1:00 pm ~ 2:00 pm",
                                       "공부\n목요일 3:00 pm ~ 6:00 pm",
                                       "독서\n월요일 9:00 am ~ 10:00 am",
                                       "운동\n수요일 1:00 pm ~ 2:00 pm",
                                       "공부\n목요일 3:00 pm ~ 6:00 pm",
                                       "독서\n월요일 9:00 am ~ 10:00 am",
                                       "운동\n수요일 1:00 pm ~ 2:00 pm",
                                       "공부\n목요일 3:00 pm ~ 6:00 pm",
                                       "독서\n월요일 9:00 am ~ 10:00 am",
                                       "운동\n수요일 1:00 pm ~ 2:00 pm",
                                       "공부\n목요일 3:00 pm ~ 6:00 pm",
                                       "독서\n월요일 9:00 am ~ 10:00 am",
                                       "운동\n수요일 1:00 pm ~ 2:00 pm",
                                       "공부\n목요일 3:00 pm ~ 6:00 pm"};

    scheduleListView = (ListView) findViewById(R.id.schedule_listview);
    TestAdapter ta = new TestAdapter(this, 0, testStringArray);
    scheduleListView.setAdapter(ta);
    scheduleListView.setDivider(null);

  }

  private class TestAdapter extends ArrayAdapter<String> {

    private ArrayList<Integer> listItem;

    public TestAdapter(Context context, int textViewResourceId, String[] items) {

      super(context, textViewResourceId, items);
      listItem = new ArrayList<Integer>();

    }

    public int getCount() { return testStringArray.length; }

    public View getView(int position, View convertView, ViewGroup parent) {

      final int checkBoxPosition = position;
      View v = convertView;

      if(v == null) {

        LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = vi.inflate(R.layout.timetable_list_row, null);

      }

      String str = testStringArray[position];

      if(str != null) {

        TextView text = (TextView)v.findViewById(R.id.timetable_list_txt);
        if(text != null)
          text.setText(str);

        final CheckBox cb = (CheckBox)v.findViewById(R.id.timetable_list_cb);

        if(cb != null) {

          cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

              if (b) {

                for (int i = 0; i < listItem.size(); i++)
                  if (listItem.get(i) == checkBoxPosition)
                    return;

                listItem.add(checkBoxPosition);

              } else {

                for (int i = 0; i < listItem.size(); i++) {
                  if (listItem.get(i) == checkBoxPosition) {
                    listItem.remove(i);
                    break;

                  }
                }

              }

            }
          });

          boolean isChecked = false;

          for(int i = 0; i < listItem.size(); i++) {
            if(listItem.get(i) == checkBoxPosition) {
              cb.setChecked(true);
              isChecked = true;
              break;
            }
          }

          if(!isChecked)
            cb.setChecked(false);

        }
      }

      return v;
    }
  }

  public void onClick(View v) {
    if(v.getId() == R.id.del_schdl_btn){
      setResult(1);
      finish();
    }
  }

}
