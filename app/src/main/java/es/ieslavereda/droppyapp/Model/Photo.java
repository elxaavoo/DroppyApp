package es.ieslavereda.droppyapp.Model;

import android.net.Uri;

public class Photo {
    private int id;
    private Uri imagen;

    public Photo(Uri imagen) {
        this.id = id;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Uri getImagen() {
        return imagen;
    }

    public void setImagen(Uri imagen) {
        this.imagen = imagen;
    }
}
