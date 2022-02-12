package com.example.putiton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import basededatos.AdminSQLiteOpenHelper;
import clases.Usuario;

public class AreaCliente extends AppCompatActivity {

    private EditText et_usuario;
    AdminSQLiteOpenHelper adminUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_cliente);

        et_usuario = (EditText) findViewById(R.id.et_usuario);
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
                return;
            }
            Toast.makeText(this, "Error al introducir los datos", Toast.LENGTH_SHORT).show();
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