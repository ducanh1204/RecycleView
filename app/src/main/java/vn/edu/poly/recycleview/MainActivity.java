package vn.edu.poly.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvList;
    List<Sinhvien> sinhvienList;
    SinhvienAdapter sinhvienAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvList = findViewById(R.id.rvList);

        sinhvienList = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Sinhvien sinhvien = new Sinhvien();
            sinhvien.setId("id " + i);
            sinhvien.setName("name " + i);
            sinhvienList.add(sinhvien);
        }

        rvList.setHasFixedSize(true);
        sinhvienAdapter = new SinhvienAdapter(sinhvienList);
        sinhvienAdapter.setMyOnItemClickListener(new MyOnItemClickListener() {
            @Override
            public void onClick(Sinhvien sinhvien) {
                Toast.makeText(getApplicationContext(),"AAAAAAAAAA",Toast.LENGTH_SHORT).show();
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(sinhvienAdapter);


    }
}
