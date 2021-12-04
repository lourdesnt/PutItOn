package com.example.putiton;

import static clases.Catalogo.catalogo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import clases.Producto;
import clases.ProductosLista;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ApartadosRopa#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ApartadosRopa extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ApartadosRopa() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ApartadosRopa.
     */
    // TODO: Rename and change types and number of parameters
    public static ApartadosRopa newInstance(String param1, String param2) {
        ApartadosRopa fragment = new ApartadosRopa();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apartados_ropa, container, false);
        ImageButton b1 = (ImageButton) view.findViewById(R.id.btn_ms);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ListaProductos.class);
                List<Producto> sudaderasMujer = catalogo.stream().filter(p -> p.getReferencia()>110 && p.getReferencia()<120).collect(Collectors.toList());
                i.putExtra("productos", new ProductosLista(sudaderasMujer));
                startActivity(i);
            }
        });
        ImageButton b2 = (ImageButton) view.findViewById(R.id.btn_mp);
        b2.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ListaProductos.class);
                List<Producto> pantalonesMujer = catalogo.stream().filter(p -> p.getReferencia()>120 && p.getReferencia()<130).collect(Collectors.toList());
                i.putExtra("productos", new ProductosLista(pantalonesMujer));
                startActivity(i);
            }
        });
        ImageButton b3 = (ImageButton) view.findViewById(R.id.btn_mz);
        b3.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ListaProductos.class);
                List<Producto> zapatosMujer = catalogo.stream().filter(p -> p.getReferencia()>130 && p.getReferencia()<140).collect(Collectors.toList());
                i.putExtra("productos", new ProductosLista(zapatosMujer));
                startActivity(i);
            }
        });
        ImageButton b4 = (ImageButton) view.findViewById(R.id.btn_ma);
        b4.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ListaProductos.class);
                List<Producto> accesoriosMujer = catalogo.stream().filter(p -> p.getReferencia()>140 && p.getReferencia()<150).collect(Collectors.toList());
                i.putExtra("productos", new ProductosLista(accesoriosMujer));
                startActivity(i);
            }
        });
        return view;
    }
}