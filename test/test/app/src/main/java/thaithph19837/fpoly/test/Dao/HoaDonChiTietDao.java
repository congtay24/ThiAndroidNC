package thaithph19837.fpoly.test.Dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import thaithph19837.fpoly.test.Obj.HoaDon;
import thaithph19837.fpoly.test.Obj.HoaDonChiTiet;
import thaithph19837.fpoly.test.SQL;

public class HoaDonChiTietDao {
    Context context;
    SQLiteDatabase db;

    public HoaDonChiTietDao(Context context) {
        this.context = context;
        SQL sql = new SQL(context);
        db = sql.getWritableDatabase();
    }
    public long insert (HoaDonChiTiet hdct){
        ContentValues value = new ContentValues();
        value.put("maHD",hdct.getMaHD());
        value.put("maSP",hdct.getMaSP());
        value.put("soLuongXuat",hdct.getSoLuongXuat());
        value.put("donGiaXuat",hdct.getDonGiaXuat());
        return db.insert("HoaDonChiTiet",null, value);
    }
    @SuppressLint("Range")
    private List<HoaDonChiTiet> getData(String sql , String...SelectArg) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,SelectArg);
        while(c.moveToNext()){
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            hdct.setMaHDCT(c.getInt(c.getColumnIndex("maHDCT")));
            hdct.setMaHD(c.getInt(c.getColumnIndex("maHD")));
            hdct.setMaSP(c.getInt(c.getColumnIndex("maSP")));
            hdct.setSoLuongXuat(c.getInt(c.getColumnIndex("soLuongXuat")));
            hdct.setDonGiaXuat(c.getInt(c.getColumnIndex("donGiaXuat")));
            list.add(hdct);
        }
        return list ;
    }
    public List<HoaDonChiTiet> getAll(){
        String sql = "SELECT *FROM HoaDonChiTiet" ;
        return getData(sql);
    }
}
