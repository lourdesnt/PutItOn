package com.example.putiton;

import static clases.Catalogo.catalogo;
import static clases.Catalogo.getImageId;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;

import android.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import org.w3c.dom.Text;

import java.util.List;
import java.util.stream.Collectors;

import basededatos.AdminSQLiteOpenHelper;
import clases.Producto;
import clases.ProductosLista;

public class ProductoCarrito extends Fragment {

    private TextView nombre;
    private TextView talla;
    private TextView cantidad;
    private TextView precio;
    private Producto producto;
    private ImageView imagen;
    private ImageButton modificar;
    private ImageButton eliminar;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto p) {
        this.producto = p;
    }

    public ProductoCarrito() {
        // Required empty public constructor

    }

    public static ProductoCarrito newInstance(Producto p) {
        ProductoCarrito fragment = new ProductoCarrito();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        fragment.setProducto(p);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_producto_carrito, container, false);
        nombre = (TextView) view.findViewById(R.id.txt_nom_c);
        talla = (TextView) view.findViewById(R.id.txt_talla_c);
        cantidad = (TextView) view.findViewById(R.id.txt_cant_c);
        precio = (TextView) view.findViewById(R.id.txt_precio_c);
        imagen = (ImageView) view.findViewById(R.id.img_prod_c);
        modificar = (ImageButton) view.findViewById(R.id.btn_modificar);
        eliminar = (ImageButton) view.findViewById(R.id.btn_eliminar);

        nombre.setText(getProducto().getNombre());
        talla.setText(getProducto().getTalla());
        precio.setText((getProducto().getPrecio()*getProducto().getCantidad())+" €");
        cantidad.setText(String.valueOf(getProducto().getCantidad()));
        imagen.setImageResource(getImageId(catalogo.stream().filter(p->p.getNombre().equals(getProducto().getNombre())).findFirst().get().getImagen()));

        modificar.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), InfoProducto.class);
                Producto productoSeleccionado = getProducto();
                i.putExtra("productoSeleccionado", productoSeleccionado);
                startActivity(i);
            }
        });

        Fragment f = this;

        eliminar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Eliminar(view, getProducto());
                getFragmentManager().beginTransaction().remove(f).commit();
                ((Carrito) getActivity()).onResume();
            }
        });

        return view;
    }

    public void Eliminar(View view, Producto p){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(view.getContext(), "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();

        int referencia = p.getReferencia();

        db.delete("productos", "referencia = "+referencia, null);
    }


}