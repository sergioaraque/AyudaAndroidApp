package com.example.aplicacionayuda;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.util.Locale;


public class AyudaRapida extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ayuda_rapida);

        tts = new TextToSpeech(this,this);

    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            //int result = tts.setLanguage(Locale.getDefault());
            int result = tts.setLanguage(new Locale("spa", "ESP"));
            if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA) {
                Log.e("TTS", "Este lenguaje no es soportado");
            }
        } else {
            Log.e("TTS", "Inicialización del lenguaje fallida");
        }
    }

    public void LanzarAyuda(View view) {
        String test = "Disculpa, necesito ayuda";
        Log.e("TTS",TextToSpeech.QUEUE_FLUSH + "");
        test = test.toString();
        tts.speak(test, TextToSpeech.QUEUE_FLUSH, null);
    }
    public void LanzarIrAlBaño(View view) {
        tts.speak("¡Necesito ir al baño!", TextToSpeech.QUEUE_FLUSH, null);
    }
    public void LanzarDisculpe(View view) {
        tts.speak("¡Disculpa!", TextToSpeech.QUEUE_FLUSH, null);
    }
    public void LanzarSaludo(View view) {
        tts.speak("Hola, soy un robot", TextToSpeech.QUEUE_FLUSH, null);
    }
    public void LanzarInfo(View view) {
        tts.speak("Aplicación realizada por Sergio Araque", TextToSpeech.QUEUE_FLUSH, null);
    }
}
