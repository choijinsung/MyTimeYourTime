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
public class DelEntireTtabDialog extends Dialog {

  private Button deleteBtn;
  private Button cancelBtn;

  private View.OnClickListener deleteEntireTtabClickListener;
  private View.OnClickListener cancelEntireTtabClickListener;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
    lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
    lpWindow.dimAmount = 0.8f;
    getWindow().setAttributes(lpWindow);

    setContentView(R.layout.del_entire_ttab_dialog);

    setLayout();
    setClickListener(deleteEntireTtabClickListener, cancelEntireTtabClickListener);
  }

  public DelEntireTtabDialog(Context context) {
    super(context, android.R.style.Theme_Translucent_NoTitleBar);
  }

  public DelEntireTtabDialog(Context context, View.OnClickListener deleteEntireTtabClickListener, View.OnClickListener cancelEntireTtabClickListener) {
    super(context, android.R.style.Theme_Translucent_NoTitleBar);
    this.deleteEntireTtabClickListener = deleteEntireTtabClickListener;
    this.cancelEntireTtabClickListener = cancelEntireTtabClickListener;
  }

  private void setClickListener(View.OnClickListener deleteEntireTtabClickListener, View.OnClickListener cancelEntireTtabClickListener) {
    deleteBtn.setOnClickListener(deleteEntireTtabClickListener);
    cancelBtn.setOnClickListener(cancelEntireTtabClickListener);
  }

  private void setLayout() {
    deleteBtn = (Button)findViewById(R.id.delete_btn);
    cancelBtn = (Button)findViewById(R.id.cancel_btn);
  }

}
