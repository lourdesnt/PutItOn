package com.example.putiton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Perfil extends AppCompatActivity {

    String username;
    TextView titulouser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        username = getIntent().getStringExtra("nombreUsuario");
        titulouser = (TextView) findViewById(R.id.titulouser);
        titulouser.setText(titulouser.getText().toString() + " " + username);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        int id = item.getItemId();
        if(id == R.id.logout){
            Intent i = new Intent(this, AreaCliente.class);
            startActivity(i);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}