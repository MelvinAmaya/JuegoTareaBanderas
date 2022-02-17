package com.example.juegotareabanderas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button btjugar,btncomo,btninf;
    int contador4;

    @Override
    public void onBackPressed() {

        if(contador4==0)
        {
            Toast.makeText(getApplicationContext(),"Presione de Nuevo Para salir.",Toast.LENGTH_LONG).show();
            contador4++;
        }
        else
        {
            super.onBackPressed();
        }

        new CountDownTimer(5000,1000){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                contador4=0;
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btjugar = (Button) findViewById(R.id.btnJugar);
        btncomo = (Button) findViewById(R.id.btnInfo);
        btninf = (Button)  findViewById(R.id.btnabout);

        btjugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainJugar.class);
                startActivity(i);
            }
        });

        btncomo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainInfo.class);
                startActivity(i);
            }
        });

        btninf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),MainAbout.class);
                startActivity(i);
            }
        });
    }
}