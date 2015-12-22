package cjs.example.com.mytimeyourtime;

import android.app.Activity;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cjs on 2015-11-27.
 */
public class WrSchdlActivity extends Activity implements View.OnClickListener{

  private WrongDialog wrongDialog;

  int start_hour, start_minute, end_hour, end_minute;
  String start_ampm, end_ampm, day;

  Spinner day_spin;
  Spinner start_hour_spin, start_minute_spin, start_ampm_spin;
  Spinner end_hour_spin, end_minute_spin, end_ampm_spin;

  EditText schdl_name;
  String name, color;

  static ArrayList<Integer> hour = new ArrayList<Integer>();
  static ArrayList<Integer> minute = new ArrayList<Integer>();
  static ArrayList<String> amNpm = new ArrayList<String>();
  static ArrayList<String> days = new ArrayList<String>();

  static {

    for(int i = 0; i < 12; i++) {
      hour.add(i + 1);
      minute.add(i * 5);
    }

    amNpm.add("am");
    amNpm.add("pm");

    days.add("월");
    days.add("화");
    days.add("수");
    days.add("목");
    days.add("금");

  }

    @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_wr_schdl);

    start_hour_spin = (Spinner)findViewById(R.id.wr_start_hour_spin);
    start_minute_spin = (Spinner)findViewById(R.id.wr_start_minute_spin);
    start_ampm_spin = (Spinner)findViewById(R.id.wr_start_ampm_spin);
    end_hour_spin = (Spinner)findViewById(R.id.wr_end_hour_spin);
    end_minute_spin = (Spinner)findViewById(R.id.wr_end_minute_spin);
    end_ampm_spin = (Spinner)findViewById(R.id.wr_end_ampm_spin);
    day_spin = (Spinner)findViewById(R.id.wr_day_spin);

    schdl_name = (EditText)findViewById(R.id.wr_schdl_name_edit);

    ArrayAdapter<Integer> hourAdapter= new ArrayAdapter<Integer>(this, R.layout.spinner_item, hour);
    hourAdapter.setDropDownViewResource(R.layout.spinner_item);

    ArrayAdapter<Integer> minuteAdapter= new ArrayAdapter<Integer>(this, R.layout.spinner_item, minute);
    minuteAdapter.setDropDownViewResource(R.layout.spinner_item);

    ArrayAdapter<String> amNpmAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, amNpm);
    amNpmAdapter.setDropDownViewResource(R.layout.spinner_item);

    ArrayAdapter<String> dayAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, days);
    dayAdapter.setDropDownViewResource(R.layout.spinner_item);

    start_hour_spin.setAdapter(hourAdapter);
    start_minute_spin.setAdapter(minuteAdapter);
    start_ampm_spin.setAdapter(amNpmAdapter);
    end_hour_spin.setAdapter(hourAdapter);
    end_minute_spin.setAdapter(minuteAdapter);
    end_ampm_spin.setAdapter(amNpmAdapter);
    day_spin.setAdapter(dayAdapter);

    day_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ((TextView)view).setTextColor(Color.parseColor("#3C09DA"));
        day = days.get(i);
      }

      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {}
    });

    start_hour_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ((TextView)view).setTextColor(Color.parseColor("#3C09DA"));
        start_hour = hour.get(i);
      }

      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {}
    });

    start_minute_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ((TextView)view).setTextColor(Color.parseColor("#3C09DA"));
        start_minute = minute.get(i);
      }

      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {}
    });

    start_ampm_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ((TextView)view).setTextColor(Color.parseColor("#3C09DA"));
        start_ampm = amNpm.get(i);
      }

      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {}
    });

    end_hour_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ((TextView)view).setTextColor(Color.parseColor("#3C09DA"));
        end_hour = hour.get(i);
      }

      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {}
    });

    end_minute_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ((TextView)view).setTextColor(Color.parseColor("#3C09DA"));
        end_minute = minute.get(i);
      }

      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {}
    });

    end_ampm_spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

      @Override
      public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        ((TextView)view).setTextColor(Color.parseColor("#3C09DA"));
        end_ampm = amNpm.get(i);
      }

      @Override
      public void onNothingSelected(AdapterView<?> adapterView) {}
    });

    Button wr_schdl_btn = (Button)findViewById(R.id.wr_schdl_btn);
    wr_schdl_btn.setOnClickListener(this);

    Button btn1 = (Button)findViewById(R.id.btn1);
    btn1.setOnClickListener(this);

    Button btn2 = (Button)findViewById(R.id.btn2);
    btn2.setOnClickListener(this);

    Button btn3 = (Button)findViewById(R.id.btn3);
    btn3.setOnClickListener(this);

    Button btn4 = (Button)findViewById(R.id.btn4);
    btn4.setOnClickListener(this);

    Button btn5 = (Button)findViewById(R.id.btn5);
    btn5.setOnClickListener(this);

    Button btn6 = (Button)findViewById(R.id.btn6);
    btn6.setOnClickListener(this);

    Button btn7 = (Button)findViewById(R.id.btn7);
    btn7.setOnClickListener(this);

    Button btn8 = (Button)findViewById(R.id.btn8);
    btn8.setOnClickListener(this);

    Button btn9 = (Button)findViewById(R.id.btn9);
    btn9.setOnClickListener(this);

    Button btn10 = (Button)findViewById(R.id.btn10);
    btn10.setOnClickListener(this);

    Button btn11 = (Button)findViewById(R.id.btn11);
    btn11.setOnClickListener(this);

    Button btn12 = (Button)findViewById(R.id.btn12);
    btn12.setOnClickListener(this);

    Button btn13 = (Button)findViewById(R.id.btn13);
    btn13.setOnClickListener(this);

    Button btn14 = (Button)findViewById(R.id.btn14);
    btn14.setOnClickListener(this);

    Button btn15 = (Button)findViewById(R.id.btn15);
    btn15.setOnClickListener(this);

    Button btn16 = (Button)findViewById(R.id.btn16);
    btn16.setOnClickListener(this);

    Button btn17 = (Button)findViewById(R.id.btn17);
    btn17.setOnClickListener(this);

    Button btn18 = (Button)findViewById(R.id.btn18);
    btn18.setOnClickListener(this);

    Button btn19 = (Button)findViewById(R.id.btn19);
    btn19.setOnClickListener(this);

    Button btn20 = (Button)findViewById(R.id.btn20);
    btn20.setOnClickListener(this);

  }

  @Override
  public void onClick(View v) {
    switch(v.getId()) {
      case R.id.wr_schdl_btn:
        if(schdl_name == null)
          createWrongDialog();
        name = schdl_name.getText().toString();
        insertSchedule(day, start_hour, start_minute, start_ampm,
                       end_hour, end_minute, end_ampm, name, color);
        break;
      case R.id.btn1:
        color = "#FB0867";
        break;
      case R.id.btn2:
        color = "#316670";
        break;
      case R.id.btn3:
        color = "#69F47D";
        break;
      case R.id.btn4:
        color = "#4BC834";
        break;
      case R.id.btn5:
        color = "#5F7FA8";
        break;
      case R.id.btn6:
        color = "#BFE218";
        break;
      case R.id.btn7:
        color = "#283BE0";
        break;
      case R.id.btn8:
        color = "#1F11A8";
        break;
      case R.id.btn9:
        color = "#E808AC";
        break;
      case R.id.btn10:
        color = "#CE0344";
        break;
      case R.id.btn11:
        color = "#871ED4";
        break;
      case R.id.btn12:
        color = "#F0779C";
        break;
      case R.id.btn13:
        color = "#49E176";
        break;
      case R.id.btn14:
        color = "#AA14E6";
        break;
      case R.id.btn15:
        color = "#D5AE98";
        break;
      case R.id.btn16:
        color = "#8FADF0";
        break;
      case R.id.btn17:
        color = "#9079B3";
        break;
      case R.id.btn18:
        color = "#BDFA66";
        break;
      case R.id.btn19:
        color = "#553923";
        break;
      case R.id.btn20:
        color = "#BF91EC";
        break;
    }
  }

  public void insertSchedule(String day, int start_hour, int start_minute, String start_ampm,
                 int end_hour, int end_minute, String end_ampm, String name, String color) {

    UserDBHandler uhandler = UserDBHandler.open(getApplicationContext());
    Cursor ucursor;

    int d = 0, sh = 0, sm = 0;
    int eh = 0, em = 0;
    int start_time = 0, end_time = 0;

    switch (day) {
      case "월":
        d = 0;
        break;
      case "화":
        d = 1;
        break;
      case "수":
        d = 2;
        break;
      case "목":
        d = 3;
        break;
      case "금":
        d = 4;
        break;
    }

    sm = start_minute/5 + 1;
    em = end_minute/5;

    if(start_ampm == "am") {

      if(start_hour < 7 || start_hour > 11)
        createWrongDialog();
      else {
        sh = start_hour - 7;
        start_time = 180*d + 12*sh + sm;
      }

    } else {

      if(start_hour >= 10 && start_hour < 12)
        createWrongDialog();
      else {
        if(start_hour == 12)
          sh = 5;
        else
          sh = start_hour + 5;
        start_time = 180*d + 12*sh + sm;
      }

    }

    if(end_ampm == "am") {

      if(end_hour < 7 || end_hour > 11)
        createWrongDialog();
      else {
        eh = end_hour - 7;
        end_time = 180*d + 12*eh + em;
      }

    } else {

      if(end_hour == 11)
        createWrongDialog();
      else if(end_hour == 10 && end_minute != 0)
        createWrongDialog();
      else {
        if(end_hour == 12)
          eh = 5;
        else
          eh = end_hour + 5;
        end_time = 180*d + 12*eh + em;
      }

    }

    if(start_time > end_time)
      createWrongDialog();

    ucursor = uhandler.selectByTime(Integer.toString(start_time), Integer.toString(start_time));

    if(ucursor.getCount() > 0)
      createWrongDialog();
    else {
      uhandler.insert(100, start_time, end_time, name, color);
      uhandler.selectAll();
      setResult(1);
      finish();
    }

  }

  private void createWrongDialog() {
    final View innerView = getLayoutInflater().inflate(R.layout.wrong_dialog, null);

    wrongDialog = new WrongDialog(this);
    wrongDialog.show();
  }

}