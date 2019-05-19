package com.example.aplicacionayuda;

import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Locale;

public class ModuladorGlobal extends AppCompatActivity implements TextToSpeech.OnInitListener  {

    private TextToSpeech tts;
    private Button btnCargarModulador, btnReproducir;
    private TextView tvResultadoCarga;
    private RadioButton rbEsp, rbEng;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modulador_global);


        tts = new TextToSpeech(this,this);
        btnCargarModulador = (Button) findViewById(R.id.btnCargarModulador);
        tvResultadoCarga = (TextView) findViewById(R.id.tvResultado);
        btnReproducir = (Button) findViewById(R.id.btnReproducir);
    }


    public void CargarModulador(View view) {
        String country = "ESP";
        String language = "spa";
        String defaultMessage = "Este es un mensaje de prueba";

        rbEsp = (RadioButton) findViewById(R.id.rbEsp);
        rbEng = (RadioButton) findViewById(R.id.rbEng);

        if(rbEng.isChecked()) {
            country = "";
            language = "en";
            defaultMessage = "This is a test message";
        }

        int result = tts.setLanguage( new Locale(language, country));
        if(result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
            Log.e("TTS", "Este lenguaje no es soportado");
        } else {
            tvResultadoCarga.setTextColor(Color.GREEN);
            tvResultadoCarga.setText("Modulador cargado correctamente");


            tts.speak(defaultMessage, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    public void ReproducirFrase(View view) {

        TextView tvMessage = (TextView) findViewById(R.id.etTexto);
        String message = tvMessage.getText().toString();
        tts.speak(message, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    public void onInit(int status) {

    }
}
