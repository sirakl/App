package com.example.myapplication4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication4.entity.Person;
import com.example.myapplication4.entity.Student;
import com.example.myapplication4.entity.Teacher;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Person> dataList;
    public interface OnItemRemoveClickListener {
        void onItemRemoveClick(long id);
    }
    private OnItemRemoveClickListener removeClickListener;
    public MyAdapter(List<Person> dataList,OnItemRemoveClickListener removeClickListener) {
        this.dataList = dataList;
        this.removeClickListener=removeClickListener;

    }

    public void setDataList(List<Person> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.style, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Person person = dataList.get(position);
        holder.nameTextView.setText(person.firstName);
        if (person instanceof Student) {
            holder.ageTextView.setText(String.valueOf(((Student) person).grade));
        } else if (person instanceof Teacher) {
            holder.ageTextView.setText(((Teacher) person).specialty);
        }

        holder.removeButton.setOnClickListener(v -> {
            if (removeClickListener != null) {
                removeClickListener.onItemRemoveClick(person.id);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView ageTextView;
        Button removeButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            ageTextView = itemView.findViewById(R.id.ageTextView);
            removeButton = itemView.findViewById(R.id.removeButton);
        }
    }
}
