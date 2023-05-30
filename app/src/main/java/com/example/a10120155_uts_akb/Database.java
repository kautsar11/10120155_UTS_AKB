package com.example.a10120155_uts_akb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Database extends SQLiteOpenHelper {
    // nim : 10120155
// nama : kautsar teguh dwi putra
// kelas : IF-4
    private static final String DATABASE_NAME = "uts.db";
    private static final int DATABASE_VERSION = 1;

    public Database(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sql = "CREATE TABLE notes (\n" +
                "  id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  title TEXT,\n" +
                "  description TEXT,\n" +
                "  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP\n" +
                ");\n";
        Log.d("data","onCreate" + sql);
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db0, int db1, int db2){}
}
