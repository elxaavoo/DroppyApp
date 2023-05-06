package es.ieslavereda.droppyapp.DB;

import com.google.firebase.database.FirebaseDatabase;

public class DB {

    private static DB db = new DB();

    public static DB getInstance() {
        return db;
    }

    public FirebaseDatabase getDB(){
        return FirebaseDatabase.getInstance();
    }
}