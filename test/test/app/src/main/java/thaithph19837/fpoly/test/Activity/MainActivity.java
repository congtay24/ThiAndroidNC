package thaithph19837.fpoly.test.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import thaithph19837.fpoly.test.R;

public class MainActivity extends AppCompatActivity {
    Button btnCau1, btnCau2, btnCau3, btnCau4;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCau1 = findViewById(R.id.btnCau1);
        btnCau2 = findViewById(R.id.btnCau2);
        btnCau3 = findViewById(R.id.btnCau3);
        btnCau4 = findViewById(R.id.btnCau4);
        btnCau2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, Cau2.class);
                startActivity(intent);
            }
        });
        btnCau3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this, Cau3.class);
                startActivity(intent);
            }
        });
    }
}