package vn.edu.poly.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SinhvienAdapter extends RecyclerView.Adapter<SinhvienAdapter.StudentHolder> {


    MyOnItemClickListener myOnItemClickListener;

    public void setMyOnItemClickListener(MyOnItemClickListener myOnItemClickListener) {
        this.myOnItemClickListener = myOnItemClickListener;
    }

    List<Sinhvien> sinhvienList;

    public SinhvienAdapter(List<Sinhvien> sinhvienList) {
        this.sinhvienList = sinhvienList;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, final int position) {

        holder.tv.setText(sinhvienList.get(position).getId()+" | "+ sinhvienList.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myOnItemClickListener.onClick(sinhvienList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return sinhvienList.size();
    }

    public static class StudentHolder extends RecyclerView.ViewHolder {

        TextView tv;
        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
