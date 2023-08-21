package com.example.multiplechoice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    Button btn;
    String[] categorias;
    ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        categorias = getResources().getStringArray((R.array.categorias));
        lv = (ListView) findViewById(R.id.lvLista);
        btn = (Button) findViewById(R.id.btnSeleccion);

        adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, categorias);

        lv.setAdapter(adaptador);
    }

    public void Seleccionar(View view) {

        SparseBooleanArray checked = lv.getCheckedItemPositions();

        ArrayList<String> itemSeleccionado = new ArrayList<String>();

        for (int i = 0; i < checked.size(); i++) {
            int posicion = checked.keyAt(i);

            if (checked.valueAt(i))
                itemSeleccionado.add(adaptador.getItem(posicion));
        }

        String[] mostrarValoresSeleccionados = new String[itemSeleccionado.size()];

        for (int i = 0; i < itemSeleccionado.size(); i++) {
            mostrarValoresSeleccionados[i] = itemSeleccionado.get(i);
        }

        Intent i = new Intent(getApplicationContext(), Resultado.class);

        Bundle b = new Bundle();

        b.putStringArray("items seleccionados", mostrarValoresSeleccionados);

        i.putExtras(b);

        startActivity(i);
    }

    public void Salir(View view) {
        finish();
    }
}