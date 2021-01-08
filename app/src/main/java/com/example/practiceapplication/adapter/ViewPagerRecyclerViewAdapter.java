package com.example.practiceapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.practiceapplication.R;

import java.util.List;

public class ViewPagerRecyclerViewAdapter extends RecyclerView.Adapter<ViewPagerRecyclerViewAdapter.ViewPagerViewHolder> {
    private ViewPager2 viewPager2;
    private List<String> mData;
    private Context mContext;

    private int[] colorArray = new int[]{
            android.R.color.black,
            android.R.color.holo_blue_dark,
            android.R.color.holo_green_dark,
            android.R.color.holo_red_dark
    };

    public ViewPagerRecyclerViewAdapter(Context context, List<String> data, ViewPager2 viewPager2) {
        this.mData = data;
        this.viewPager2 = viewPager2;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_viewpager, parent, false);
        return new ViewPagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        String animal = mData.get(position);
        holder.myTextView.setText(animal);
        holder.relativeLayout.setBackgroundResource(colorArray[position]);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewPagerViewHolder extends RecyclerView.ViewHolder {
        TextView myTextView;
        RelativeLayout relativeLayout;
        Button button;

        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.tvTitle);
            relativeLayout = itemView.findViewById(R.id.container);
            button = itemView.findViewById(R.id.btnToggle);

            button.setOnClickListener(v -> {
                if (viewPager2.getOrientation() == ViewPager2.ORIENTATION_VERTICAL)
                    viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
                else {
                    viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
                }
            });
        }
    }
}