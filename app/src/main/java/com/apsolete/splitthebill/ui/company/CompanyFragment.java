package com.apsolete.splitthebill.ui.company;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apsolete.splitthebill.R;
import com.apsolete.splitthebill.databinding.FragmentCompanyBinding;

public class CompanyFragment extends Fragment {

    private FragmentCompanyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CompanyViewModel companyViewModel =
                new ViewModelProvider(this).get(CompanyViewModel.class);

        binding = FragmentCompanyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView = root.findViewById(R.id.recyclerview);
        final MateListAdapter adapter = new MateListAdapter(new MateListAdapter.MateDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        companyViewModel.getAllMates().observe(this.getViewLifecycleOwner(), mates -> {
            adapter.submitList(mates);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}