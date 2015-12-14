package cjs.example.com.mytimeyourtime;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by cjs on 2015-12-12.
 */
public class UserDBHandler {

  UserDBOpenHelper helper;
  SQLiteDatabase db;

  public UserDBHandler(Context ctx) {
    helper = new UserDBOpenHelper(ctx, "tableuser.sqlite", null, 1);
  }

  public static UserDBHandler open(Context ctx) {
    return new UserDBHandler(ctx);
  }

  public void close() { helper.close(); }

  public void insert(int code, int start_time, int end_time, String name, String color) {

    db = helper.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put("code", code);
    values.put("start_time", start_time);
    values.put("end_time", end_time);
    values.put("name", name);
    values.put("color", color);

    db.insert("user", null, values);

  }

  public void update(int _id, int code, int start_time, int end_time, String name, String color) {

    db = helper.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put("code", code);
    values.put("start_time", start_time);
    values.put("end_time", end_time);
    values.put("name", name);
    values.put("color", color);

    db.update("user", values, "id = ?", new String[] { Integer.toString(_id) });
  }

  public void deleteByCode(String code) {

    db = helper.getWritableDatabase();
    db.delete("user", "code = ?", new String[]{ code });
    db.delete("sqlite_sequence", "name = ?", new String[]{ "user" });

  }

  public void delete() {

    db = helper.getWritableDatabase();
    db.delete("user", null, null);
    db.delete("sqlite_sequence", "name = ?", new String[]{ "user" });

  }

  public Cursor selectByCode(String code) {

    db = helper.getReadableDatabase();
    Cursor c = db.rawQuery("SELECT * FROM user WHERE code = ?", new String[]{ code });

    return c;
  }

  public Cursor selectByTime(String start_time, String end_time) {

    db = helper.getReadableDatabase();
    Cursor c = db.rawQuery("SELECT * FROM user WHERE (start_time >= ? and start_time <= ?) "
                           + "or (end_time >= ? and end_time <= ?) ", new String[]{ start_time, end_time, start_time, end_time });

    return c;

  }

  public void selectAll() {

    db = helper.getReadableDatabase();
    Cursor c = db.rawQuery("SELECT * FROM user", null);

    if(c != null && c.getCount() != 0) {
      c.moveToFirst();

      do {

        int _id = c.getInt(0);
        int code = c.getInt(1);
        int start_time = c.getInt(2);
        int end_time = c.getInt(3);
        String name = c.getString(4);
        String color = c.getString(5);

        Log.i("myTag", _id + " " + code + " " + start_time + " " + end_time + " " + name + " " + color);

      } while (c.moveToNext());
    }

  }

}
