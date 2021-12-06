package com.example.putiton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import clases.Producto;
import clases.ProductosLista;

public class FormularioCompra extends AppCompatActivity {

    private TextView tv_total;
    private ProductosLista lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_compra);

        tv_total = (TextView) findViewById(R.id.txt_preciototal);

        lista = (ProductosLista) getIntent().getSerializableExtra("compra");

        double total = totalCompra(lista.getProductosSeleccionados());

        tv_total.setText(String.valueOf(total)+" €");

    }

    public void goToCarrito(View view) {
        finish();
    }

    public double totalCompra(List<Producto> productos){
        double total = 0;
        double todo = 0;
        for(Producto p: productos){
            total = p.getPrecio() * p.getCantidad();
            todo += total;
        }
        return todo;
    }
}