package com.example.putiton;

import static clases.Catalogo.catalogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import basededatos.AdminSQLiteOpenHelper;
import clases.Producto;
import clases.ProductosLista;

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

    public ArrayList<Producto> productosAlCarrito(){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        ArrayList<Producto> productosCarrito = new ArrayList<Producto>();

        String selectQuery = "SELECT * FROM productos";
        try{
            Cursor cursor = db.rawQuery(selectQuery, null);
            try {
                if(cursor.moveToFirst()){
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
            } finally {
                try { cursor.close(); } catch (Exception ignore) {}
            }

        } finally {
            try { db.close(); } catch (Exception ignore) {}
        }
        return productosCarrito;
    }

    public void goToCarrito(View view){
        Intent i = new Intent(this, Carrito.class);
        ArrayList<Producto> productos = productosAlCarrito();
        i.putExtra("productos", productos);
        startActivity(i);
    }

}