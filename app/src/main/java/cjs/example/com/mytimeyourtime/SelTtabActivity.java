package cjs.example.com.mytimeyourtime;

import android.app.Activity;
import android.content.Context;
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
                                      "학부연구참여Ⅱ\n월10,11 / 윤명근"};

    timeTableListView = (ListView) findViewById(R.id.timetable_listview);
    TestAdapter ta = new TestAdapter(this, 0, testStringArray);
    timeTableListView.setAdapter(ta);
    timeTableListView.setDivider(null);
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

        CheckBox cb = (CheckBox)v.findViewById(R.id.timetable_list_cb);

        if(cb != null) {

          cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

              if(b) {
                for(int i = 0; i < listItem.size(); i++)
                  if(listItem.get(i) == checkBoxPosition)
                    return;
                listItem.add(checkBoxPosition);
              } else {
                for(int i = 0; i < listItem.size(); i++) {
                  if(listItem.get(i) == checkBoxPosition) {
                    listItem.remove(i);
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
      finish();
    }
  }
}
