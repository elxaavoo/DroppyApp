package es.ieslavereda.droppyapp.Model;

import android.net.Uri;

import es.ieslavereda.droppyapp.Utils.Generator;

public class Photo {
    private String id;
    private Uri imagen;

    public Photo(Uri imagen) {
        this.id = Generator.generatePhotoId();
        this.imagen = imagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Uri getImagen() {
        return imagen;
    }

    public void setImagen(Uri imagen) {
        this.imagen = imagen;
    }
}
