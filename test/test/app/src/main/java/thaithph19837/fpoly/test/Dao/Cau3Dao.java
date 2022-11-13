package thaithph19837.fpoly.test.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import thaithph19837.fpoly.test.SQL;

public class Cau3Dao {
    Context context;
    SQLiteDatabase db;

    public Cau3Dao(Context context) {
        this.context = context;
        SQL sql = new SQL(context);
        db = sql.getWritableDatabase();
    }

}
