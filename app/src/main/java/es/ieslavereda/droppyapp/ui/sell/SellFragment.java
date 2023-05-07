package es.ieslavereda.droppyapp.ui.sell;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseError;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.ieslavereda.droppyapp.Adapter.MyFotoAdapter;
import es.ieslavereda.droppyapp.DB.DBController;
import es.ieslavereda.droppyapp.Model.Brand;
import es.ieslavereda.droppyapp.Model.Category;
import es.ieslavereda.droppyapp.Model.Cloth;
import es.ieslavereda.droppyapp.Model.Interface.OnGetAllBrands;
import es.ieslavereda.droppyapp.Model.Interface.OnGetAllCategories;
import es.ieslavereda.droppyapp.Model.Interface.OnGetCategory;
import es.ieslavereda.droppyapp.Model.Photo;
import es.ieslavereda.droppyapp.Model.Size;
import es.ieslavereda.droppyapp.R;
import es.ieslavereda.droppyapp.databinding.FragmentSellBinding;

public class SellFragment extends Fragment {
    private FragmentSellBinding binding;
    private TextInputEditText searchMarcaDialog;
    private TextView marca, categoria, estado, size;

    private TextInputEditText title, description, price;
    private RecyclerView imagenesSeleccionadas;
    private Button addPhoto, addCloth;
    private ListView listViewDialog;
    List<String>  estados;
    List<Brand> marcas;
    List<Category> categorias;

    List<Photo> imagenes;
    List<Size> sizes;
    Dialog dialog;

    private ActivityResultLauncher<String> galleryLauncher;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentSellBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        marca = root.findViewById(R.id.marcaSellCloth);
        categoria = root.findViewById(R.id.categoriaSellCloth);
        estado = root.findViewById(R.id.estadoSellCloth);
        size = root.findViewById(R.id.sizeList);
        title = root.findViewById(R.id.tituloSellCloth);
        description = root.findViewById(R.id.descripcionSellCloth);
        price = root.findViewById(R.id.priceSellCloth);
        addPhoto = root.findViewById(R.id.addPhoto);
        addCloth = root.findViewById(R.id.addCloth);
        imagenes = new ArrayList<>();
        imagenesSeleccionadas = root.findViewById(R.id.imagenesSeleccionadas);
        imagenesSeleccionadas.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        MyFotoAdapter adapter = new MyFotoAdapter(imagenes,getContext());
        imagenesSeleccionadas.setAdapter(adapter);
        final Category[] c = new Category[1];
        Brand b;
        Size s;


        if (imagenes.isEmpty()){
            imagenesSeleccionadas.setVisibility(View.GONE);
        } else {
            imagenesSeleccionadas.setVisibility(View.VISIBLE);
        }

        loadAll();

        galleryLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onActivityResult(Uri result) {
                        if (result != null) {
                            // Haz lo que necesites con la imagen seleccionada, por ejemplo, muestra la imagen en un ImageView
                            //ImageView imageView = getActivity().findViewById(R.id.imageProduct);
                            //imageView.setImageURI(result);
                            imagenes.add(new Photo(result));
                            imagenesSeleccionadas.setVisibility(View.VISIBLE);
                            adapter.notifyDataSetChanged();
                        }
                    }
                });


        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                galleryLauncher.launch("image/");
            }
        });



        marca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(root.getContext());
                dialog.setContentView(R.layout.dialog_searchable_spinner);
                //Asignar altura y anchura
                dialog.getWindow().setLayout(800,1200);
                //Asignar transparencia fondo
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                //Asignar variables
                searchMarcaDialog = dialog.findViewById(R.id.searchDialogCloth);
                listViewDialog = dialog.findViewById(R.id.listMarcasDialog);
                //Asignar adaptador + crealo
                ArrayAdapter<Brand> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, marcas);
                listViewDialog.setAdapter(adapter);

                searchMarcaDialog.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                listViewDialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        marca.setText(adapter.getItem(i).toString());
                        dialog.dismiss();
                    }
                });

            }
        });

        estado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog = new Dialog(root.getContext());
                dialog.setContentView(R.layout.dialog_searchable_spinner);
                //Asignar altura y anchura
                dialog.getWindow().setLayout(800,1200);
                //Asignar transparencia fondo
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                //Asignar variables
                searchMarcaDialog = dialog.findViewById(R.id.searchDialogCloth);
                listViewDialog = dialog.findViewById(R.id.listMarcasDialog);
                //Asignar adaptador + crealo
                ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, estados);
                listViewDialog.setAdapter(adapter);

                searchMarcaDialog.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                listViewDialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        estado.setText(adapter.getItem(i));
                        dialog.dismiss();
                    }
                });
            }
        });

        categoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(root.getContext());
                dialog.setContentView(R.layout.dialog_searchable_spinner);
                //Asignar altura y anchura
                dialog.getWindow().setLayout(800,1200);
                //Asignar transparencia fondo
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                //Asignar variables
                searchMarcaDialog = dialog.findViewById(R.id.searchDialogCloth);
                listViewDialog = dialog.findViewById(R.id.listMarcasDialog);
                //Asignar adaptador + crealo
                ArrayAdapter<Category> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, categorias);
                listViewDialog.setAdapter(adapter);

                searchMarcaDialog.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                listViewDialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        categoria.setText(adapter.getItem(i).toString());
                        dialog.dismiss();
                    }
                });
            }
        });

        size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog = new Dialog(root.getContext());
                dialog.setContentView(R.layout.dialog_searchable_spinner);
                //Asignar altura y anchura
                dialog.getWindow().setLayout(800,1200);
                //Asignar transparencia fondo
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
                //Asignar variables
                searchMarcaDialog = dialog.findViewById(R.id.searchDialogCloth);
                listViewDialog = dialog.findViewById(R.id.listMarcasDialog);
                //Asignar adaptador + crealo
                ArrayAdapter<Size> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, sizes);
                listViewDialog.setAdapter(adapter);

                searchMarcaDialog.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        adapter.getFilter().filter(charSequence);
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                });

                listViewDialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        size.setText(adapter.getItem(i).toString());
                        dialog.dismiss();
                    }
                });
            }
        });

        addCloth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(title.getText())){
                    Toast.makeText(getContext(), "Añade un titulo al producto", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(description.getText())){
                    Toast.makeText(getContext(), "Añade una descripción", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(marca.getText())){
                    Toast.makeText(getContext(), "Selecciona una marca", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(categoria.getText())){
                    Toast.makeText(getContext(), "Selecciona una categoria", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(estado.getText())){
                    Toast.makeText(getContext(), "Selecciona un estado", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(size.getText())){
                    Toast.makeText(getContext(), "Selecciona una talla", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(price.getText())){
                    Toast.makeText(getContext(), "Añade un precio", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (imagenes.isEmpty()){
                    Toast.makeText(getContext(), "Selecciona almenos 1 imagen", Toast.LENGTH_SHORT).show();
                    return;
                }

                DBController.getInstance().getCategory(categoria.getText().toString(), new OnGetCategory() {
                    @Override
                    public void onGetCategoryObject(Category category) {
                        c[0] = category;
                    }

                    @Override
                    public void onErrorGetCategory(DatabaseError databaseError) {

                    }
                });

                DBController.getInstance().createNewCloth(new Cloth(title.getText().toString(),Double.parseDouble(price.getText().toString()),size.getText(),imagenes,description.getText().toString(),"1",categoria.getText(),marca.getText(),estado.getText()));
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void loadMarcas(){
        marcas = new ArrayList<>();
        DBController.getInstance().getAllBrands(new OnGetAllBrands() {
            @Override
            public void onGetBrands(List<Brand> brands) {
                marcas.addAll(brands);
            }

            @Override
            public void onErrorGetBrands(DatabaseError databaseError) {
                Log.e("Firebase", "Error al obtener las marcas", databaseError.toException());
            }
        });
    }

    private void loadEstados(){
        estados = new ArrayList<>();
        estados.add("Nuevo con etiquetas");
        estados.add("Nuevo sin etiquetas");
        estados.add("Muy Bueno");
        estados.add("Bueno");
        estados.add("Satisfactorio");
    }

    private void loadCategorias(){
        categorias = new ArrayList<>();
        DBController.getInstance().getAllCategories(new OnGetAllCategories() {
            @Override
            public void onGetCategories(List<Category> categories) {
                categorias.addAll(categories);
            }

            @Override
            public void onErrorGetCategories(DatabaseError databaseError) {
                Log.e("Firebase", "Error al obtener las categorias", databaseError.toException());
            }
        });
    }

    private void loadSizes(){
        sizes = new ArrayList<>();
        sizes.add(Size.XS);
        sizes.add(Size.S);
        sizes.add(Size.M);
        sizes.add(Size.L);
        sizes.add(Size.XL);
        sizes.add(Size.XXL);
        sizes.add(Size.XXXL);
        sizes.add(Size.XXXXL);
        sizes.add(Size.XXXXXL);
    }

    private void loadAll(){
        loadCategorias();
        loadSizes();
        loadEstados();
        loadMarcas();
    }
}
