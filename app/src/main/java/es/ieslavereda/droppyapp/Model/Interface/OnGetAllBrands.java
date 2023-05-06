package es.ieslavereda.droppyapp.Model.Interface;

import com.google.firebase.database.DatabaseError;

import java.util.List;

import es.ieslavereda.droppyapp.Model.Brand;

public interface OnGetAllBrands {

    void onGetBrands(List<Brand> brands);
    void onErrorGetBrands(DatabaseError databaseError);

}
