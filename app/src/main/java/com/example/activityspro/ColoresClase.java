package com.example.activityspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ColoresClase extends AppCompatActivity implements View.OnClickListener {

    private Button azul;
    private Button blanco;
    private Button negro;
    //private String colores;
   // private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        azul = findViewById(R.id.button2AZul);
        blanco = findViewById(R.id.button3Blanco );
        negro = findViewById(R.id.button4Negro);

        azul.setOnClickListener(this);
        blanco.setOnClickListener(this);
        negro.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        switch (v.getId()){
            case R.id.button2AZul:
                i.putExtra("color","blue");
                break;
            case R.id.button3Blanco:
                i.putExtra("color","white");
                break;
            case R.id.button4Negro:
                i.putExtra("color","black");
                break;
        }
        setResult(RESULT_OK, i);
        finish();
    }
}