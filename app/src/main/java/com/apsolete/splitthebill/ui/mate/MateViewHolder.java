package com.apsolete.splitthebill.ui.mate;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apsolete.splitthebill.R;
import com.apsolete.splitthebill.entity.Mate;

public class MateViewHolder extends RecyclerView.ViewHolder {
    private final TextView mMateNameView;

    public MateViewHolder(@NonNull View view) {
        super(view);
        mMateNameView = view.findViewById(R.id.textMateName);
    }

    public void bind(Mate mate) {
        mMateNameView.setText(mate.name);
    }

    static MateViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_mates, parent, false);
        return new MateViewHolder(view);
    }
}
