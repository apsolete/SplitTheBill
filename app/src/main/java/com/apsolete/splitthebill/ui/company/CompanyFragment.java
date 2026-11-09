package com.apsolete.splitthebill.ui.company;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apsolete.splitthebill.R;
import com.apsolete.splitthebill.databinding.FragmentCompanyBinding;

public class CompanyFragment extends Fragment {

    private FragmentCompanyBinding binding;
    private MateListAdapter adapter;
    private CompanyViewModel companyViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        companyViewModel =
                new ViewModelProvider(this).get(CompanyViewModel.class);

        binding = FragmentCompanyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.company_menu, menu);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.add_mate_item) {
                    NavHostFragment.findNavController(CompanyFragment.this).navigate(R.id.action_company_to_mate);
                }
                else if (id == R.id.add_party_item) {

                }
                return false;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);

        adapter = new MateListAdapter();
        companyViewModel.getAllMates().observe(this.getViewLifecycleOwner(), adapter::submitList);

        RecyclerView recyclerView = binding.recyclerview;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        adapter = null;
        companyViewModel = null;
    }
}