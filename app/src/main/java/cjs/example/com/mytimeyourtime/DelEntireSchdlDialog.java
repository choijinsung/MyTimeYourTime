package cjs.example.com.mytimeyourtime;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by cjs on 2016-01-19.
 */
public class DelEntireSchdlDialog extends Dialog {

  private Button deleteBtn;
  private Button cancelBtn;

  private View.OnClickListener deleteEntireSchdlClickListener;
  private View.OnClickListener cancelEntireSchdlClickListener;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
    lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
    lpWindow.dimAmount = 0.8f;
    getWindow().setAttributes(lpWindow);

    setContentView(R.layout.del_entire_schdl_dialog);

    setLayout();
    setClickListener(deleteEntireSchdlClickListener, cancelEntireSchdlClickListener);
  }

  public DelEntireSchdlDialog(Context context) {
    super(context, android.R.style.Theme_Translucent_NoTitleBar);
  }

  public DelEntireSchdlDialog(Context context, View.OnClickListener deleteEntireSchdlClickListener, View.OnClickListener cancelEntireSchdlClickListener) {
    super(context, android.R.style.Theme_Translucent_NoTitleBar);
    this.deleteEntireSchdlClickListener = deleteEntireSchdlClickListener;
    this.cancelEntireSchdlClickListener = cancelEntireSchdlClickListener;
  }

  private void setClickListener(View.OnClickListener deleteEntireSchdlClickListener, View.OnClickListener cancelEntireSchdlClickListener) {
    deleteBtn.setOnClickListener(deleteEntireSchdlClickListener);
    cancelBtn.setOnClickListener(cancelEntireSchdlClickListener);
  }

  private void setLayout() {
    deleteBtn = (Button)findViewById(R.id.delete_btn);
    cancelBtn = (Button)findViewById(R.id.cancel_btn);
  }

}
