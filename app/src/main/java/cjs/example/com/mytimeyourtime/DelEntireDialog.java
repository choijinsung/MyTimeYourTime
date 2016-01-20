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
public class DelEntireDialog extends Dialog {

  private Button deleteBtn;
  private Button cancelBtn;

  private View.OnClickListener deleteEntireClickListener;
  private View.OnClickListener cancelEntireClickListener;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    WindowManager.LayoutParams lpWindow = new WindowManager.LayoutParams();
    lpWindow.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
    lpWindow.dimAmount = 0.8f;
    getWindow().setAttributes(lpWindow);

    setContentView(R.layout.del_entire_dialog);

    setLayout();
    setClickListener(deleteEntireClickListener, cancelEntireClickListener);
  }

  public DelEntireDialog(Context context) {
    super(context, android.R.style.Theme_Translucent_NoTitleBar);
  }

  public DelEntireDialog(Context context, View.OnClickListener deleteEntireClickListener, View.OnClickListener cancelEntireClickListener) {
    super(context, android.R.style.Theme_Translucent_NoTitleBar);
    this.deleteEntireClickListener = deleteEntireClickListener;
    this.cancelEntireClickListener = cancelEntireClickListener;
  }

  private void setClickListener(View.OnClickListener deleteEntireClickListener, View.OnClickListener cancelEntireClickListener) {
    deleteBtn.setOnClickListener(deleteEntireClickListener);
    cancelBtn.setOnClickListener(cancelEntireClickListener);
  }

  private void setLayout() {
    deleteBtn = (Button)findViewById(R.id.delete_btn);
    cancelBtn = (Button)findViewById(R.id.cancel_btn);
  }

}
