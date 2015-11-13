package cjs.example.com.mytimeyourtime;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.Window;
import android.os.Handler;

/**
 * Created by cjs on 2015-11-08.
 */
public class SplashActivity extends Activity {

  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_splash);

    Handler handler = new Handler() {

      public void handleMessage(Message msg) {
        finish();
      }
    };

    handler.sendEmptyMessageDelayed(0, 3000);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

}

