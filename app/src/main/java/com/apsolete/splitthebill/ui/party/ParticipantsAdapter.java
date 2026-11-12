package com.apsolete.splitthebill.ui.party;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.apsolete.splitthebill.entity.Mate;

public class ParticipantsAdapter extends ListAdapter<Mate, ParticipantViewHolder> {
    public ParticipantsAdapter() {
        super(new MateDiff());
    }

    @NonNull
    @Override
    public ParticipantViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return ParticipantViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull ParticipantViewHolder holder, int position) {
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
