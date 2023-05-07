package es.ieslavereda.droppyapp.Model.Interface;

import com.google.firebase.database.DatabaseError;

import es.ieslavereda.droppyapp.Model.Category;

public interface OnGetCategory {
    void onGetCategoryObject(Category category);
    void onErrorGetCategory(DatabaseError databaseError);
}
