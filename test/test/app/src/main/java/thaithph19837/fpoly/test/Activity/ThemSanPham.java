package thaithph19837.fpoly.test.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import thaithph19837.fpoly.test.Dao.SanPhamDao;
import thaithph19837.fpoly.test.Obj.SanPham;
import thaithph19837.fpoly.test.R;

public class ThemSanPham extends AppCompatActivity {
    EditText edtTenSP,edtSoLuongNhap,edtNgayNhap,edtDonGiaNhap,edtMaTlSP;
    Button btnThemSanPham;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_san_pham);
        edtTenSP = findViewById(R.id.edtTenSP);
        edtSoLuongNhap = findViewById(R.id.edtSoLuongNhap);
        edtNgayNhap = findViewById(R.id.edtNgayNhap);
        edtDonGiaNhap = findViewById(R.id.edtDonGiaNhap);
        edtMaTlSP = findViewById(R.id.edtMaTlSP);
        btnThemSanPham = findViewById(R.id.btnThemSanPham);
        btnThemSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SanPham sp = new SanPham();
                SanPhamDao dao = new SanPhamDao(context);
                sp.setTenSP(edtTenSP.getText().toString());
                sp.setSoLuongNhap(Integer.parseInt(edtSoLuongNhap.getText().toString()));
                sp.setNgayNhap(edtNgayNhap.getText().toString());
                sp.setDonGiaNhap(Integer.parseInt(edtDonGiaNhap.getText().toString()));
                sp.setMaTL(Integer.parseInt(edtMaTlSP.getText().toString()));
                dao.insert(sp);
            }
        });
    }
}