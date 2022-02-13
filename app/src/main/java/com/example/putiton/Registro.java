package com.example.putiton;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

import basededatos.AdminSQLiteOpenHelper;
import clases.Producto;
import clases.Usuario;

public class Registro extends AppCompatActivity {

    private EditText et_correo;
    private EditText et_usuario2;
    private EditText et_contrasena2;
    private Button btn_registro;
    AdminSQLiteOpenHelper adminUser;
    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            // check Fields For Empty Values
            checkFieldsForEmptyValues();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_correo = (EditText) findViewById(R.id.et_correo);
        et_usuario2 = (EditText) findViewById(R.id.et_usuario2);
        et_contrasena2 = (EditText) findViewById(R.id.et_contrasena2);
        btn_registro = (Button) findViewById(R.id.btn_registro);

        et_usuario2.addTextChangedListener(mTextWatcher);
        et_correo.addTextChangedListener(mTextWatcher);
        et_contrasena2.addTextChangedListener(mTextWatcher);

        checkFieldsForEmptyValues();
    }

    public void checkFieldsForEmptyValues(){
        String s1 = et_usuario2.getText().toString();
        String s2 = et_correo.getText().toString();
        String s3 = et_contrasena2.getText().toString();

        if(s1.equals("")|| s2.equals("") || s3.equals("")){
            btn_registro.setEnabled(false);
        } else {
            btn_registro.setEnabled(true);
        }
    }

    public void goToHome(View view){
        Intent i = new Intent(this, Home.class);
        startActivity(i);
    }

    public void goToCarrito(View view){
        Intent i = new Intent(this, Carrito.class);
        startActivity(i);
    }

    public void goToMenu(View view){
        Intent i = new Intent(this, Menu.class);
        startActivity(i);
    }

    public void goToPerfil(View view){
        if(!findByUsername(et_usuario2.getText().toString())){
            registrar(view);
            Intent i = new Intent(this, Perfil.class);
            i.putExtra("nombreUsuario", et_usuario2.getText().toString());
            startActivity(i);
        } else {
            if(Locale.getDefault().getLanguage().equals("en")) {
                Toast.makeText(this, "This account already exists", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Esta cuenta ya existe", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean findByUsername(String username) {
        SQLiteDatabase db = adminUser.getInstance(this).getWritableDatabase();

        String selectQuery = "SELECT * FROM usuarios WHERE nombre = " + "'"+username+"'";
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if (cursor.getCount()>0) {
            return true;
        } else {
            return false;
        }
    }

    public void registrar(View view){
        SQLiteDatabase db = adminUser.getInstance(this).getWritableDatabase();
        String username = et_usuario2.getText().toString();
        String password = et_contrasena2.getText().toString();

        if(!username.isEmpty() && !password.isEmpty()){
            ContentValues registro = new ContentValues();

            registro.put("nombre", username);
            registro.put("contrasena", password);

            db.insert("usuarios", null, registro);

            db.close();
        }
    }

}