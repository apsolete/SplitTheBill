package com.apsolete.splitthebill.ui.party;

import androidx.core.view.MenuProvider;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.apsolete.splitthebill.R;
import com.apsolete.splitthebill.databinding.FragmentPartyBinding;

public class PartyEditFragment extends Fragment {

    private PartyEditViewModel mViewModel;
    private @NonNull FragmentPartyBinding binding;

    public static PartyEditFragment newInstance() {
        return new PartyEditFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(PartyEditViewModel.class);

        binding = FragmentPartyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.menu_party_edit, menu);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.menu_party_decline) {

                }
                else if (id == R.id.menu_party_accept) {

                }
                return false;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);

        return root;
    }
}