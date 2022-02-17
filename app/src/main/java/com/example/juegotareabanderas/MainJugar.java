package com.example.juegotareabanderas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;

public class MainJugar extends AppCompatActivity {

    public Button respuesta1,respuesta2,respuesta3;
    public ImageView banderas;
    public TextView puntos,tiempo;
    int cont,fallos,punt,tick=30,veces;
    int numerogenerado=0;
    int in;
    int botongenerado;
    CountDownTimer contanto;
    int respuestaaleatoria;
    Integer[] repetidos;
    MediaPlayer audio;
    String[] nombre_ban ={"Alemania","Argentina","Baréin","Canadá","Catar","Chile","China","Colombia","Corea Del Norte","Corea Del Sur","El Salvador","España","Estados Unidos","Finlandia","Francia","Dinamarca","Indonesia","Israel","Italia","Japon","Kenia","Liberia","Madagascar","Mexico","Mónaco","Noruega","Perú","Polonia","Reino Unido","Rusia","Suecia","Suiza","Tonga","Venezuela","Islandia"};
    Integer[] bander ={R.drawable.alemania,R.drawable.argentina,R.drawable.barein,R.drawable.canada,R.drawable.catar,R.drawable.chile,R.drawable.china,R.drawable.colombia,R.drawable.corea_del_norte,R.drawable.corea_del_sur,R.drawable.el_salvador,R.drawable.espania_europa,R.drawable.estados_unidos,R.drawable.finlandia,R.drawable.francia,R.drawable.inamarca,R.drawable.indonesia,R.drawable.israel,R.drawable.italia,R.drawable.japon,R.drawable.kenia,R.drawable.liberia,R.drawable.madagascar,R.drawable.mexico,R.drawable.monaco,R.drawable.noruega,R.drawable.peru,R.drawable.polonia,R.drawable.reino_unido,R.drawable.russia,R.drawable.suecia,R.drawable.suiza,R.drawable.tonga,R.drawable.venezuela,R.drawable.islandia};
    ArrayList<String> nombreBa = new ArrayList<String>(Arrays.asList(nombre_ban));
    ArrayList<Integer> ba = new ArrayList<Integer>(Arrays.asList(bander));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_jugar);
        respuesta1 = (Button) findViewById(R.id.btnrespu1);
        respuesta2 = (Button) findViewById(R.id.btnrespu2);
        respuesta3 = (Button) findViewById(R.id.btnrespu3);
        banderas = (ImageView) findViewById(R.id.imBandera);
        puntos = (TextView) findViewById(R.id.txtPuntos);
        tiempo = (TextView) findViewById(R.id.txtTiempo);
        in =3;
        veces=0;
        //numeros aleatorios
        generarImagen();
        Integer q = bander[numerogenerado];

        //metodos
        generarBoton();
        resAleatoria();
        res();
        tiempo();



        //boton 1
        respuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(respuesta1.getText().toString().equals(nombre_ban[numerogenerado]))
                {
                    punt++;
                    cont++;
                    audio =MediaPlayer.create(getApplicationContext(),R.raw.correct);
                    audio.start();
                    respuesta1.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.green));
                    respuesta2.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));
                    respuesta3.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));
                    puntos.setText(String.valueOf(punt));
                }
                else
                {
                    audio =MediaPlayer.create(getApplicationContext(),R.raw.incorrecto);
                    audio.start();
                    respuesta1.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));

                    if(respuesta2.getText().toString().equals(nombre_ban[numerogenerado])) {
                        respuesta2.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.green));
                    }
                    else
                    {
                        respuesta2.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.red));
                    }
                    if(respuesta3.getText().toString().equals(nombre_ban[numerogenerado]))
                    {
                        respuesta3.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.green));
                    }
                    else
                    {
                        respuesta3.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));
                    }

                    if(punt ==1)
                    {
                        puntos.setText("0");
                        punt=0;
                    }
                    else if(punt==2)
                    {
                        puntos.setText("0");
                        punt=0;
                    }
                    else if(punt ==0)
                    {
                        puntos.setText("0");
                        punt=0;
                    }
                    else if(punt == 3)
                    {
                        puntos.setText("2");

                        punt =2;
                    }
                    else
                    {
                        punt=punt-2;
                        puntos.setText(String.valueOf(punt));
                    }
                    fallos++;
                }
                siguiente();

            }

        });

        //boton 2
        respuesta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(respuesta2.getText().toString().equals(nombre_ban[numerogenerado]))
                {
                    punt++;
                    cont++;
                    audio =MediaPlayer.create(getApplicationContext(),R.raw.correct);
                    audio.start();
                    respuesta2.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.green));
                    respuesta1.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));
                    respuesta3.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));
                    puntos.setText(String.valueOf(punt));
                }
                else
                {
                    audio =MediaPlayer.create(getApplicationContext(),R.raw.incorrecto);
                    audio.start();
                    respuesta2.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));

                    if(respuesta1.getText().toString().equals(nombre_ban[numerogenerado])) {
                        respuesta1.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.green));
                    }
                    else
                    {
                        respuesta1.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.red));
                    }
                    if(respuesta3.getText().toString().equals(nombre_ban[numerogenerado]))
                    {
                        respuesta3.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.green));
                    }
                    else
                    {
                        respuesta3.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));
                    }

                    if(punt ==1)
                    {
                        puntos.setText("0");
                        punt=0;
                    }
                    else if(punt==2)
                    {
                        puntos.setText("0");
                        punt=0;
                    }
                    else if(punt ==0)
                    {
                        puntos.setText("0");
                        punt=0;
                    }
                    else if(punt == 3)
                    {
                        puntos.setText("2");

                        punt =2;
                    }
                    else
                    {
                        punt=punt-2;
                        puntos.setText(String.valueOf(punt));
                    }
                    fallos++;
                }
                siguiente();

            }
        });

        //boton 3
        respuesta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(respuesta3.getText().toString().equals(nombre_ban[numerogenerado]))
                {
                    punt++;
                    cont++;
                    audio =MediaPlayer.create(getApplicationContext(),R.raw.correct);
                    audio.start();
                    respuesta3.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.green));
                    respuesta1.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));
                    respuesta2.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));
                    puntos.setText(String.valueOf(punt));
                }
                else
                {
                    audio =MediaPlayer.create(getApplicationContext(),R.raw.incorrecto);
                    audio.start();
                    respuesta3.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));

                    if(respuesta1.getText().toString().equals(nombre_ban[numerogenerado])) {
                        respuesta1.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.green));
                    }
                    else
                    {
                        respuesta1.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.red));
                    }
                    if(respuesta2.getText().toString().equals(nombre_ban[numerogenerado]))
                    {
                        respuesta2.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.green));
                    }
                    else
                    {
                        respuesta2.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));
                    }

                    if(punt ==1)
                    {
                        puntos.setText("0");
                        punt=0;
                    }
                    else if(punt==2)
                    {
                        puntos.setText("0");
                        punt=0;
                    }
                    else if(punt ==0)
                    {
                        puntos.setText("0");
                        punt=0;
                    }
                    else if(punt == 3)
                    {
                        puntos.setText("2");

                        punt =2;
                    }
                    else
                    {
                        punt=punt-2;
                        puntos.setText(String.valueOf(punt));
                    }
                    fallos++;
                }

                siguiente();

            }
        });



    }

    //metodo para generar el orden de botones alñeatorio
    public void generarBoton()
    {
        //Botones
        Random boton = new Random();
        botongenerado = boton.nextInt(in);

    }

    //metodo para crear las respuestas aleatorias
    public void resAleatoria(){

        //Respuestas Aleatorias
        Random resd = new Random();
        respuestaaleatoria = resd.nextInt(nombreBa.size());
    }

    //metodo para generar la imagen aleatoria
    public void generarImagen(){

        veces++;
        if(veces ==5)
        {
            respuesta1.setEnabled(false);
            respuesta3.setEnabled(false);
            respuesta2.setEnabled(false);
            respuesta1.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.white));
            respuesta2.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.white));
            respuesta3.setTextColor(ContextCompat.getColor(getBaseContext(),R.color.white));
            tiempo.setVisibility(View.INVISIBLE);
            fin();

        }
        else
        {
            //numeros aleatorios
            Random ran = new Random();
            int generando = ran.nextInt(nombreBa.size());
            if(nombre_ban[generando]!=null)
            {
                numerogenerado = generando;
                establecer_imagen(numerogenerado);
            }
            else
            {
                Random ran2 = new Random();
                int generando2 = ran2.nextInt(nombreBa.size());
                numerogenerado = generando;
                establecer_imagen(numerogenerado);
            }


        }
    }

    //metodo para establecer imagen aleatoria
    public void establecer_imagen(int img){
        if(bander[img]!=null){
            int id = bander[img];
            banderas.setImageResource(id);


        }

    }

    //metodo para agregarle las respuestas aleatorias al los botones
    public void res()
    {
        if(botongenerado==2)
        {
            if(numerogenerado==0)
            {
                respuesta1.setText(nombre_ban[numerogenerado]);
                respuesta2.setText(nombre_ban[numerogenerado+1]);
                respuesta3.setText(nombre_ban[numerogenerado+2]);
            }
            else if (numerogenerado==nombre_ban.length)
            {
                respuesta1.setText(nombre_ban[numerogenerado]);
                respuesta2.setText(nombre_ban[numerogenerado-1]);
                respuesta3.setText(nombre_ban[numerogenerado-2]);
            }
            else
            {
                respuesta1.setText(nombre_ban[numerogenerado]);
                respuesta2.setText(nombre_ban[numerogenerado+1]);
                respuesta3.setText(nombre_ban[numerogenerado-1]);
            }
        }
        else if(botongenerado==1)
        {
            if(numerogenerado==0)
            {
                respuesta1.setText(nombre_ban[numerogenerado+1]);
                respuesta2.setText(nombre_ban[numerogenerado]);
                respuesta3.setText(nombre_ban[numerogenerado+2]);
            }
            else if (numerogenerado==nombre_ban.length)
            {
                respuesta1.setText(nombre_ban[numerogenerado-1]);
                respuesta2.setText(nombre_ban[numerogenerado]);
                respuesta3.setText(nombre_ban[numerogenerado-2]);
            }
            else
            {
                respuesta1.setText(nombre_ban[numerogenerado+1]);
                respuesta2.setText(nombre_ban[numerogenerado]);
                respuesta3.setText(nombre_ban[numerogenerado-1]);
            }
        }
        else if(botongenerado==0)
        {
            if(numerogenerado==0)
            {
                respuesta1.setText(nombre_ban[numerogenerado+1]);
                respuesta2.setText(nombre_ban[numerogenerado+2]);
                respuesta3.setText(nombre_ban[numerogenerado]);
            }
            else if (numerogenerado==nombre_ban.length)
            {
                respuesta1.setText(nombre_ban[numerogenerado-1]);
                respuesta2.setText(nombre_ban[numerogenerado-2]);
                respuesta3.setText(nombre_ban[numerogenerado]);
            }
            else
            {
                respuesta1.setText(nombre_ban[numerogenerado+1]);
                respuesta2.setText(nombre_ban[numerogenerado-1]);
                respuesta3.setText(nombre_ban[numerogenerado]);
            }
        }



        }

        public void fin(){

        new CountDownTimer(2000,1){

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

                Intent i = new Intent(getApplicationContext(),Final.class);
                i.putExtra("correcto",cont);
                i.putExtra("fallos",fallos);
                i.putExtra("puntos",punt);
                startActivity(i);
                finish();

            }
        }.start();


        }


        public void tiempo()
        {
            contanto = new CountDownTimer(30000,1000)
            {

                @Override
                public void onTick(long millisUntilFinished) {

                    tiempo.setText(String.valueOf(tick));
                    tick --;
                }

                @Override
                public void onFinish() {

                    if(respuesta3.getText().toString().equals(nombre_ban[numerogenerado]))
                    {

                        respuesta3.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.green));
                        respuesta1.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));
                        respuesta2.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));
                        puntos.setText(String.valueOf(punt));
                    }
                    else
                    {
                        respuesta3.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));

                        if(respuesta1.getText().toString().equals(nombre_ban[numerogenerado])) {
                            respuesta1.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.green));
                        }
                        else
                        {
                            respuesta1.setBackgroundColor(ContextCompat.getColor(getBaseContext(), R.color.red));
                        }
                        if(respuesta2.getText().toString().equals(nombre_ban[numerogenerado]))
                        {
                            respuesta2.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.green));
                        }
                        else
                        {
                            respuesta2.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.red));
                        }

                        if(punt ==1)
                        {
                            puntos.setText("0");
                            punt=0;
                        }
                        else if(punt==2)
                        {
                            puntos.setText("0");
                            punt=0;
                        }
                        else if(punt ==0)
                        {
                            puntos.setText("0");
                            punt=0;
                        }
                        else if(punt == 3)
                        {
                            puntos.setText("2");

                            punt =2;
                        }
                        else
                        {
                            punt=punt-2;
                            puntos.setText(String.valueOf(punt));
                        }

                    }

                    esperar2();

                }
            }.start();
        }

        //buelbe tododo a la normalidad
        public void esperar2()
        {
            new CountDownTimer(4000,1)
            {

                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    respuesta1.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.black));
                    respuesta2.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.black));
                    respuesta3.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.black));
                    ba.remove(numerogenerado);

                    nombreBa.remove(numerogenerado);
                    punt = 0;
                    puntos.setText(String.valueOf(punt));
                    tick = 30;
                    generarBoton();
                    generarImagen();
                    res();



                        tiempo();


                }
            }.start();
        }

        public void siguiente()
    {
        new CountDownTimer(2000,1)
        {

            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                respuesta1.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.black));
                respuesta2.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.black));
                respuesta3.setBackgroundColor(ContextCompat.getColor(getBaseContext(),R.color.black));
                //ba.remove(numerogenerado);
                //bander[numerogenerado] = null;
                //nombreBa.remove(numerogenerado);
                //nombre_ban[numerogenerado] = null;
                generarImagen();
                res();
                generarBoton();
                tick = 30;
                contanto.cancel();
                tiempo();



            }
        }.start();
    }





    }

