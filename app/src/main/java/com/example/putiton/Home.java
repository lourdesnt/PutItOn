package com.example.putiton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TabHost;

public class Home extends AppCompatActivity {

    private TabHost tab_apartados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

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

}