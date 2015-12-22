package cjs.example.com.mytimeyourtime;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cjs on 2015-11-20.
 */
public class SelTtabActivity extends Activity implements View.OnClickListener {

  private String[] testStringArray;
  private ListView timeTableListView;
  CourseDBHandler handler;
  UserDBHandler uhandler;
  private TimeConfDialog timeConfDialog;
  private String[] courseName;
  private String[] courseColor;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_sel_ttab);

    Button sel_ttab_btn = (Button)findViewById(R.id.sel_ttab_btn);
    sel_ttab_btn.setOnClickListener(this);

    testStringArray = new String[]{"English Reading Ⅰ\n월E, 수A / 김혜정",
                                      "English Reading Ⅰ\n월E, 수A / 유도형",
                                      "선형대수\n월B, 금C / 변정현",
                                      "선형대수\n월C, 금B / 변정현",
                                      "객체지향프로그래밍\n월2,3, 화2,3 / 김영만",
                                      "객체지향프로그래밍\n월2,3, 수4,5 / 한재일",
                                      "객체지향프로그래밍\n월5,6, 수6,7 / 한재일",
                                      "객체지향프로그래밍\n월9,10, 수8,9 / 한재일",
                                      "객체지향프로그래밍\n화2,3, 목2,3 / 윤성혜",
                                      "공학수학\n수B, 금F / 이경화",
                                      "공학수학\n수B, 금F / 조규동",
                                      "공학설계입문\n화D, 목E / 한광수",
                                      "공학설계입문\n화E, 목D / 한광수",
                                      "공학설계입문\n화D, 목E / 이상환",
                                      "공학설계입문\n화E, 목D / 신선호",
                                      "인생설계와진로\n목2,3 / 배용관",
                                      "인생설계와진로\n목2,3 / 이현기",
                                      "인생설계와진로\n목2,3 / 함선욱",
                                      "시스템소프트웨어\n월E, 수D / 황선태",
                                      "응용통계학\n화C, 목B / 윤상민",
                                      "응용통계학\n화F, 목F / 최진우",
                                      "이산수학\n월B, 수C / 우종우",
                                      "이산수학\n월C, 수B / 우종우",
                                      "컴퓨터구조\n화D, 목E / 임은진",
                                      "컴퓨터구조\n화E, 목D / 임은진",
                                      "모바일프로그래밍\n월A, 목C / 임성수",
                                      "오픈소스소프트웨어\n금2,3,4,5 / 김병곤",
                                      "오픈소스소프트웨어\n금6,7,8,9 / 김병곤",
                                      "컴파일러\n월D, 수F / 허대영",
                                      "컴파일러\n월F, 수E / 허대영",
                                      "인공지능\n월E, 화B / 우종우",
                                      "네트워크서비스프로토콜\n월C, 화C / 김영만",
                                      "컴퓨터비전\n화A, 목C / 윤상민",
                                      "알고리즘\n월D, 수F / 최준수",
                                      "알고리즘\n월F, 수E / 최준수",
                                      "데이터베이스\n월A, 목B / 김혁만",
                                      "데이터베이스\n월B, 목A / 김혁만",
                                      "고급시스템프로그래밍\n화D, 수C / 황선태",
                                      "임베디드시스템설계\n수D, 목E / 임성수",
                                      "임베디드시스템설계\n수D, 목D / 주용수",
                                      "소프트웨어기술의표현\n화7 / 최혜영",
                                      "소프트웨어기술의표현\n화8 / 최혜영",
                                      "소프트웨어기술의표현\n화9 / 최혜영",
                                      "정보검색과데이터마이닝\n수A, 금F / 최진우",
                                      "정보보호와시스템보안\n화G, 금B / 윤명근",
                                      "학부연구참여Ⅱ\n월10,11 / 윤명근",
                                      "분산시스템\n화B, 수B / 한재일",
                                      "XML\n월E, 화A / 김혁만",
                                      "무선네트워크\n월D, 화D / 김영만",
                                      "다학제간캡스톤디자인 Ⅱ\n목C,D / 윤성혜",
                                      "다학제간캡스톤디자인 Ⅱ\n목E,F / 윤성혜",
                                      "다학제간캡스톤디자인 Ⅱ\n목E,F / 주용수"};

    timeTableListView = (ListView) findViewById(R.id.timetable_listview);
    TestAdapter ta = new TestAdapter(this, 0, testStringArray);
    timeTableListView.setAdapter(ta);
    timeTableListView.setDivider(null);

    courseName = new String[] {
        "English Reading Ⅰ", "English Reading Ⅰ", "선형대수", "선형대수",
        "객체지향프로그래밍", "객체지향프로그래밍", "객체지향프로그래밍",
        "객체지향프로그래밍", "객체지향프로그래밍", "공학수학", "공학수학",
        "공학설계입문", "공학설계입문", "공학설계입문", "공학설계입문",
        "인생설계와진로", "인생설계와진로", "인생설계와진로", "시스템소프트웨어",
        "응용통계학", "응용통계학", "이산수학", "이산수학", "컴퓨터구조",
        "컴퓨터구조", "모바일프로그래밍", "오픈소스소프트웨어", "오픈소스소프트웨어",
        "컴파일러", "컴파일러", "인공지능", "네트워크서비스프로토콜", "컴퓨터비전",
        "알고리즘", "알고리즘", "데이터베이스", "데이터베이스", "고급시스템프로그래밍",
        "임베디드시스템설계", "임베디드시스템설계", "소프트웨어기술의표현",
        "소프트웨어기술의표현", "소프트웨어기술의표현", "정보검색과데이터마이닝",
        "정보보호와시스템보안", "학부연구참여Ⅱ", "분산시스템", "XML",
        "무선네트워크", "다학제간캡스톤디자인 Ⅱ", "다학제간캡스톤디자인 Ⅱ",
        "다학제간캡스톤디자인 Ⅱ"
    };

    courseColor = new String[] {
        "#20FEE6", "#20FEE6", "#FB1F6E", "#FB1F6E", "#CD2B63", "#CD2B63", "#CD2B63",
        "#CD2B63", "#CD2B63", "#A8EC5D", "#A8EC5D", "#A68235", "#A68235", "#A68235",
        "#A68235", "#6D01DC", "#6D01DC", "#6D01DC", "#7BB61F", "#58F43E", "#58F43E",
        "#B41EAC", "#B41EAC", "#AA824E", "#AA824E", "#83E901", "#6D29E2", "#6D29E2",
        "#528267", "#528267", "#104292", "#56772D", "#06AB06", "#4A5CE4", "#4A5CE4",
        "#76EAF4", "#76EAF4", "#4CDC66", "#CBAA3C", "#CBAA3C", "#1B74BC", "#1B74BC",
        "#1B74BC", "#BF9D6C", "#D55CE4", "#542ACA", "#56A705", "#F74EAC", "#A68285",
        "#499CDB", "#499CDB", "#499CDB"
    };

    handler = CourseDBHandler.open(getApplicationContext());

    handler.delete();

    handler.insert(0, 97, 111);
    handler.insert(0, 385, 399);
    handler.insert(1, 97, 111);
    handler.insert(1, 385, 399);
    handler.insert(2, 43, 57);
    handler.insert(2, 781, 795);
    handler.insert(3, 61, 75);
    handler.insert(3, 763, 777);
    handler.insert(4, 37, 58);
    handler.insert(4, 217, 238);
    handler.insert(5, 37, 58);
    handler.insert(5, 421, 442);
    handler.insert(6, 73, 94);
    handler.insert(6, 445, 466);
    handler.insert(7, 121, 142);
    handler.insert(7, 469, 490);
    handler.insert(8, 217, 238);
    handler.insert(8, 577, 598);
    handler.insert(9, 403, 417);
    handler.insert(9, 835, 849);
    handler.insert(10, 403, 417);
    handler.insert(10, 835, 849);
    handler.insert(11, 259, 273);
    handler.insert(11, 637, 651);
    handler.insert(12, 277, 291);
    handler.insert(12, 619, 633);
    handler.insert(13, 259, 273);
    handler.insert(13, 637, 651);
    handler.insert(14, 277, 291);
    handler.insert(14, 619, 633);
    handler.insert(15, 577, 598);
    handler.insert(16, 577, 598);
    handler.insert(17, 577, 598);
    handler.insert(18, 97, 111);
    handler.insert(18, 439, 453);
    handler.insert(19, 241, 255);
    handler.insert(19, 583, 597);
    handler.insert(20, 295, 309);
    handler.insert(20, 655, 669);
    handler.insert(21, 43, 57);
    handler.insert(21, 421, 435);
    handler.insert(22, 61, 75);
    handler.insert(22, 403, 417);
    handler.insert(23, 259, 273);
    handler.insert(23, 637, 651);
    handler.insert(24, 277, 291);
    handler.insert(24, 619, 633);
    handler.insert(25, 25, 39);
    handler.insert(25, 601, 615);
    handler.insert(26, 757, 802);
    handler.insert(27, 805, 850);
    handler.insert(28, 79, 93);
    handler.insert(28, 475, 489);
    handler.insert(29, 115, 129);
    handler.insert(29, 457, 471);
    handler.insert(30, 97, 111);
    handler.insert(30, 223, 237);
    handler.insert(31, 61, 75);
    handler.insert(31, 241, 255);
    handler.insert(32, 205, 219);
    handler.insert(32, 601, 615);
    handler.insert(33, 79, 93);
    handler.insert(33, 475, 489);
    handler.insert(34, 115, 129);
    handler.insert(34, 457, 471);
    handler.insert(35, 25, 39);
    handler.insert(35, 583, 597);
    handler.insert(36, 43, 57);
    handler.insert(36, 565, 579);
    handler.insert(37, 259, 273);
    handler.insert(37, 421, 435);
    handler.insert(38, 439, 453);
    handler.insert(38, 637, 651);
    handler.insert(39, 439, 453);
    handler.insert(39, 619, 633);
    handler.insert(40, 277, 286);
    handler.insert(41, 289, 298);
    handler.insert(42, 301, 310);
    handler.insert(43, 385, 399);
    handler.insert(43, 835, 849);
    handler.insert(44, 313, 327);
    handler.insert(44, 763, 777);
    handler.insert(45, 133, 154);
    handler.insert(46, 223, 237);
    handler.insert(46, 403, 417);
    handler.insert(47, 97, 111);
    handler.insert(47, 205, 219);
    handler.insert(48, 79, 93);
    handler.insert(48, 259, 273);
    handler.insert(49, 601, 633);
    handler.insert(50, 637, 669);
    handler.insert(51, 637, 669);

    uhandler = UserDBHandler.open(getApplicationContext());

  }

  private class TestAdapter extends ArrayAdapter<String> {

    private ArrayList<Integer> listItem;

    public TestAdapter(Context context, int textViewResourceId, String[] items) {

      super(context, textViewResourceId, items);
      listItem = new ArrayList<Integer>();

    }

    public int getCount() { return testStringArray.length; }

    public View getView(int position, View convertView, ViewGroup parent) {

      final int checkBoxPosition = position;
      View v = convertView;

      if(v == null) {

        LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = vi.inflate(R.layout.timetable_list_row, null);

      }

      String str = testStringArray[position];

      if(str != null) {

        TextView text = (TextView)v.findViewById(R.id.timetable_list_txt);
        if(text != null)
          text.setText(str);

        final CheckBox cb = (CheckBox)v.findViewById(R.id.timetable_list_cb);

        final Cursor ucursor = uhandler.selectByCode(Integer.toString(checkBoxPosition));

        if(ucursor != null && ucursor.getCount() > 0) {

          boolean flag = false;

          for(int i = 0; i < listItem.size(); i++) {
            if (listItem.get(i) == checkBoxPosition) {
              flag = true;
              break;
            }
          }

          if(!flag)
            listItem.add(checkBoxPosition);

        }

        ucursor.close();

        if(cb != null) {

          cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

              if (b) {

                int course_start_time, course_end_time;

                Cursor cursor = handler.selectByCode(Integer.toString(checkBoxPosition));

                if (cursor != null && cursor.getCount() != 0)
                  cursor.moveToFirst();

                Cursor ucursor2 = null;

                do {

                  course_start_time = cursor.getInt(2);
                  course_end_time = cursor.getInt(3);
                  ucursor2 =
                      uhandler.selectByTime(Integer.toString(course_start_time),
                                            Integer.toString(course_end_time));

                  if (ucursor2.getCount() > 0) {

                    for (int i = 0; i < listItem.size(); i++)
                      if (listItem.get(i) == checkBoxPosition) {
                        ucursor2.close();
                        cursor.close();
                        return;
                      }

                    cb.setChecked(false);
                    createConfDialog();

                    ucursor2.close();
                    cursor.close();
                    return;
                  }

                } while (cursor.moveToNext());

                for (int i = 0; i < listItem.size(); i++)
                  if (listItem.get(i) == checkBoxPosition) {
                    ucursor2.close();
                    cursor.close();
                    return;
                  }

                listItem.add(checkBoxPosition);

                if (cursor != null && cursor.getCount() != 0)
                  cursor.moveToFirst();

                do {

                  int code = cursor.getInt(1);
                  int start_time = cursor.getInt(2);
                  int end_time = cursor.getInt(3);
                  String name = courseName[code];
                  String color = courseColor[code];

                  uhandler.insert(code, start_time, end_time, name, color);
                  uhandler.selectAll();

                } while (cursor.moveToNext());

                ucursor2.close();
                cursor.close();

              } else {

                for (int i = 0; i < listItem.size(); i++) {
                  if (listItem.get(i) == checkBoxPosition) {

                    listItem.remove(i);
                    uhandler.deleteByCode(Integer.toString(checkBoxPosition));
                    uhandler.selectAll();

                    break;

                  }
                }

              }

            }
          });

          boolean isChecked = false;

          for(int i = 0; i < listItem.size(); i++) {
            if(listItem.get(i) == checkBoxPosition) {
              cb.setChecked(true);
              isChecked = true;
              break;
            }
          }

          if(!isChecked)
            cb.setChecked(false);

         }
      }

      return v;
    }
  }

  public void onClick(View v) {
    if(v.getId() == R.id.sel_ttab_btn){
      setResult(1);
      handler.close();
      uhandler.close();
      finish();
    }
  }

  private void createConfDialog() {
    final View innerView = getLayoutInflater().inflate(R.layout.time_conf_dialog, null);

    timeConfDialog = new TimeConfDialog(this);
    timeConfDialog.show();
  }

}
