package com.apsolete.splitthebill.ui.company;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.apsolete.splitthebill.entity.Mate;

public class MateListAdapter extends ListAdapter<Mate, MateViewHolder> {
    protected MateListAdapter(@NonNull DiffUtil.ItemCallback<Mate> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public MateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MateViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull MateViewHolder holder, int position) {
        Mate current = getItem(position);
        holder.bind(current.name);
    }

    static class MateDiff extends DiffUtil.ItemCallback<Mate> {

        @Override
        public boolean areItemsTheSame(@NonNull Mate oldItem, @NonNull Mate newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Mate oldItem, @NonNull Mate newItem) {
            return oldItem.name.equals(newItem.name);
        }
    }
}
