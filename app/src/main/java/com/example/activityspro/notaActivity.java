package com.example.activityspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class notaActivity extends AppCompatActivity {

    private EditText parcial1;
    private EditText parcial2;
    private EditText quices;
    private EditText ejercicios;
    private EditText proyecto1;
    private EditText proyecto2;
    private Button calcular;
    private SharedPreferences pasarDatos;
  //  private  String ejemplo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);
        String nombre = getSharedPreferences("nombres",MODE_PRIVATE).getString("nombre","WHITE");
        Log.e("--------------",nombre );

        //find
        parcial1 = findViewById(R.id.parcial1);
        parcial2 = findViewById(R.id.parcial2);
        quices = findViewById(R.id.quices);
        ejercicios = findViewById(R.id.ejercicios);
        proyecto1 = findViewById(R.id.proyecto1);
        proyecto2 = findViewById(R.id.proyecto2);

        calcular= findViewById(R.id.calcular);

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


        calcular.setOnClickListener(
                (v)->{


                    double parcial1Int = Double.parseDouble((parcial1.getText().toString()));
                    double parcial2Int = Double.parseDouble((parcial2.getText().toString()));
                    double quicesInt = Double.parseDouble((quices.getText().toString()));
                    double ejerciciosInt = Double.parseDouble((ejercicios.getText().toString()));
                    double proyecto1Int = Double.parseDouble((proyecto1.getText().toString()));
                    double proyecto2Int = Double.parseDouble((proyecto2.getText().toString()));
                    double promedio = (parcial1Int*0.15)+(parcial2Int*0.15)+(quicesInt*0.15)+(ejerciciosInt*0.05)
                            +(proyecto1Int*0.25)+(proyecto2Int*0.25);
                    Log.e("aaaaaaaaaaaaaaa",""+promedio);

                    pasarDatos = getSharedPreferences("notas", MODE_PRIVATE);
                    pasarDatos.edit().putString("nota", ""+promedio).apply();
                    Intent i = new Intent(this,resultado.class);
                    startActivity(i);
                    finish();

                }
        );
    }

    @Override
    protected void onStop() {
        super.onStop();


    }
}