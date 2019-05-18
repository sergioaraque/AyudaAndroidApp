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

    /**
     * Lanza la ventana con un texto a escribir y que el dictador lo lea.
     * @param view
     */
    public void LanzarAyudaRapida(View view) {
        Intent intent = new Intent(this, AyudaRapida.class);
        startActivity(intent);
    }

    /**
     * Lanza los botones con funcionalidad
     * @param view
     */
    public void Prueba(View view) {
        Intent intent = new Intent(this, Prueba.class);
        startActivity(intent);
    }

    public void LanzarModuladorGlobal(View view) {
        Intent intent = new Intent(this, ModuladorGlobal.class);
        startActivity(intent);
    }

    /**
     * Permite cerrar la aplicación directamente.
     * @param view
     */
    public void CerrarAplicacion(View view) {
        System.exit(0);
    }
}

