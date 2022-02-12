package com.example.putiton;

import static clases.Catalogo.catalogo;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import basededatos.AdminSQLiteOpenHelper;
import clases.Catalogo;
import clases.Producto;
import clases.ProductosLista;

public class Carrito extends AppCompatActivity {

    LinearLayout listaCarrito;
    Button btn_comprar;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        listaCarrito = findViewById(R.id.listaCarrito);
        btn_comprar = (Button) findViewById(R.id.btn_comprar);


    }

    @Override
    protected void onResume() {
        super.onResume();
        listaCarrito.removeAllViews();
        List<Producto> productosCarrito = findAll(this);
        if(findAll(this).isEmpty()){
            btn_comprar.setEnabled(false);
        }
        for (Producto p : productosCarrito) {
                ProductoCarrito pc = ProductoCarrito.newInstance(p);
                FrameLayout fr = new FrameLayout(this);
                fr.setId(productosCarrito.indexOf(p)+1);
                getFragmentManager().beginTransaction().add(fr.getId(), pc).commit();
                listaCarrito.addView(fr);
        }
    }

    public void goToMenu(View view){
        finish();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void goToConfirmar(View view){
        Intent i = new Intent(view.getContext(), FormularioCompra.class);
        List<Producto> compra = findAll(view.getContext());
        i.putExtra("compra", new ProductosLista(compra));
        startActivity(i);
    }

    public static ArrayList<Producto> findAll(Context context) {
        AdminSQLiteOpenHelper admin = AdminSQLiteOpenHelper.getInstance(context);
        SQLiteDatabase db = admin.getWritableDatabase();

        ArrayList<Producto> productosCarrito = new ArrayList<Producto>();

        String selectQuery = "SELECT * FROM productos";
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Producto p = new Producto();
                p.setReferencia(cursor.getInt(0));
                p.setNombre(cursor.getString(1));
                p.setName(cursor.getString(2));
                p.setPrecio(cursor.getDouble(3));
                p.setTalla(cursor.getString(4));
                p.setCantidad(cursor.getInt(5));
                productosCarrito.add(p);
            } while (cursor.moveToNext());
        }

        return productosCarrito;
    }

}