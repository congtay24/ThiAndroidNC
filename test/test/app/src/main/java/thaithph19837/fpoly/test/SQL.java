package thaithph19837.fpoly.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQL extends SQLiteOpenHelper {
    public SQL( Context context) {
        super(context, "SQL", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE TheLoai(\n" +
                "\tmaTL INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  \ttenTL text\n" +
                ")");
        db.execSQL("CREATE TABLE SanPham(\n" +
                "\tmaSP INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  \ttenSP text,\n" +
                "  \tsoLuongNhap integer,\n" +
                "  \tngayNhap date,\n" +
                "  \tdonGiaNhap integer,\n" +
                "  \tmaTL integer REFERENCES TheLoai(matl)\n" +
                ")");
        db.execSQL("CREATE TABLE HoaDon(\n" +
                "\tmaHD INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  \tngayHD text\n" +
                ")");
        db.execSQL("CREATE TABLE HoaDonChiTiet(\n" +
                "\tmaHDCT INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "  \tmaHD integer REFERENCES HoaDon(mahd),\n" +
                "  \tmaSP integer REFERENCES SanPham(masp),\n" +
                "  \tsoLuongXuat integer,\n" +
                "  \tdonGiaXuat integer\n" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS TheLoai");
        db.execSQL("DROP TABLE IF EXISTS SanPham");
        db.execSQL("DROP TABLE IF EXISTS HoaDon");
        db.execSQL("DROP TABLE IF EXISTS HoaDonChiTiet");
        onCreate(db);


    }
}
