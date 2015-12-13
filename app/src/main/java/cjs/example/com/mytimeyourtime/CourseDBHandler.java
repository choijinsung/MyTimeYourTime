package cjs.example.com.mytimeyourtime;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by cjs on 2015-12-12.
 */
public class CourseDBHandler {

  CourseDBOpenHelper helper;
  SQLiteDatabase db;

  public CourseDBHandler(Context ctx) {
    helper = new CourseDBOpenHelper(ctx, "mytimeyourtime.sqlite", null, 1);
  }

  public static CourseDBHandler open(Context ctx) {
    return new CourseDBHandler(ctx);
  }

  public void close() { helper.close(); }

  public void insert(int code, int start_time, int end_time) {

    db = helper.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put("code", code);
    values.put("start_time", start_time);
    values.put("end_time", end_time);

    db.insert("course", null, values);

  }

  public void update(int _id, int code, int start_time, int end_time) {

    db = helper.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put("code", code);
    values.put("start_time", start_time);
    values.put("end_time", end_time);

    db.update("course", values, "id = ?", new String[] { Integer.toString(_id) });
  }

  public void delete() {

    db = helper.getWritableDatabase();
    db.delete("course", null, null);
    db.delete("sqlite_sequence", "name = ?", new String[]{ "course" });

  }

  public Cursor selectByCode(String code) {

    db = helper.getReadableDatabase();
    Cursor c = db.rawQuery("SELECT * FROM course WHERE code = ?", new String[]{ code });
    return c;

  }

  public Cursor selectByTime(String start_time, String end_time) {

    db = helper.getReadableDatabase();
    Cursor c = db.rawQuery("SELECT * FROM course WHERE (start_time >= ? and start_time <= ?) "
                           + "or (end_time >= ? and end_time <= ?) ", new String[]{ start_time, end_time, start_time, end_time });

    if(c != null && c.getCount() != 0) {
      c.moveToFirst();

      do {

        int _id = c.getInt(0);
        int code = c.getInt(1);
        String start_tim = c.getString(2);
        String end_tim = c.getString(3);

        Log.i("myTag", _id + " " + code + " " + start_tim + " " + end_tim);

      } while (c.moveToNext());
    }

    return c;

  }

  public void selectAll() {

    db = helper.getReadableDatabase();
    Cursor c = db.rawQuery("SELECT * FROM course", null);

  }
}
