package com.example.putiton;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
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
    AdminSQLiteOpenHelper adminUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        et_correo = (EditText) findViewById(R.id.et_correo);
        et_usuario2 = (EditText) findViewById(R.id.et_usuario2);
        et_contrasena2 = (EditText) findViewById(R.id.et_contrasena2);

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
                return;
            }
            Toast.makeText(this, "Esta cuenta ya existe", Toast.LENGTH_SHORT).show();
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