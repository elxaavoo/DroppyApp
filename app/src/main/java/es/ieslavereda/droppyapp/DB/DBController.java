package es.ieslavereda.droppyapp.DB;

import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import es.ieslavereda.droppyapp.Model.Brand;
import es.ieslavereda.droppyapp.Model.Category;
import es.ieslavereda.droppyapp.Model.Interface.OnBrandExistsListener;
import es.ieslavereda.droppyapp.Model.Interface.OnCategoryExistsListener;
import es.ieslavereda.droppyapp.Model.Interface.OnGetAllBrands;
import es.ieslavereda.droppyapp.Model.Interface.OnUserExistsListener;
import es.ieslavereda.droppyapp.Model.User;
import es.ieslavereda.droppyapp.Utils.Generator;

public class DBController {

    private static FirebaseDatabase db;
    private static DBController instance = new DBController();
    public static DBController getInstance(){
        db = DB.getInstance().getDB();
        return instance;
    }

    public boolean createNewUser(User user){
        DatabaseReference dbRef = db.getReference("/Users");
        try{
            dbRef.push().setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        // La escritura se completó correctamente
                        Log.d("REGISTER: ", "Usuario agregado correctamente");
                    } else {
                        // La escritura no se completó correctamente
                        Log.e("ERROR REGISTER: ", "Error al agregar el usuario", task.getException());
                    }
                }
            });
            return true;
        } catch (Exception e){
            Log.e("ERROR","Error al registrar el usuario, ", e);
            return false;
        }

    }

    public void comproveUserExists(User user, final OnUserExistsListener listener){
        DatabaseReference dbRef = db.getReference("/Users");
        dbRef.orderByChild("email").equalTo(user.getEmail()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean exists = snapshot.exists();
                listener.onUserExists(exists);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                listener.onUserExists(false);
            }
        });

    }

    public void getAllBrands(OnGetAllBrands listener) {
        DatabaseReference dbRef = db.getReference("/Brands");

        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<Brand> brands = new ArrayList<>();
                for (DataSnapshot brandSnap : snapshot.getChildren()){
                    Brand brand = brandSnap.getValue(Brand.class);
                    brands.add(brand);
                }
                listener.onGetBrands(brands);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                listener.onErrorGetBrands(error);
            }
        });

    }

    public Task<String> addPhotoToFirebaseStorage(Uri uriFile, final OnSuccessListener<String> onSuccessListener, final OnFailureListener onFailureListener){
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference src = storage.getReference().child("/images");
        StorageReference fileRef = src.child(Generator.generateImageName());

        return fileRef.putFile(uriFile)
                .continueWithTask(task -> fileRef.getDownloadUrl())
                .addOnSuccessListener(uri -> {
                    String urlDowload = uri.toString();
                    Log.d("Firebase","URL de descarga es " + urlDowload);
                })
                .addOnFailureListener(e -> Log.e("Firebase","Error al subir archibo o obtener la URL de descarga",e))
                .continueWith(task -> {
                    if (task.isSuccessful()) {
                        return task.getResult().toString();
                    } else {
                        return null;
                    }
                });
    }


    public boolean createNewCategory(Category category){
        DatabaseReference dbRef = db.getReference("/Categories");
        try{
            dbRef.push().setValue(category).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        // La escritura se completó correctamente
                        Log.d("REGISTER: ", "Categoria agregado correctamente");
                    } else {
                        // La escritura no se completó correctamente
                        Log.e("ERROR REGISTER: ", "Error al agregar la categoria", task.getException());
                    }
                }
            });
            return true;
        } catch (Exception e){
            Log.e("ERROR","Error al crear la categoria", e);
            return false;
        }
    }

    public void comproveCategoryExists(Category category, final OnCategoryExistsListener listener){
        DatabaseReference dbRef = db.getReference("/Categories");
        dbRef.orderByChild("name").equalTo(category.getName()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean exists = snapshot.exists();
                listener.onCategoryExists(exists);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                listener.onCategoryExists(false);
            }
        });

    }

    public boolean createNewBrand(Brand brand){
        DatabaseReference dbRef = db.getReference("/Brands");
        try{
            dbRef.push().setValue(brand).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        // La escritura se completó correctamente
                        Log.d("REGISTER: ", "Marca agregada correctamente");
                    } else {
                        // La escritura no se completó correctamente
                        Log.e("ERROR REGISTER: ", "Error al agregar la marca", task.getException());
                    }
                }
            });
            return true;
        } catch (Exception e){
            Log.e("ERROR","Error al crear la marca", e);
            return false;
        }
    }

    public void comproveBrandExists(Brand brand, final OnBrandExistsListener listener){
        DatabaseReference dbRef = db.getReference("/Categories");
        dbRef.orderByChild("brandName").equalTo(brand.getBrandName()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean exists = snapshot.exists();
                listener.onBrandExists(exists);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                listener.onBrandExists(false);
            }
        });

    }




}
