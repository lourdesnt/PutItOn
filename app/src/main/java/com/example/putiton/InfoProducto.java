package com.example.putiton;

import static clases.Catalogo.catalogo;
import static clases.Catalogo.getImageId;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import basededatos.AdminSQLiteOpenHelper;
import clases.Producto;
import clases.ProductosLista;

public class InfoProducto extends AppCompatActivity {

    private Spinner sp_tallas;
    private TextView nombre;
    private TextView precio;
    private TextView referencia;
    private ImageView imagen;
    private EditText et_cantidad;
    private Producto productoSeleccionado;
    private String tallaSeleccionada;
    private int cantidadSeleccionada;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_producto);

        sp_tallas = (Spinner) findViewById(R.id.sp_tallas);
        nombre = (TextView) findViewById(R.id.txt_nom);
        precio = (TextView) findViewById(R.id.txt_precio);
        referencia = (TextView) findViewById(R.id.txt_ref);
        imagen = (ImageView) findViewById(R.id.img_prod);
        et_cantidad = (EditText) findViewById(R.id.num_cant);

        String[] tallas = {"XS", "S", "M", "L", "XL"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tallas);
        sp_tallas.setAdapter(adapter);
        sp_tallas.setPrompt("TALLA");

        productoSeleccionado = (Producto) getIntent().getSerializableExtra("productoSeleccionado");

        nombre.setText(productoSeleccionado.getNombre());
        precio.setText(Double.toString(productoSeleccionado.getPrecio())+" €");
        referencia.setText("Ref.: "+Integer.toString(productoSeleccionado.getReferencia()));
        imagen.setImageResource(getImageId(catalogo.stream().filter(p->p.getNombre().equals(productoSeleccionado.getNombre())).findFirst().get().getImagen()));
        if(productoSeleccionado.getCantidad()!=0){
            et_cantidad.setText(String.valueOf(productoSeleccionado.getCantidad()));
        }

    }

    public void goToListaProductos(View view){
        finish();
    }

    public void aniadirAlCarrito(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        tallaSeleccionada = sp_tallas.getSelectedItem().toString();
        cantidadSeleccionada = Integer.parseInt(et_cantidad.getText().toString());

        int referencia = productoSeleccionado.getReferencia();
        String nombre = productoSeleccionado.getNombre();
        double precio = productoSeleccionado.getPrecio();
        int cantidad = cantidadSeleccionada;

        if(tallaSeleccionada.isEmpty()){
            Toast.makeText(this, "Debes seleccionar una talla", Toast.LENGTH_SHORT).show();
            return;
        }

        String talla = tallaSeleccionada;

        ContentValues registro = new ContentValues();
        registro.put("referencia", referencia);
        registro.put("nombre", nombre);
        registro.put("precio", precio);
        registro.put("talla", talla);
        registro.put("cantidad", cantidad);

        if(findById(referencia)==null) {
            db.insert("productos", null, registro);

            Toast.makeText(this, "Producto añadido al carrito", Toast.LENGTH_SHORT).show();
        } else {
            db.update("productos", registro, "referencia=" + referencia, null);

            Toast.makeText(this, "Producto del carrito modificado", Toast.LENGTH_SHORT).show();
        }
    }

    public Producto findById(int id) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        Producto productoAEncontrar = null;

        String selectQuery = "SELECT * FROM productos WHERE referencia = " + id;
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        if (cursor.getCount()>0) {
            productoAEncontrar = new Producto();
            productoAEncontrar.setReferencia(cursor.getInt(0));
            productoAEncontrar.setNombre(cursor.getString(1));
            productoAEncontrar.setPrecio(cursor.getDouble(2));
            productoAEncontrar.setTalla(cursor.getString(3));
            productoAEncontrar.setCantidad(cursor.getInt(4));
        }

        return productoAEncontrar;
    }

}