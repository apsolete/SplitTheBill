package com.apsolete.splitthebill.ui.company;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.apsolete.splitthebill.R;
import com.apsolete.splitthebill.entity.Mate;

public class MateListAdapter extends ListAdapter<Mate, MateViewHolder> {
    public MateListAdapter() {
        super(new MateDiff());
    }

    @NonNull
    @Override
    public MateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_mate, parent, false);
        return new MateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MateViewHolder holder, int position) {
        Mate mate = getItem(position);
        Log.d("MateListAdapter_DEBUG", "Mate: " + mate.name + " с ID: " + mate.id);
        holder.bind(mate);
    }

    static class MateDiff extends DiffUtil.ItemCallback<Mate> {

        @Override
        public boolean areItemsTheSame(@NonNull Mate oldItem, @NonNull Mate newItem) {
            return oldItem.id == newItem.id;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Mate oldItem, @NonNull Mate newItem) {
            return oldItem.name.equals(newItem.name);
        }
    }
}
