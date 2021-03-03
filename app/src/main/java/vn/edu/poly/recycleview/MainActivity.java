package vn.edu.poly.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.os.Handler;
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

        rvList.setHasFixedSize(true);
        sinhvienAdapter = new SinhvienAdapter(sinhvienList, new SinhvienAdapter.IOnclickListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(MainActivity.this,"This is item " + position,Toast.LENGTH_SHORT).show();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(linearLayoutManager);
        rvList.setAdapter(sinhvienAdapter);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    Sinhvien sinhvien = new Sinhvien();
                    sinhvien.setId("id " + i);
                    sinhvien.setName("name " + i);
                    sinhvien.setImg(R.drawable.img);
                    sinhvienList.add(sinhvien);
                }
                sinhvienAdapter.isShimmer = false;
                sinhvienAdapter.notifyDataSetChanged();
            }
        },3000);
    }
}
