package com.example.juegotareabanderas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Final extends AppCompatActivity {
    public Button volverJuego,menu;
    public TextView fallo,punto,acierto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        volverJuego = (Button) findViewById(R.id.btnOtra);
        menu = (Button) findViewById(R.id.btnMenu);
        fallo = (TextView) findViewById(R.id.txtFallos);
        punto = (TextView) findViewById(R.id.txtPuntos);
        acierto = (TextView) findViewById(R.id.txtAciertos);
        recibirDatos();

        volverJuego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainJugar.class);
                startActivity(i);
                finish();
            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void recibirDatos(){
        Bundle extras = getIntent().getExtras();
        int d1 = extras.getInt("correcto");
        int d2 = extras.getInt("fallos");
        int d3 = extras.getInt("puntos");

        acierto.setText(String.valueOf(d1));
        fallo.setText(String.valueOf(d2));
        punto.setText(String.valueOf(d3));


    }
}