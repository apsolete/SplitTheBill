package com.apsolete.splitthebill.ui.split;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;

import com.apsolete.splitthebill.R;
import com.apsolete.splitthebill.databinding.FragmentSplitBinding;

public class SplitFragment extends Fragment {

    private FragmentSplitBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SplitViewModel notificationsViewModel =
                new ViewModelProvider(this).get(SplitViewModel.class);

        binding = FragmentSplitBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.split_menu, menu);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                if (id == R.id.recalculate_item) {

                }
                return false;
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);

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