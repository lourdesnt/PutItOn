package com.example.putiton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

import java.util.ArrayList;

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
        spec.setIndicator("Mujer");
        tab_apartados.addTab(spec);

        spec = tab_apartados.newTabSpec("Hombre");
        spec.setContent(R.id.hombre);
        spec.setIndicator("Hombre");
        tab_apartados.addTab(spec);

    }

    public void goToCarrito(View view) {
        Intent i = new Intent(this, Carrito.class);
        startActivity(i);
    }

}