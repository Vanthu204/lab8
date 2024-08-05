package com.example.androidthi;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MotorcycleAdapter extends RecyclerView.Adapter<MotorcycleAdapter.ViewHolder> {
    private List<Motorcycle> motorcycles;
    private Context context;

    public MotorcycleAdapter(Context context, List<Motorcycle> motorcycles) {
        this.context = context;
        this.motorcycles = motorcycles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_motorcycle, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Motorcycle motorcycle = motorcycles.get(position);
        holder.ten_xe.setText(motorcycle.getTen_xe());
        holder.Mau_sac.setText(motorcycle.getMau_sac());
        holder.gia_ban.setText(String.format("Giá: %d VND", motorcycle.getGia_ban()));

        // Nếu có hình ảnh, tải nó bằng Picasso
//        if (motorcycle.getHinh_anh() != null && !motorcycle.getHinh_anh().isEmpty()) {
////            Picasso.get().load(motorcycle.getHinh_anh()).into(holder.imageView);
//        } else {
//            holder.imageView.setImageResource(R.drawable.ic_launcher_background); // Đặt hình ảnh mặc định nếu không có
//        }
    }

    @Override
    public int getItemCount() {
        return motorcycles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView ten_xe;
        TextView Mau_sac;
        TextView gia_ban;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ten_xe = itemView.findViewById(R.id.ten_xe);
            Mau_sac = itemView.findViewById(R.id.Mau_sac);
            gia_ban = itemView.findViewById(R.id.gia_ban);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
