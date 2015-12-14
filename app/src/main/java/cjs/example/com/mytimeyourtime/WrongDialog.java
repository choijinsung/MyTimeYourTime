package cjs.example.com.mytimeyourtime;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * Created by cjs on 2015-12-14.
 */
public class WrongDialog extends Dialog {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
    lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
    lpWindow.dimAmount = 0.8f;
    getWindow().setAttributes(lpWindow);

    setContentView(R.layout.wrong_dialog);

    setLayout();
  }

  public WrongDialog(Context context) {
    super(context, android.R.style.Theme_Translucent_NoTitleBar);
  }

  private void setLayout() {}

}
