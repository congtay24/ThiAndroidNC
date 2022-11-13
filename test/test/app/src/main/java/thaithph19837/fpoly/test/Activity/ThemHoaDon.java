package thaithph19837.fpoly.test.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import thaithph19837.fpoly.test.Dao.HoaDonDao;
import thaithph19837.fpoly.test.Obj.HoaDon;
import thaithph19837.fpoly.test.R;

public class ThemHoaDon extends AppCompatActivity {
    EditText edtNgayHoaDon;
    Button btnThemHoaDon;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_hoa_don);
        edtNgayHoaDon = findViewById(R.id.edtNgayHoaDon);
        btnThemHoaDon = findViewById(R.id.btnThemHoaDon);
        btnThemHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoaDon hd = new HoaDon();
                HoaDonDao dao = new HoaDonDao(context);
                hd.setNgayHD(edtNgayHoaDon.getText().toString());
                dao.insert(hd);
            }
        });

    }
}