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
import com.apsolete.splitthebill.dao.Converters;
import com.apsolete.splitthebill.databinding.FragmentPartyEditBinding;
import com.apsolete.splitthebill.entity.Party;

import java.time.Instant;
import java.time.ZonedDateTime;

public class PartyEditFragment extends Fragment {

    private PartyEditViewModel viewModel;
    private FragmentPartyEditBinding binding;
    private Party currentParty;

    public static PartyEditFragment newInstance() {
        return new PartyEditFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(PartyEditViewModel.class);

        binding = FragmentPartyEditBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.menu_party_edit, menu);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.menu_party_edit_decline) {
                    NavHostFragment.findNavController(PartyEditFragment.this).navigateUp();
                }
                else if (id == R.id.menu_party_edit_accept) {
                    boolean create = currentParty == null;
                    if (create) {
                        currentParty = new Party();
                    }
                    currentParty.title = binding.editTitle.getText().toString();
                    currentParty.where = binding.editWhere.getText().toString();
                    String date = binding.editWhenDate.getText().toString();
                    String time = binding.editWhenTime.getText().toString();
                    currentParty.when = Converters.parseToInstant(date, time);
                    if (create)
                        viewModel.insertParty(currentParty);
                    else
                        viewModel.saveParty(currentParty);

                    NavHostFragment.findNavController(PartyEditFragment.this).navigateUp();
                }
                return false;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.getParty().observe(this.getViewLifecycleOwner(), this::showParty);
    }

    private void showParty(Party party) {
        if (party == null) return;
        currentParty = party;
        binding.editTitle.setText(party.title);
        binding.editWhere.setText(party.where);
        binding.editWhenDate.setText(Converters.toDateString(party.when));
        binding.editWhenTime.setText(Converters.toTimeString(party.when));
    }
}