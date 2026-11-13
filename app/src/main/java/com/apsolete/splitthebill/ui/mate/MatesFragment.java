package com.apsolete.splitthebill.ui.mate;

import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.apsolete.splitthebill.R;
import com.apsolete.splitthebill.databinding.FragmentMatesBinding;

public class MatesFragment extends Fragment {

    private MatesViewModel viewModel;
    private FragmentMatesBinding binding;
    private MatesAdapter adapter;

    //public static MatesFragment newInstance() {
    //    return new MatesFragment();
    //}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(MatesViewModel.class);

        binding = FragmentMatesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.menu_mates, menu);
            }
            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                NavHostFragment.findNavController(MatesFragment.this).navigateUp();
                return false;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);

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