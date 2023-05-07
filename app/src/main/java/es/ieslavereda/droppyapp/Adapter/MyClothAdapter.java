package es.ieslavereda.droppyapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import es.ieslavereda.droppyapp.Model.Cloth;
import es.ieslavereda.droppyapp.R;

public class MyClothAdapter extends RecyclerView.Adapter<MyClothAdapter.ViewHolder> {

    private List<Cloth> cloths;
    private Context content;

    public MyClothAdapter(List<Cloth> cloths, Context content) {
        this.cloths = cloths;
        this.content = content;
    }

    @NonNull
    @Override
    public MyClothAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.images_sell_view,null,false);
        return new MyClothAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyClothAdapter.ViewHolder holder, int position) {
        holder.asignarDatos(cloths.get(position));
    }

    @Override
    public int getItemCount() {
        return cloths.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageCloth;
        TextView price, nameCloth;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageCloth = itemView.findViewById(R.id.imageClothListView);
            price = itemView.findViewById(R.id.priceClothListView);
            nameCloth = itemView.findViewById(R.id.nameClothListView);
        }

        @SuppressLint("SetTextI18n")
        public void asignarDatos(Cloth cloth) {
            imageCloth.setImageURI(cloth.getImages().get(0).getImagen());
            price.setText(cloth.getPrice() + " €");
            nameCloth.setText(cloth.getName());
        }
    }
}
