package com.apsolete.splitthebill.ui.company;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.apsolete.splitthebill.R;
import com.apsolete.splitthebill.databinding.FragmentMateBinding;
import com.apsolete.splitthebill.entity.Mate;

import java.util.concurrent.Executors;

public class MateFragment extends Fragment {

    public static final String REQUEST_KEY = "mate_request_key";
    public static final String BUNDLE_KEY = "mate_payload";

    private MateViewModel mViewModel;
    private FragmentMateBinding binding;

    public static MateFragment newInstance() {
        return new MateFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel = new ViewModelProvider(this).get(MateViewModel.class);

        binding = FragmentMateBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        root.findViewById(R.id.butSave).setOnClickListener(v -> {
            EditText editMateName = root.findViewById(R.id.editMateName);
            String newMateName = editMateName.getText().toString();
            mViewModel.saveMate(newMateName);

            NavHostFragment.findNavController(MateFragment.this).navigateUp();
        });

        return root;
    }
}