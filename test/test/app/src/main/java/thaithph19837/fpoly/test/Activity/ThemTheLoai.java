package thaithph19837.fpoly.test.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import thaithph19837.fpoly.test.Dao.TheLoaiDao;
import thaithph19837.fpoly.test.Obj.TheLoai;
import thaithph19837.fpoly.test.R;

public class ThemTheLoai extends AppCompatActivity {
    EditText edtTenTL;
    Button btnThemTheLoai;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_the_loai);
        edtTenTL = findViewById(R.id.edtTenTL);
        btnThemTheLoai = findViewById(R.id.btnThemTheLoai);
        btnThemTheLoai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TheLoai theLoai = new TheLoai();
                theLoai.setTenTL(edtTenTL.getText().toString());
                TheLoaiDao theLoaiDao = new TheLoaiDao(context);
                theLoaiDao.insert(theLoai);
            }
        });
    }
}