package com.apsolete.splitthebill.ui.party;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.apsolete.splitthebill.R;
import com.apsolete.splitthebill.dao.Converters;
import com.apsolete.splitthebill.databinding.FragmentPartyBinding;
import com.apsolete.splitthebill.entity.Party;

public class PartyFragment extends Fragment {

    private FragmentPartyBinding binding;
    private ParticipantsAdapter adapter;
    private PartyViewModel viewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(PartyViewModel.class);

        binding = FragmentPartyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.menu_party, menu);
            }
            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.menu_party_participants) {
                    NavHostFragment.findNavController(PartyFragment.this)
                            .navigate(R.id.navigation_action_party_to_mate);
                }
                else if (id == R.id.menu_party_edit) {
                    NavHostFragment.findNavController(PartyFragment.this)
                            .navigate(R.id.navigation_action_party_to_edit);
                }
                return false;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);

        adapter = new ParticipantsAdapter();

        RecyclerView recyclerView = binding.recyclerParticipants;
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.getAllMates().observe(this.getViewLifecycleOwner(), adapter::submitList);
        viewModel.getParty().observe(this.getViewLifecycleOwner(), this::showParty);
    }

    private void showParty(Party party) {
        if (party == null) {
            Toast.makeText(PartyFragment.this.getContext(), "Party is empty!",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        binding.textTitle.setText(party.title);
        binding.textWhere.setText(party.where);
        binding.textWhen.setText(Converters.toDateTimeString(party.when));
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
        adapter = null;
        viewModel = null;
    }
}