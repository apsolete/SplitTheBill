package com.apsolete.splitthebill.ui.mate;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.apsolete.splitthebill.R;
import com.apsolete.splitthebill.databinding.FragmentMateBinding;

public class MateFragment extends Fragment {

    private MateViewModel mViewModel;

    public static MateFragment newInstance() {
        return new MateFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(MateViewModel.class);

        FragmentMateBinding binding = FragmentMateBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        root.findViewById(R.id.butSave).setOnClickListener(v -> {
            EditText editMateName = root.findViewById(R.id.editMateName);
            String newMateName = editMateName.getText().toString();
            mViewModel.saveMate(newMateName);

            NavHostFragment.findNavController(MateFragment.this).navigateUp();
        });
        root.findViewById(R.id.butCancel).setOnClickListener(view -> {
            NavHostFragment.findNavController(MateFragment.this).navigateUp();
        });

        return root;
    }
}