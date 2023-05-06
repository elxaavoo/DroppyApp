package es.ieslavereda.droppyapp.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import es.ieslavereda.droppyapp.MyAccountActivity;
import es.ieslavereda.droppyapp.MyBuysActivity;
import es.ieslavereda.droppyapp.MyClothesActivity;
import es.ieslavereda.droppyapp.MyOutfitsActivity;
import es.ieslavereda.droppyapp.R;
import es.ieslavereda.droppyapp.databinding.FragmentAccountBinding;


public class AccountFragment extends Fragment {

    private LinearLayout perfil;
    private TextView compras, prendas, outfits, darkmode;

    private LinearLayout account;
    private FragmentAccountBinding binding;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentAccountBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        compras = root.findViewById(R.id.viewMyBuys);
        prendas = root.findViewById(R.id.viewMyClothes);
        outfits = root.findViewById(R.id.viewMyOutfits);
        account = root.findViewById(R.id.perfilUserAccount);

        compras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyBuysActivity.class);
                startActivity(intent);
            }
        });

        prendas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyClothesActivity.class);
                startActivity(intent);
            }
        });

        outfits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyOutfitsActivity.class);
                startActivity(intent);
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyAccountActivity.class);
                startActivity(intent);
            }
        });



        return root;
    }
}
