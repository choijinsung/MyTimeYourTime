package cjs.example.com.mytimeyourtime;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cjs on 2015-11-27.
 */
public class WrSchdlActivity extends Activity implements AdapterView.OnItemSelectedListener,
                                                         View.OnClickListener {

  Spinner start_hour_spin, start_minute_spin, start_ampm_spin;
  Spinner end_hour_spin, end_minute_spin, end_ampm_spin;

  static ArrayList<Integer> hour = new ArrayList<Integer>();
  static ArrayList<Integer> minute = new ArrayList<Integer>();
  static ArrayList<String> amNpm = new ArrayList<String>();

  static {

    for(int i = 0; i < 12; i++) {
      hour.add(i + 1);
      minute.add(i * 5);
    }

    amNpm.add("am");
    amNpm.add("pm");

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

    ArrayAdapter<Integer> hourAdapter= new ArrayAdapter<Integer>(this, R.layout.spinner_item, hour);
    hourAdapter.setDropDownViewResource(R.layout.spinner_item);

    ArrayAdapter<Integer> minuteAdapter= new ArrayAdapter<Integer>(this, R.layout.spinner_item, minute);
    minuteAdapter.setDropDownViewResource(R.layout.spinner_item);

    ArrayAdapter<String> amNpmAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, amNpm);
    amNpmAdapter.setDropDownViewResource(R.layout.spinner_item);

    start_hour_spin.setAdapter(hourAdapter);
    start_minute_spin.setAdapter(minuteAdapter);
    start_ampm_spin.setAdapter(amNpmAdapter);
    end_hour_spin.setAdapter(hourAdapter);
    end_minute_spin.setAdapter(minuteAdapter);
    end_ampm_spin.setAdapter(amNpmAdapter);

    start_hour_spin.setOnItemSelectedListener(this);
    start_minute_spin.setOnItemSelectedListener(this);
    start_ampm_spin.setOnItemSelectedListener(this);
    end_hour_spin.setOnItemSelectedListener(this);
    end_minute_spin.setOnItemSelectedListener(this);
    end_ampm_spin.setOnItemSelectedListener(this);

    Button wr_schdl_btn = (Button)findViewById(R.id.wr_schdl_btn);
    wr_schdl_btn.setOnClickListener(this);

    }

  public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
    ((TextView)parent.getChildAt(0)).setTextColor(Color.parseColor("#3C09DA"));
  }

  @Override
  public void onNothingSelected(AdapterView<?> parent) {
  }

  @Override
  public void onClick(View v) {
    if(v.getId() == R.id.wr_schdl_btn) {
      setResult(1);
      finish();
    }
  }


}