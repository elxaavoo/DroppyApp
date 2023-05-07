package es.ieslavereda.droppyapp.Model.Interface;

import com.google.firebase.database.DatabaseError;

import java.util.List;

import es.ieslavereda.droppyapp.Model.Category;

public interface OnGetAllCategories {
    void onGetCategories(List<Category> categories);
    void onErrorGetCategories(DatabaseError databaseError);
}
