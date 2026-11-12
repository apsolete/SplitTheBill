package com.apsolete.splitthebill.ui.mate;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apsolete.splitthebill.databinding.FragmentMatesBinding;

public class MatesFragment extends Fragment {

    private MatesViewModel viewModel;
    private FragmentMatesBinding binding;
    private MatesAdapter adapter;

    public static MatesFragment newInstance() {
        return new MatesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(MatesViewModel.class);

        binding = FragmentMatesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.butInsertNewMate.setEnabled(false);
        binding.butInsertNewMate.setOnClickListener(view -> {
            String newMateName = binding.editNewMateName.getText().toString();
            viewModel.saveMate(newMateName);
            binding.editNewMateName.setText("");
        });
        binding.editNewMateName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Проверяем, что строка не пустая (trim() отсекает случайные пробелы)
                String input = s.toString().trim();
                binding.butInsertNewMate.setEnabled(!input.isEmpty());
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        adapter = new MatesAdapter();

        RecyclerView recyclerView = binding.recyclerMates;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.getAllMates().observe(this.getViewLifecycleOwner(), adapter::submitList);
    }
}