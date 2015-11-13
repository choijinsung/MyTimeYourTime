package cjs.example.com.mytimeyourtime;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends Activity implements OnClickListener {

  ListView mainTimeListView;
  GridView mainTimeGridView;

  private EditSelDialog editSelDialog;
  private DelSelDialog delSelDialog;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_main);

    Button main_edit_btn = (Button)findViewById(R.id.main_edit_btn);
    main_edit_btn.setOnClickListener(this);

    Button main_del_btn = (Button)findViewById(R.id.main_del_btn);
    main_del_btn.setOnClickListener(this);

    ArrayList<MainTimeDTO> mainTimeList = new ArrayList<MainTimeDTO>();

    mainTimeList.add(new MainTimeDTO(""));
    mainTimeList.add(new MainTimeDTO("7~8"));
    mainTimeList.add(new MainTimeDTO("8~9"));
    mainTimeList.add(new MainTimeDTO("9~10"));
    mainTimeList.add(new MainTimeDTO("10~11"));
    mainTimeList.add(new MainTimeDTO("11~12"));
    mainTimeList.add(new MainTimeDTO("12~13"));
    mainTimeList.add(new MainTimeDTO("13~14"));
    mainTimeList.add(new MainTimeDTO("14~15"));
    mainTimeList.add(new MainTimeDTO("15~16"));
    mainTimeList.add(new MainTimeDTO("16~17"));
    mainTimeList.add(new MainTimeDTO("17~18"));
    mainTimeList.add(new MainTimeDTO("18~19"));
    mainTimeList.add(new MainTimeDTO("19~20"));
    mainTimeList.add(new MainTimeDTO("20~21"));
    mainTimeList.add(new MainTimeDTO("21~22"));

    mainTimeListView = (ListView)findViewById(R.id.main_time_listview);
    mainTimeListView.setDivider(null);

    MainTimeAdapter mainTimeAdapter = new MainTimeAdapter(getApplicationContext(), R.layout.main_time_list_row, mainTimeList);

    mainTimeListView.setAdapter(mainTimeAdapter);

    ArrayList<MainTimeGridDTO> mainTimeGrid = new ArrayList<MainTimeGridDTO>();

    for(int i=0; i<900; i++)
      mainTimeGrid.add(new MainTimeGridDTO());

    mainTimeGridView = (GridView)findViewById(R.id.main_time_gridview);

    MainTimeGridAdapter mainTimeGridAdapter = new MainTimeGridAdapter(getApplicationContext(), R.layout.main_time_grid_content, mainTimeGrid);

    mainTimeGridView.setAdapter(mainTimeGridAdapter);

    startActivity(new Intent(this, SplashActivity.class));
  }

  public void onClick(View v) {
    switch(v.getId()) {

      case R.id.main_edit_btn:
        createEditDialog();
        break;

      case R.id.main_del_btn:
        createDelDialog();
        break;

      default:
        break;
    }
  }

  private OnClickListener selTtabClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      Toast.makeText(MainActivity.this, "111", Toast.LENGTH_SHORT).show();
    }
  };

  private OnClickListener selSchdlClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      Toast.makeText(MainActivity.this, "222", Toast.LENGTH_SHORT).show();
    }
  };

  private void createEditDialog() {
    final View innerView = getLayoutInflater().inflate(R.layout.edit_sel_dialog, null);

    editSelDialog = new EditSelDialog(this, selTtabClickListener, selSchdlClickListener);
    editSelDialog.show();
  }

  private OnClickListener delTtabClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      Toast.makeText(MainActivity.this, "333", Toast.LENGTH_SHORT).show();
    }
  };

  private OnClickListener delSchdlClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      Toast.makeText(MainActivity.this, "444", Toast.LENGTH_SHORT).show();
    }
  };

  private OnClickListener delEntireTtabClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      Toast.makeText(MainActivity.this, "555", Toast.LENGTH_SHORT).show();
    }
  };

  private OnClickListener delEntireSchdlClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      Toast.makeText(MainActivity.this, "666", Toast.LENGTH_SHORT).show();
    }
  };

  private OnClickListener delEntireClickListener = new OnClickListener() {
    @Override
    public void onClick(View v) {
      Toast.makeText(MainActivity.this, "777", Toast.LENGTH_SHORT).show();
    }
  };

  private void createDelDialog() {
    final View innerView = getLayoutInflater().inflate(R.layout.del_sel_dialog, null);

    delSelDialog = new DelSelDialog(this, delTtabClickListener, delSchdlClickListener
    , delEntireTtabClickListener, delEntireSchdlClickListener, delEntireClickListener);
    delSelDialog.show();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
