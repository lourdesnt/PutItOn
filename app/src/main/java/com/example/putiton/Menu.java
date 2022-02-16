package com.example.putiton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import basededatos.AdminSQLiteOpenHelper;
import clases.Producto;

public class Menu extends AppCompatActivity {

    private TabHost tab_apartados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        tab_apartados = (TabHost) findViewById(R.id.tab_apartados);

        tab_apartados.setup();

        TabHost.TabSpec spec = tab_apartados.newTabSpec("Mujer");
        spec.setContent(R.id.mujer);
        if(Locale.getDefault().getLanguage().equals("en")) {
            spec.setIndicator("Woman");
        } else {
            spec.setIndicator("Mujer");
        }

        tab_apartados.addTab(spec);

        spec = tab_apartados.newTabSpec("Hombre");
        spec.setContent(R.id.hombre);
        if(Locale.getDefault().getLanguage().equals("en")) {
            spec.setIndicator("Man");
        } else {
            spec.setIndicator("Hombre");
        }
        tab_apartados.addTab(spec);

    }

    public void goToCarrito(View view) {
        Intent i = new Intent(this, Carrito.class);
        startActivity(i);
    }

    public void goToHome(View view){
        Intent i = new Intent(this, Home.class);
        startActivity(i);
    }
}