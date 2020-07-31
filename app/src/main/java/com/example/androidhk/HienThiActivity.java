package com.example.androidhk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androidhk.adapter.AdaterTest;

import com.example.androidhk.database.Database;
import com.example.androidhk.model.Info;

import java.util.ArrayList;

public class HienThiActivity extends AppCompatActivity {
    Database database;
    ListView nv;
    TextView cot1,cot2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi2);

        database = new Database(this);
        cot1 = findViewById(R.id.cot1);
        cot2 = findViewById(R.id.cot2);
        nv = findViewById(R.id.listnv);
        if (getIntent().getStringExtra("state2").equals("0")) {
            ArrayList<Info> listInfo = database.getListInfoCNTT2();
            AdaterTest adaterTest = new AdaterTest(listInfo, this, R.layout.hienthi);
            cot1.setText("Mã         ");
            cot2.setText("Tên");
            nv.setAdapter(adaterTest);
        } else {
            if (getIntent().getStringExtra("state2").equals("1")) {
                ArrayList<Info> listInfo = database.getDT();
                AdaterTest adaterTest = new AdaterTest(listInfo, this, R.layout.hienthi);
                cot1.setText("số lượng       ");
                cot2.setText(" Tuổi");
                nv.setAdapter(adaterTest);
            } else {
                if (getIntent().getStringExtra("state2").equals("3")) {
                    ArrayList<Info> listInfo = database.getPB();
                    AdaterTest adaterTest = new AdaterTest(listInfo, this, R.layout.hienthi);
                    cot1.setText("số lượng       ");
                    cot2.setText(" Phòng ban");
                    nv.setAdapter(adaterTest);
                } else {
                    if (getIntent().getStringExtra("state2").equals("4")) {
                        ArrayList<Info> listInfo = database.getGT();
                        AdaterTest adaterTest = new AdaterTest(listInfo, this, R.layout.hienthi);
                        cot1.setText("số lượng       ");
                        cot2.setText(" Gioi Tinh");
                        nv.setAdapter(adaterTest);
                    }
                }
            }
        }
    }
}