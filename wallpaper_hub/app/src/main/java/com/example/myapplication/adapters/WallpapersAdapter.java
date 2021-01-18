package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.models.Category;
import com.example.myapplication.models.Wallpaper;

import java.util.List;

public class WallpapersAdapter extends RecyclerView.Adapter<WallpapersAdapter.CategoryViewHolder> {

    private Context mCtx;
    private List<Wallpaper> wallpaperList;

    public WallpapersAdapter(Context mCtx, List<Wallpaper> wallpaperList) {
        this.mCtx = mCtx;
        this.wallpaperList = wallpaperList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_wallpapers, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Wallpaper wallpaper = wallpaperList.get(position);
        holder.textView.setText(wallpaper.title);
        Glide.with(mCtx)
                .load(wallpaper.url)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return wallpaperList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_view_title);
            imageView = itemView.findViewById(R.id.image_view);
        }
    }
}
