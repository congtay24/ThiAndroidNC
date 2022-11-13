package thaithph19837.fpoly.test.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import thaithph19837.fpoly.test.R;

public class Cau2 extends AppCompatActivity {
    Button btnThemTheLoai, btnThemSanPham, btnThemHoaDon, btnThemHoaDonChiTiet,btnXemTatCa;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cau2);
        btnThemTheLoai = findViewById(R.id.ThemTheLoai);
        btnThemSanPham = findViewById(R.id.ThemSanPham);
        btnThemHoaDon = findViewById(R.id.ThemHoaDon);
        btnThemHoaDonChiTiet = findViewById(R.id.ThemHoaDonChiTiet);
        btnXemTatCa = findViewById(R.id.btnXemTatCa);
        btnThemTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cau2.this, ThemTheLoai.class));
            }
        });
        btnThemSanPham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cau2.this, ThemSanPham.class));
            }
        });
        btnThemHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cau2.this, ThemHoaDon.class));
            }
        });
        btnThemHoaDonChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cau2.this, ThemHoaDonChiTiet.class));
            }
        });
        btnXemTatCa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cau2.this, XemTatCa.class));
            }
        });

    }
}