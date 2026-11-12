package com.apsolete.splitthebill.ui.mate;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.apsolete.splitthebill.entity.Mate;

public class MatesAdapter extends ListAdapter<Mate, MateViewHolder> {
    public MatesAdapter() {
        super(new MatesAdapter.MateDiff());
    }

    @NonNull
    @Override
    public MateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MateViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MateViewHolder holder, int position) {
        Mate mate = getItem(position);
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
