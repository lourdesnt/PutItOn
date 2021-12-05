package com.example.putiton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import basededatos.AdminSQLiteOpenHelper;
import clases.Catalogo;
import clases.Producto;
import clases.ProductosLista;

public class Carrito extends AppCompatActivity {

    LinearLayout listaCarrito;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        listaCarrito = findViewById(R.id.listaCarrito);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listaCarrito.removeAllViews();
        List<Producto> productosCarrito = findAll();
        for (Producto p : productosCarrito) {
                ProductoCarrito pc = ProductoCarrito.newInstance(p);
                FrameLayout fr = new FrameLayout(this);
                fr.setId(productosCarrito.indexOf(p));
                getFragmentManager().beginTransaction().add(fr.getId(), pc).commit();
                listaCarrito.addView(fr);
        }
    }

    public void goToMenu(View view){
        finish();
    }

    public ArrayList<Producto> findAll() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        ArrayList<Producto> productosCarrito = new ArrayList<Producto>();

        String selectQuery = "SELECT * FROM productos";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Producto p = new Producto();
                p.setReferencia(cursor.getInt(0));
                p.setNombre(cursor.getString(1));
                p.setPrecio(cursor.getDouble(2));
                p.setTalla(cursor.getString(3));
                p.setCantidad(cursor.getInt(4));
                productosCarrito.add(p);
            } while (cursor.moveToNext());
        }

        return productosCarrito;
    }
}