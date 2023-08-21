package com.example.multiplechoice;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Resultado extends AppCompatActivity {
    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        Bundle b = getIntent().getExtras();
        String[] resultadoArreglo = b.getStringArray("items seleccionados");
        ListView listViewResultado = (ListView)  findViewById(R.id.lvResultado);
        ArrayAdapter<String> adaptadorResultado = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, resultadoArreglo);
        listViewResultado.setAdapter(adaptadorResultado);
    }

    public void Regresar(View view) {
        finish();
    }
}
