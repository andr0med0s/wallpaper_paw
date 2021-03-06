package com.example.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

import java.util.List;

import com.example.myapplication.activities.WallpapersActivity;
import com.example.myapplication.models.Category;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {

    private Context mCtx;
    private List<Category> categoryList;

    public CategoriesAdapter(Context mCtx, List<Category> categoryList) {
        this.mCtx = mCtx;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_categories, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.textView.setText(category.name);
        Glide.with(mCtx)
                .load(category.thumb)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textView;
        ImageView imageView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_view_cat_name);
            imageView = itemView.findViewById(R.id.image_view);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int p = getBindingAdapterPosition();
            Category category = categoryList.get(p);

            Intent intent = new Intent(mCtx, WallpapersActivity.class);
            intent.putExtra("category", category.name);

            mCtx.startActivities(new Intent[]{intent});
        }
    }
}
