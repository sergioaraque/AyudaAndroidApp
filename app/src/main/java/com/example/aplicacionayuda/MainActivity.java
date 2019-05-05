package com.example.aplicacionayuda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Clase principal, un menú simple e intuitivo.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LanzarAyudaRapida(View view) {
        Intent intent = new Intent(this, AyudaRapida.class);
        startActivity(intent);
    }
    public void Prueba(View view) {
        Intent intent = new Intent(this, Prueba.class);
        startActivity(intent);
    }
}

