package thaithph19837.fpoly.test.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import thaithph19837.fpoly.test.Dao.HoaDonChiTietDao;
import thaithph19837.fpoly.test.Dao.HoaDonDao;
import thaithph19837.fpoly.test.Dao.SanPhamDao;
import thaithph19837.fpoly.test.Dao.TheLoaiDao;
import thaithph19837.fpoly.test.Obj.HoaDon;
import thaithph19837.fpoly.test.Obj.HoaDonChiTiet;
import thaithph19837.fpoly.test.Obj.SanPham;
import thaithph19837.fpoly.test.Obj.TheLoai;
import thaithph19837.fpoly.test.R;

public class XemTatCa extends AppCompatActivity {
    ListView lvTheLoai, lvSanPham, lvHoaDon, lvHoaDonChiTiet;
    ArrayAdapter adapter;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xem_tat_ca);
        lvTheLoai = findViewById(R.id.lvTheLoai);
        lvSanPham = findViewById(R.id.lvSanPham);
        lvHoaDon = findViewById(R.id.lvHoaDon);
        lvHoaDonChiTiet = findViewById(R.id.lvHoaDonChiTiet);



        lvTheLoai.setAdapter(TheLoai());
        lvSanPham.setAdapter(SanPham());
        lvHoaDon.setAdapter(HoaDon());
        lvHoaDonChiTiet.setAdapter(HoaDonChiTiet());
    }

    public ArrayAdapter TheLoai() {
        List<TheLoai> ls = new ArrayList<>();
        TheLoaiDao dao = new TheLoaiDao(context);
        ls = dao.getAll();
        List<String> list = new ArrayList<>();
        for (TheLoai tl: ls) {
            list.add(tl.getMaTL()+ "\t" + tl.getTenTL());
        }
        adapter = new ArrayAdapter(context, android.R.layout.simple_expandable_list_item_1, list);
        return adapter;
    }

    public ArrayAdapter SanPham() {
        List<SanPham> ls = new ArrayList<>();
        SanPhamDao dao = new SanPhamDao(context);
        ls = dao.getAll();
        List<String> list = new ArrayList<>();
        for (SanPham sp: ls) {
            list.add(sp.getMaSP()+ "\t" + sp.getTenSP()+ "\t" + sp.getSoLuongNhap()+ "\t" + sp.getDonGiaNhap()+ "\t" + sp.getNgayNhap()+ "\t" + sp.getMaTL());
        }
        adapter = new ArrayAdapter(context, android.R.layout.simple_expandable_list_item_1, list);
        return adapter;
    }

    public ArrayAdapter HoaDon() {
        List<HoaDon> ls = new ArrayList<>();
        HoaDonDao dao = new HoaDonDao(context);
        ls = dao.getAll();
        List<String> list = new ArrayList<>();
        for (HoaDon hd: ls) {
            list.add(hd.getMaHD()+ "\t" + hd.getNgayHD());
        }
        adapter = new ArrayAdapter(context, android.R.layout.simple_expandable_list_item_1, list);
        return adapter;
    }


    public ArrayAdapter HoaDonChiTiet() {
        List<HoaDonChiTiet> ls = new ArrayList<>();
        HoaDonChiTietDao dao = new HoaDonChiTietDao(context);
        ls = dao.getAll();
        List<String> list = new ArrayList<>();
        for (HoaDonChiTiet hdct: ls) {
            list.add(hdct.getMaHDCT()+ "\t" + hdct.getMaHD()+ "\t" + hdct.getMaSP()+ "\t" + hdct.getDonGiaXuat()+ "\t" + hdct.getSoLuongXuat());
        }
        adapter = new ArrayAdapter(context, android.R.layout.simple_expandable_list_item_1, list);
        return adapter;
    }
}