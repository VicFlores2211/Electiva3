package com.example.listassimples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ListView listview;
    String[] cat;

/*    String[] categorias = {
            "Carnes", "Verduras", "Cereales", "Higiene personal", "Frutas",
            "Limpieza del hogar", "Mariscos", "Bebidas", "Dulcerias",
            "Boquitas", "Medicinas", "Papeleria", "Mascotas"
    }; */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cat = getResources().getStringArray(R.array.categorias);

        listview = (ListView) findViewById(R.id.lista);

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, cat);

        listview.setAdapter(adaptador);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Has seleccionado la categoria: " + cat[i], Toast.LENGTH_LONG).show();
            }
        });

    }
}