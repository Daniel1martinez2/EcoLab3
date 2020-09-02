package com.example.activityspro;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class resultado extends AppCompatActivity {

    private Button calcular;
    private TextView nota;
    private TextView nombre;
    private  String ejemplo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        nombre = findViewById(R.id.saludo);
        String userName = getSharedPreferences("nombres",MODE_PRIVATE).getString("nombre","3.0");
        nombre.setText(userName);
        String alo = getSharedPreferences("notas",MODE_PRIVATE).getString("nota","3.0");
        Log.e("-<-<-<-<-<-<-<-<", alo+"yesssssssss");

        String colores = getSharedPreferences("colores",MODE_PRIVATE).getString("colorActual","WHITE");

        switch (colores){
            case "blue":
                getWindow().getDecorView().setBackgroundColor(Color.BLUE);
                break;
            case "white":
                getWindow().getDecorView().setBackgroundColor(Color.WHITE);
                break;
            case "black":
                getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                break;
        }

        calcular = findViewById(R.id.calcular);

        nota = findViewById(R.id.notaFinal);
        nota.setText(alo);
        calcular.setOnClickListener(
                (v)->{
                 getSharedPreferences("colores", MODE_PRIVATE).edit().putString("colorActual","white").apply();

                    finish();
                }
        );
    }
}