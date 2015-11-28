package cjs.example.com.mytimeyourtime;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by cjs on 2015-11-12.
 */
public class EditSelDialog extends Dialog {

  private Button ttabBtn;
  private Button schdlBtn;

  private View.OnClickListener selTtabClickListener;
  private View.OnClickListener wrSchdlClickListener;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
    lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
    lpWindow.dimAmount = 0.8f;
    getWindow().setAttributes(lpWindow);

    setContentView(R.layout.edit_sel_dialog);

    setLayout();
    setClickListener(selTtabClickListener, wrSchdlClickListener);
  }

  public EditSelDialog(Context context) {
    super(context, android.R.style.Theme_Translucent_NoTitleBar);
  }

  public EditSelDialog(Context context, View.OnClickListener selTtabClickListener, View.OnClickListener wrSchdlClickListener ) {
    super(context, android.R.style.Theme_Translucent_NoTitleBar);
    this.selTtabClickListener = selTtabClickListener;
    this.wrSchdlClickListener = wrSchdlClickListener;
  }

  private void setClickListener(View.OnClickListener selTtabClickListener, View.OnClickListener wrSchdlClickListener) {
    ttabBtn.setOnClickListener(selTtabClickListener);
    schdlBtn.setOnClickListener(wrSchdlClickListener);
  }

  private void setLayout() {
    ttabBtn = (Button)findViewById(R.id.edit_sel_ttab_btn);
    schdlBtn = (Button)findViewById(R.id.edit_sel_schdl_btn);
  }

}
