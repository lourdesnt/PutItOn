package com.example.putiton;

import androidx.appcompat.app.AppCompatActivity;

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

import java.util.Locale;

import basededatos.AdminSQLiteOpenHelper;
import clases.Usuario;

public class AreaCliente extends AppCompatActivity {

    private EditText et_usuario;
    private EditText et_contrasena;
    private Button btn_entrar;
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
        setContentView(R.layout.activity_area_cliente);

        et_usuario = (EditText) findViewById(R.id.et_usuario);
        et_contrasena = (EditText) findViewById(R.id.et_contrasena);
        btn_entrar = (Button) findViewById(R.id.btn_entrar);

        et_usuario.addTextChangedListener(mTextWatcher);
        et_contrasena.addTextChangedListener(mTextWatcher);

        checkFieldsForEmptyValues();

    }

    public void checkFieldsForEmptyValues(){
        String s1 = et_usuario.getText().toString();
        String s2 = et_contrasena.getText().toString();

        if(s1.equals("")|| s2.equals("")){
            btn_entrar.setEnabled(false);
        } else {
            btn_entrar.setEnabled(true);
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
        if(findByUsername(et_usuario.getText().toString())){
            Intent i = new Intent(this, Perfil.class);
            i.putExtra("nombreUsuario", et_usuario.getText().toString());
            startActivity(i);
        } else {
            if(Locale.getDefault().getLanguage().equals("en")) {
                Toast.makeText(this, "Error introducing data", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Error al introducir los datos", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void goToRegistro(View view){
        Intent i = new Intent(this, Registro.class);
        startActivity(i);
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
}