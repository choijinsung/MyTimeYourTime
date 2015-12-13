package cjs.example.com.mytimeyourtime;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cjs on 2015-12-12.
 */
public class CourseDBOpenHelper extends SQLiteOpenHelper {

  public CourseDBOpenHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
    super(context, name, factory, version);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {

    String sql = "create table course (_id integer primary key autoincrement,"
        + "code integer, start_time integer, end_time integer)";

    db.execSQL(sql);

  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    String sql = "drop table if exists course";
    db.execSQL(sql);

    onCreate(db);
  }

}
