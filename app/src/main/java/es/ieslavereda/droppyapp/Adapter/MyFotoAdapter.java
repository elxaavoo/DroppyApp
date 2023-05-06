package es.ieslavereda.droppyapp.Adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import es.ieslavereda.droppyapp.Model.Photo;
import es.ieslavereda.droppyapp.R;

public class MyFotoAdapter extends RecyclerView.Adapter<MyFotoAdapter.ViewHolder> {

    private List<Photo> fotos;
    private Context content;

    public MyFotoAdapter(List<Photo> fotos, Context content) {
        this.fotos = fotos;
        this.content = content;
    }

    @NonNull
    @Override
    public MyFotoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.images_sell_view,null,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyFotoAdapter.ViewHolder holder, int position) {
        holder.asignarDatos(fotos.get(position));
    }

    @Override
    public int getItemCount() {
        return fotos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imagenCartelera;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenCartelera = itemView.findViewById(R.id.imageViewImagenes);
        }

        public void asignarDatos(Photo foto) {
            imagenCartelera.setImageURI(foto.getImagen());

        }
    }
}
