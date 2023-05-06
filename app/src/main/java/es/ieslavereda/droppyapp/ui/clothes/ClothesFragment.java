package es.ieslavereda.droppyapp.ui.clothes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import es.ieslavereda.droppyapp.databinding.FragmentClothesBinding;
import es.ieslavereda.droppyapp.databinding.FragmentThingsBinding;
import es.ieslavereda.droppyapp.ui.things.ThingsViewModel;

public class ClothesFragment extends Fragment {
    private FragmentClothesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ClothesViewModel clothesViewModel =
                new ViewModelProvider(this).get(ClothesViewModel.class);

        binding = FragmentClothesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}