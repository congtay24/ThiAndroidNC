package thaithph19837.fpoly.test.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import thaithph19837.fpoly.test.Dao.HoaDonChiTietDao;
import thaithph19837.fpoly.test.Obj.HoaDonChiTiet;
import thaithph19837.fpoly.test.R;

public class ThemHoaDonChiTiet extends AppCompatActivity {
    EditText edt_MaHoaDon,edt_MaSanPham,edt_soLuognXuat,edt_donGiaXuat;
    Button btnThemHoaDonChiTiet;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hoa_don_chi_tiet);
        edt_MaHoaDon = findViewById(R.id.edt_MaHoaDon);
        edt_MaSanPham = findViewById(R.id.edt_MaSanPham);
        edt_soLuognXuat = findViewById(R.id.edt_soLuognXuat);
        edt_donGiaXuat = findViewById(R.id.edt_donGiaXuat);
        btnThemHoaDonChiTiet = findViewById(R.id.btnThemHoaDonChiTiet);
        btnThemHoaDonChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setMaHD(Integer.parseInt(edt_MaHoaDon.getText().toString()));
                hoaDonChiTiet.setMaSP(Integer.parseInt(edt_MaSanPham.getText().toString()));
                hoaDonChiTiet.setSoLuongXuat(Integer.parseInt(edt_soLuognXuat.getText().toString()));
                hoaDonChiTiet.setDonGiaXuat(Integer.parseInt(edt_donGiaXuat.getText().toString()));
                HoaDonChiTietDao hoaDonChiTietDao = new HoaDonChiTietDao(context);
                hoaDonChiTietDao.insert(hoaDonChiTiet);
            }
        });
    }
}