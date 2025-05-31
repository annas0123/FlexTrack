package com.example.flextrack;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.DayViewHolder> {

    private List<Day> daysList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Day day);
    }

    public DaysAdapter(List<Day> daysList, OnItemClickListener listener) {
        this.daysList = daysList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public DayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day, parent, false);
        return new DayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DayViewHolder holder, int position) {
        Day day = daysList.get(position);
        holder.dayNumberTextView.setText(day.getDayNumber());
        holder.descriptionTextView.setText(day.getDescription());

        SharedPreferences sharedPreferences = holder.itemView.getContext().getSharedPreferences("DayCompletionStatus", Context.MODE_PRIVATE);
        boolean isCompleted = sharedPreferences.getBoolean(day.getDayNumber(), false);

        if (isCompleted) {
            holder.imageView.setVisibility(View.VISIBLE);
            holder.imageView.setImageResource(R.drawable.done); // Replace with your completed icon
        } else {
            holder.imageView.setVisibility(View.GONE);
        }

        if (day.isAvailable()) {
            holder.itemView.setAlpha(1.0f);
            holder.itemView.setOnClickListener(v -> listener.onItemClick(day));
        } else {
            holder.itemView.setAlpha(0.5f); // Make unavailable days dull
            holder.itemView.setOnClickListener(null); // Disable clicking
        }
    }

    @Override
    public int getItemCount() {
        return daysList.size();
    }

    public static class DayViewHolder extends RecyclerView.ViewHolder {
        private TextView dayNumberTextView;
        private TextView descriptionTextView;
        private ImageView imageView;

        public DayViewHolder(@NonNull View itemView) {
            super(itemView);
            dayNumberTextView = itemView.findViewById(R.id.text_day_number);
            descriptionTextView = itemView.findViewById(R.id.text_minutes);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
