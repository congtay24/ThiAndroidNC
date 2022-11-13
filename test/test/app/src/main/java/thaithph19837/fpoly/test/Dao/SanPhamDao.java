package thaithph19837.fpoly.test.Dao;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import thaithph19837.fpoly.test.Obj.SanPham;
import thaithph19837.fpoly.test.Obj.TheLoai;
import thaithph19837.fpoly.test.SQL;

public class SanPhamDao {
    Context context;
    SQLiteDatabase db;

    public SanPhamDao(Context context) {
        this.context = context;
        SQL sql = new SQL(context);
        db = sql.getWritableDatabase();
    }
    public long insert (SanPham sp){
        ContentValues value = new ContentValues();
        value.put("tenSP",sp.getTenSP());
        value.put("soLuongNhap",sp.getSoLuongNhap());
        value.put("ngayNhap",sp.getNgayNhap());
        value.put("donGiaNhap",sp.getDonGiaNhap());
        value.put("maTL",sp.getMaTL());
        return db.insert("SanPham",null, value);
    }
    @SuppressLint("Range")
    private List<SanPham> getData(String sql , String...SelectArg) {
        List<SanPham> list = new ArrayList<>();
        Cursor c = db.rawQuery(sql,SelectArg);
        while(c.moveToNext()){
            SanPham sp = new SanPham();
            sp.setMaSP(c.getInt(c.getColumnIndex("maSP")));
            sp.setTenSP(c.getString(c.getColumnIndex("tenSP")));
            sp.setSoLuongNhap(c.getInt(c.getColumnIndex("soLuongNhap")));
            sp.setNgayNhap(c.getString(c.getColumnIndex("ngayNhap")));
            sp.setDonGiaNhap(c.getInt(c.getColumnIndex("donGiaNhap")));
            sp.setMaTL(c.getInt(c.getColumnIndex("maTL")));
            list.add(sp);
        }
        return list ;
    }
    public List<SanPham> getAll(){
        String sql = "SELECT *FROM SanPham" ;
        return getData(sql);
    }
}
