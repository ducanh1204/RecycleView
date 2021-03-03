package vn.edu.poly.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

public class SinhvienAdapter extends RecyclerView.Adapter<SinhvienAdapter.StudentHolder> {

    private List<Sinhvien> sinhvienList;
    public boolean isShimmer = true;
    private int shimmerNumber = 5;


    public interface IOnclickListener {
        void onClick(int position);
    }

    private IOnclickListener iOnclickListener;

    public SinhvienAdapter(List<Sinhvien> sinhvienList, IOnclickListener iOnclickListener) {
        this.sinhvienList = sinhvienList;
        this.iOnclickListener = iOnclickListener;
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new StudentHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, final int position) {

        if (isShimmer) {
            holder.shimmerFrameLayout.startShimmer();
        } else {

            holder.tvName.setText(sinhvienList.get(position).getName());
            holder.tvId.setText(sinhvienList.get(position).getId());

            holder.img.setImageResource(sinhvienList.get(position).getImg());

            holder.tvName.setBackground(null);
            holder.tvId.setBackground(null);

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (iOnclickListener != null) {
                        iOnclickListener.onClick(position);
                    }
                }
            });

            holder.shimmerFrameLayout.stopShimmer();
            holder.shimmerFrameLayout.setShimmer(null);
        }

    }

    @Override
    public int getItemCount() {
        return isShimmer ? shimmerNumber : sinhvienList.size();
    }

    public static class StudentHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvId;
        private ShimmerFrameLayout shimmerFrameLayout;
        private ImageView img;

        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvId = itemView.findViewById(R.id.tvId);
            img = itemView.findViewById(R.id.img);
            shimmerFrameLayout = itemView.findViewById(R.id.shimmerFrameLayout);
        }
    }
}
