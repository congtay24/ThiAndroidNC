package thaithph19837.fpoly.test.Dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import thaithph19837.fpoly.test.Obj.TheLoai;
import thaithph19837.fpoly.test.SQL;

public class TheLoaiDao {
    Context context;
    SQLiteDatabase db;

    public TheLoaiDao(Context context) {
        this.context = context;
        SQL sql = new SQL(context);
        db = sql.getWritableDatabase();
    }
    public long insert (TheLoai tl){
        ContentValues value = new ContentValues();
        value.put("tenTL", tl.getTenTL());
        return db.insert("TheLoai",null, value);
    }
    @SuppressLint("Range")
    private List<TheLoai> getData(String sql , String...SelectArg) {
        List<TheLoai> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,SelectArg);
        while(c.moveToNext()){
            TheLoai tl = new TheLoai();
            tl.setMaTL(c.getInt(c.getColumnIndex("maTL")));
            tl.setTenTL(c.getString(c.getColumnIndex("tenTL")));
            list.add(tl);
        }
        return list ;
    }
    public List<TheLoai> getAll(){
        String sql = "SELECT *FROM TheLoai" ;
        return getData(sql);
    }
}
