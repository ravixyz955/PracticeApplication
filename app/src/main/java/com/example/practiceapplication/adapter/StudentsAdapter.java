package com.example.practiceapplication.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listener.ItemClickListener;
import com.example.practiceapplication.R;
import com.example.practiceapplication.models.Student;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentsVH> {
    private List<Student> students;
    private Context context;
    private ItemClickListener itemClickListener;

    public StudentsAdapter(Context context, List<Student> students, RecyclerView recyclerView) {
        this.context = context;
        this.students = students;
    }

    @NonNull
    @Override
    public StudentsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_student_item, parent, false);
//        DisplayMetrics displayMetrics = new DisplayMetrics();
//        ((MainActivity2) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) (width * 0.75);
        view.setLayoutParams(layoutParams);
        return new StudentsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsVH holder, int position) {
        Student student = students.get(position);
        holder.name.setText(student.getName());
        holder.village.setText(student.getVillage());
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class StudentsVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView name;
        TextView village;

        public StudentsVH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            village = itemView.findViewById(R.id.village);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onClick(getAbsoluteAdapterPosition());
            }
        }
    }
}
