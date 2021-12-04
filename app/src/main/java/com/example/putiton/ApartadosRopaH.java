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
import android.widget.ImageButton;

import java.util.List;
import java.util.stream.Collectors;

import clases.Producto;
import clases.ProductosLista;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ApartadosRopaH#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ApartadosRopaH extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ApartadosRopaH() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ApartadosRopaH.
     */
    // TODO: Rename and change types and number of parameters
    public static ApartadosRopaH newInstance(String param1, String param2) {
        ApartadosRopaH fragment = new ApartadosRopaH();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_apartados_ropa_h, container, false);
        ImageButton b1 = (ImageButton) view.findViewById(R.id.btn_hs);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ListaProductos.class);
                List<Producto> sudaderasHombre = catalogo.stream().filter(p -> p.getReferencia()>210 && p.getReferencia()<220).collect(Collectors.toList());
                i.putExtra("productos", new ProductosLista(sudaderasHombre));
                startActivity(i);
            }
        });
        ImageButton b2 = (ImageButton) view.findViewById(R.id.btn_hp);
        b2.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ListaProductos.class);
                List<Producto> pantalonesHombre = catalogo.stream().filter(p -> p.getReferencia()>220 && p.getReferencia()<230).collect(Collectors.toList());
                i.putExtra("productos", new ProductosLista(pantalonesHombre));
                startActivity(i);
            }
        });
        ImageButton b3 = (ImageButton) view.findViewById(R.id.btn_hz);
        b3.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ListaProductos.class);
                List<Producto> zapatosHombre = catalogo.stream().filter(p -> p.getReferencia()>230 && p.getReferencia()<240).collect(Collectors.toList());
                i.putExtra("productos", new ProductosLista(zapatosHombre));
                startActivity(i);
            }
        });
        ImageButton b4 = (ImageButton) view.findViewById(R.id.btn_ha);
        b4.setOnClickListener(new View.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ListaProductos.class);
                List<Producto> accesoriosHombre = catalogo.stream().filter(p -> p.getReferencia()>240 && p.getReferencia()<250).collect(Collectors.toList());
                i.putExtra("productos", new ProductosLista(accesoriosHombre));
                startActivity(i);
            }
        });
        return view;
    }

}