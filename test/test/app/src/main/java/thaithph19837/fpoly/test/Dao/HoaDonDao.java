package thaithph19837.fpoly.test.Dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import thaithph19837.fpoly.test.Obj.HoaDon;
import thaithph19837.fpoly.test.Obj.TheLoai;
import thaithph19837.fpoly.test.SQL;

public class HoaDonDao {
    Context context;
    SQLiteDatabase db;

    public HoaDonDao(Context context) {
        this.context = context;
        SQL sql = new SQL(context);
        db = sql.getWritableDatabase();
    }
    public long insert (HoaDon hd){
        ContentValues value = new ContentValues();
        value.put("ngayHD",hd.getNgayHD());
        return db.insert("HoaDon",null, value);
    }
    @SuppressLint("Range")
    private List<HoaDon> getData(String sql , String...SelectArg) {
        List<HoaDon> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,SelectArg);
        while(c.moveToNext()){
            HoaDon hd = new HoaDon();
            hd.setMaHD(c.getInt(c.getColumnIndex("maHD")));
            hd.setNgayHD(c.getString(c.getColumnIndex("ngayHD")));
            list.add(hd);
        }
        return list ;
    }
    public List<HoaDon> getAll(){
        String sql = "SELECT *FROM HoaDon" ;
        return getData(sql);
    }
}
