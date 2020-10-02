package com.example.formularioeditext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Confirmar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar);
        //recibimos los datos del mainactivity
        final TextView nombretxt=(TextView)findViewById(R.id.nombretxt);
        final TextView fechatxt=(TextView)findViewById(R.id.fechatxt);
        final TextView correotxt=(TextView)findViewById(R.id.correotxt);
        final TextView descripciontxt=(TextView)findViewById(R.id.descripciontxt);
        final TextView telefonotxt=(TextView)findViewById(R.id.telefonotxt);

        Bundle intent=getIntent().getExtras();
        //los obtenemos por la clave y ponemos ese texto del intent
        nombretxt.setText(intent.getString("nombre"));
        fechatxt.setText(intent.getString("fecha"));
        correotxt.setText(intent.getString("correo"));
        descripciontxt.setText(intent.getString("descripcion"));
        telefonotxt.setText(String.valueOf(intent.getInt("telefono")));


        //enviamos desde esta actividad a mainactivity para editar
        Button boton =(Button) findViewById(R.id.editarboton);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abren la actividad confirmar mainactivycty.this
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                ////mandando datos
                intent.putExtra("nombre",nombretxt.getText().toString());
                intent.putExtra("correo",correotxt.getText().toString());
                intent.putExtra("fecha",fechatxt.getText().toString());
                intent.putExtra("descripcion",descripciontxt.getText().toString());
                intent.putExtra("telefono",Integer.parseInt(telefonotxt.getText().toString()));


                ////
                startActivity(intent);
            }
        });
    }
}