package com.apsolete.splitthebill.ui.split;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.apsolete.splitthebill.databinding.FragmentSplitBinding;

public class SplitFragment extends Fragment {

    private FragmentSplitBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SplitViewModel notificationsViewModel =
                new ViewModelProvider(this).get(SplitViewModel.class);

        binding = FragmentSplitBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}