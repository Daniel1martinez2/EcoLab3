package com.example.activityspro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button go;
    private Button color;
    private String colors;
    private  String ejemplo;
    private String name;
    private EditText nameText;
   private SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        go = findViewById(R.id.go);
        color = findViewById(R.id.color);
        go.setOnClickListener(this);
        color.setOnClickListener(this);
        nameText = findViewById(R.id.name);



    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.go:
                Intent a = new Intent(this,notaActivity.class);

                name = nameText.getText().toString();
                preferencias = getSharedPreferences("nombres", MODE_PRIVATE);
                preferencias.edit().putString("nombre",name).apply();
                startActivity(a);
                break;
            case R.id.color:
                Intent i = new Intent(this,ColoresClase.class);
                startActivityForResult(i,11);

                break;
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==11 && resultCode == RESULT_OK){
            SharedPreferences preferenciasCOlor;
            String testing = data.getExtras().getString("color");
            switch (testing){

                case "blue":   getWindow().getDecorView().setBackgroundColor(Color.BLUE);

                    break;
                case "white":   getWindow().getDecorView().setBackgroundColor(Color.WHITE);

                    break;
                case "black":   getWindow().getDecorView().setBackgroundColor(Color.GREEN);

                    break;

            }
            preferenciasCOlor = getSharedPreferences("colores", MODE_PRIVATE);
            preferenciasCOlor.edit().putString("colorActual",testing).apply();
            Toast.makeText(this, testing, Toast.LENGTH_LONG).show();
        }
    }
}