package com.example.evervital;

import static androidx.recyclerview.widget.RecyclerView.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FeelAdapter extends RecyclerView.Adapter<FeelAdapter.FeelingViewHolder> {
    private final List<feelings> feelingsList;

    public FeelAdapter(List<feelings> feelingsList){
        this.feelingsList = feelingsList;
    }

    @NonNull
    @Override
    public FeelAdapter.FeelingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feelinglist, parent, false);
        return new FeelingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FeelAdapter.FeelingViewHolder holder, int position) {
        feelings feeling = feelingsList.get(position);
        holder.dateTextView.setText(feeling.getDate());
        holder.statusTextView.setText(feeling.getStatus());
        holder.descriptionTextView.setText(feeling.getDescription());
    }

    @Override
    public int getItemCount() {
        return feelingsList.size();
    }


    public static class FeelingViewHolder extends ViewHolder {

        TextView dateTextView, statusTextView, descriptionTextView;
        public FeelingViewHolder(@NonNull View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.date);
            statusTextView = itemView.findViewById(R.id.status);
            descriptionTextView = itemView.findViewById(R.id.description);
        }
    }
}
