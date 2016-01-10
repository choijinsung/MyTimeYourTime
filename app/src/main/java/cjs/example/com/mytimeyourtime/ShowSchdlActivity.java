package cjs.example.com.mytimeyourtime;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
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
  UserDBHandler uhandler;
  Cursor ucursor;
  int index;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_show_schdl);

    Button del_schdl_btn = (Button)findViewById(R.id.del_schdl_btn);
    del_schdl_btn.setOnClickListener(this);

    uhandler = UserDBHandler.open(getApplicationContext());
    ucursor = uhandler.selectByCode("100");

    testStringArray = new String[ucursor.getCount()];
    index = 0;

    if(ucursor != null && ucursor.getCount() != 0) {
      ucursor.moveToFirst();

      do {
        String day = "";
        int startHour = 0, endHour = 0;
        int startMinVal = 0, endMinVal = 0;
        String startMin = "", endMin = "";
        String startAMPM = "", endAMPM = "";

        int startMod = ucursor.getInt(2)%180;
        int endMod = ucursor.getInt(3)%180;

        switch((ucursor.getInt(2)-1)/180) {
          case 0:
            day = "월";
            break;
          case 1:
            day = "화";
            break;
          case 2:
            day = "수";
            break;
          case 3:
            day = "목";
            break;
          case 4:
            day = "금";
            break;
        }

        startHour = (startMod - 1) / 12 + 7;

        if(startHour < 12)
          startAMPM = " am";
        else
          startAMPM = " pm";

        if(startHour > 12)
          startHour %= 12;

        startMinVal = (startMod - 1) % 12 * 5;

        if(startMinVal < 10)
          startMin = "0" + Integer.toString(startMinVal);
        else
          startMin = Integer.toString(startMinVal);

        endHour = (endMod - 1) / 12 + 7;

        if(endHour < 12)
          endAMPM = " am";
        else
          endAMPM = " pm";

        if(endHour > 12)
          endHour %= 12;

        endMinVal = endMod%12 * 5;

        if(endMinVal < 10)
          endMin = "0" + Integer.toString(endMinVal);
        else
          endMin = Integer.toString(endMinVal);

        String schdlStr = ucursor.getString(4) + "\n" + day + "요일 " + startHour + ":"
            + startMin + startAMPM + " ~ " + endHour + ":" + endMin + endAMPM;

        testStringArray[index++] = schdlStr;
      } while (ucursor.moveToNext());
    }

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
