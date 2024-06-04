package com.apsolete.splitthebill.ui.company;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apsolete.splitthebill.R;

public class MateViewHolder extends RecyclerView.ViewHolder {
    private final TextView mMateNameView;

    public MateViewHolder(@NonNull View itemView) {
        super(itemView);
        mMateNameView = itemView.findViewById(R.id.mate_name);
    }

    public void bind(String text) {
        mMateNameView.setText(text);
    }

    static MateViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_mate, parent, false);
        return new MateViewHolder(view);
    }
}

