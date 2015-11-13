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
public class DelSelDialog extends Dialog {

  private Button ttabBtn;
  private Button schdlBtn;
  private Button ttabEntireBtn;
  private Button schdlEntireBtn;
  private Button entireBtn;

  private View.OnClickListener delTtabClickListener;
  private View.OnClickListener delSchdlClickListener;
  private View.OnClickListener delEntireTtabClickListener;
  private View.OnClickListener delEntireSchdlClickListener;
  private View.OnClickListener delEntireClickListener;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
    lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
    lpWindow.dimAmount = 0.8f;
    getWindow().setAttributes(lpWindow);

    setContentView(R.layout.del_sel_dialog);

    setLayout();
    setClickListener(delTtabClickListener, delSchdlClickListener, delEntireTtabClickListener, delEntireSchdlClickListener, delEntireClickListener);
  }

  public DelSelDialog(Context context) {
    super(context, android.R.style.Theme_Translucent_NoTitleBar);
  }

  public DelSelDialog(Context context, View.OnClickListener delTtabClickListener, View.OnClickListener delSchdlClickListener,
                      View.OnClickListener delEntireTtabClickListener, View.OnClickListener delEntireSchdlClickListener, View.OnClickListener delEntireClickListener) {
    super(context, android.R.style.Theme_Translucent_NoTitleBar);
    this.delTtabClickListener = delTtabClickListener;
    this.delSchdlClickListener = delSchdlClickListener;
    this.delEntireTtabClickListener = delEntireTtabClickListener;
    this.delEntireSchdlClickListener = delEntireSchdlClickListener;
    this.delEntireClickListener = delEntireClickListener;
  }

  private void setClickListener(View.OnClickListener delTtabClickListener, View.OnClickListener delSchdlClickListener, View.OnClickListener delEntireTtabClickListener,
                                View.OnClickListener delEntireSchdlClickListener, View.OnClickListener delEntireClickListener) {
    ttabBtn.setOnClickListener(delTtabClickListener);
    schdlBtn.setOnClickListener(delSchdlClickListener);
    ttabEntireBtn.setOnClickListener(delEntireTtabClickListener);
    schdlEntireBtn.setOnClickListener(delEntireSchdlClickListener);
    entireBtn.setOnClickListener(delEntireClickListener);
  }

  private void setLayout() {
    ttabBtn = (Button)findViewById(R.id.del_sel_ttab_btn);
    schdlBtn = (Button)findViewById(R.id.del_sel_schdl_btn);
    ttabEntireBtn = (Button)findViewById(R.id.del_sel_entire_ttab_btn);
    schdlEntireBtn = (Button)findViewById(R.id.del_sel_entire_schdl_btn);
    entireBtn = (Button)findViewById(R.id.del_sel_entire_btn);
  }

}
