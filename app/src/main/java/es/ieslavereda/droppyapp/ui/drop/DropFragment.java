package es.ieslavereda.droppyapp.ui.drop;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.ieslavereda.droppyapp.databinding.FragmentDropBinding;

public class DropFragment extends Fragment {

    private FragmentDropBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DropViewModel dropViewModel =
                new ViewModelProvider(this).get(DropViewModel.class);

        binding = FragmentDropBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}