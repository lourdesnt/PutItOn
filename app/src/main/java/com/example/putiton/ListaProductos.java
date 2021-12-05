package com.example.putiton;

import static clases.Catalogo.catalogo;
import static clases.Catalogo.getImageId;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import clases.Producto;
import clases.ProductosLista;

public class ListaProductos extends AppCompatActivity {

    private TextView nombre1;
    private TextView nombre2;
    private TextView nombre3;
    private TextView nombre4;
    private TextView precio1;
    private TextView precio2;
    private TextView precio3;
    private TextView precio4;
    private ImageButton producto1;
    private ImageButton producto2;
    private ImageButton producto3;
    private ImageButton producto4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);

        nombre1 = (TextView) findViewById(R.id.txt_nom1);
        nombre2 = (TextView) findViewById(R.id.txt_nom2);
        nombre3 = (TextView) findViewById(R.id.txt_nom3);
        nombre4 = (TextView) findViewById(R.id.txt_nom4);
        precio1 = (TextView) findViewById(R.id.txt_precio1);
        precio2 = (TextView) findViewById(R.id.txt_precio2);
        precio3 = (TextView) findViewById(R.id.txt_precio3);
        precio4 = (TextView) findViewById(R.id.txt_precio4);
        producto1 = (ImageButton) findViewById(R.id.btn_prod1);
        producto2 = (ImageButton) findViewById(R.id.btn_prod2);
        producto3 = (ImageButton) findViewById(R.id.btn_prod3);
        producto4 = (ImageButton) findViewById(R.id.btn_prod4);

        ProductosLista lista = (ProductosLista) getIntent().getSerializableExtra("productos");

        producto1.setImageResource(getImageId(lista.getProductosSeleccionados().get(0).getImagen()));
        nombre1.setText(lista.getProductosSeleccionados().get(0).getNombre());
        precio1.setText(Double.toString(lista.getProductosSeleccionados().get(1).getPrecio())+" €");
        producto2.setImageResource(getImageId(lista.getProductosSeleccionados().get(1).getImagen()));
        nombre2.setText(lista.getProductosSeleccionados().get(1).getNombre());
        precio2.setText(Double.toString(lista.getProductosSeleccionados().get(2).getPrecio())+" €");
        producto3.setImageResource(getImageId(lista.getProductosSeleccionados().get(2).getImagen()));
        nombre3.setText(lista.getProductosSeleccionados().get(2).getNombre());
        precio3.setText(Double.toString(lista.getProductosSeleccionados().get(3).getPrecio())+" €");
        producto4.setImageResource(getImageId(lista.getProductosSeleccionados().get(3).getImagen()));
        nombre4.setText(lista.getProductosSeleccionados().get(3).getNombre());
        precio4.setText(Double.toString(lista.getProductosSeleccionados().get(3).getPrecio())+" €");
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void goToProducto1(View view){
        Intent i = new Intent(this, InfoProducto.class);
        Producto productoSeleccionado = catalogo.stream().filter(p -> p.getNombre().equals(nombre1)).findFirst().get();
        i.putExtra("productoSeleccionado", productoSeleccionado);
        startActivity(i);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void goToProducto2(View view){
        Intent i = new Intent(this, InfoProducto.class);
        Producto productoSeleccionado = catalogo.stream().filter(p -> p.getNombre().equals(nombre2)).findFirst().get();
        i.putExtra("productoSeleccionado", productoSeleccionado);
        startActivity(i);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void goToProducto3(View view){
        Intent i = new Intent(this, InfoProducto.class);
        Producto productoSeleccionado = catalogo.stream().filter(p -> p.getNombre().equals(nombre3)).findFirst().get();
        i.putExtra("productoSeleccionado", productoSeleccionado);
        startActivity(i);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void goToProducto4(View view){
        Intent i = new Intent(this, InfoProducto.class);
        Producto productoSeleccionado = catalogo.stream().filter(p -> p.getNombre().equals(nombre4)).findFirst().get();
        i.putExtra("productoSeleccionado", productoSeleccionado);
        startActivity(i);
    }


}