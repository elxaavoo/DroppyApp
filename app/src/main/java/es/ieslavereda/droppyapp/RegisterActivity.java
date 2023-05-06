package es.ieslavereda.droppyapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import es.ieslavereda.droppyapp.DB.DB;
import es.ieslavereda.droppyapp.DB.DBController;
import es.ieslavereda.droppyapp.Model.Interface.OnUserExistsListener;
import es.ieslavereda.droppyapp.Model.Type;
import es.ieslavereda.droppyapp.Model.User;


public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private Button register;
    private TextInputEditText name, lastname, email, pass, confirmPass;
    private TextView haveAccount;

//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = auth.getCurrentUser();
//        if (currentUser != null){
//            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
//            startActivity(intent);
//            finish();
//        }
//    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = findViewById(R.id.registerButton);
        name = findViewById(R.id.nameRegister);
        lastname = findViewById(R.id.lastnameRegister);
        email = findViewById(R.id.emailRegister);
        pass = findViewById(R.id.passRegister);
        confirmPass = findViewById(R.id.passConfirmRegister);
        haveAccount = findViewById(R.id.haveAccount);

        auth = FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(name.getText())){
                    Toast.makeText(RegisterActivity.this, "Indica el nombre", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(lastname.getText())){
                    Toast.makeText(RegisterActivity.this, "Indica el apellido", Toast.LENGTH_SHORT).show();
                    return;
                }
                String completeName = name.getText() + " " + lastname.getText();
                if (TextUtils.isEmpty(email.getText())){
                    Toast.makeText(RegisterActivity.this, "Indica el correo", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass.getText())){
                    Toast.makeText(RegisterActivity.this, "Indica la contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmPass.getText())){
                    Toast.makeText(RegisterActivity.this, "Indica la confirmación de la contraseña", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!pass.getText().toString().equals(confirmPass.getText().toString())){
                    Toast.makeText(RegisterActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    return;
                }

                auth.createUserWithEmailAndPassword(email.getText().toString(), pass.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            FirebaseUser user = auth.getCurrentUser();
                            User newUser = new User(completeName, email.getText().toString(), pass.getText().toString(), "","","", Type.REGULAR,"",0);
                            DBController.getInstance().comproveUserExists(newUser, new OnUserExistsListener() {
                                @Override
                                public void onUserExists(boolean exists) {
                                    if (!exists){
                                        if (DBController.getInstance().createNewUser(newUser)){
                                            Toast.makeText(RegisterActivity.this, "Account Created.", Toast.LENGTH_SHORT).show();
                                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(RegisterActivity.this, "Error created account.", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {
                                        Toast.makeText(RegisterActivity.this, "El usuario ya existe", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        } else {
                            Toast.makeText(RegisterActivity.this, "Correo en uso, cambielo", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        haveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}