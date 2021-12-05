package com.example.putiton;

import static clases.Catalogo.getImageId;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
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
        imagen.setImageResource(getImageId(productoSeleccionado.getImagen()));
        tallaSeleccionada = sp_tallas.getSelectedItem().toString();
        cantidadSeleccionada = Integer.parseInt(et_cantidad.getText().toString());

    }

    public void aniadirAlCarrito(View view){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

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

        db.insert("productos", null, registro);
        db.close();

        Toast.makeText(this, "Producto añadido al carrito", Toast.LENGTH_SHORT).show();
    }


}