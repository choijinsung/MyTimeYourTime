package cjs.example.com.mytimeyourtime;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by cjs on 2015-12-12.
 */
public class UserDBOpenHelper extends SQLiteOpenHelper {

  public UserDBOpenHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
    super(context, name, factory, version);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {

    String sql = "create table user (_id integer primary key autoincrement,"
                 + "code integer, start_time integer, end_time integer,"
                 + "name text, color text)";

    db.execSQL(sql);

  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    String sql = "drop table if exists user";
    db.execSQL(sql);

    onCreate(db);
  }
}
