package com.example.formularioeditext;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button bfecha;
    EditText efecha;
    private int dia,mes,ano;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bfecha=(Button)findViewById(R.id.boton_fecha);
        efecha=(EditText) findViewById(R.id.campo_fecha);
        //ESCUCHADORES
        bfecha.setOnClickListener(this);
        ///BOTON ENVIAR
        Button boton =(Button) findViewById(R.id.boton_Enviar);
        //mandando datos
        final EditText nombre=(EditText)findViewById(R.id.campo_nombrecompleto);
        final EditText correo=(EditText)findViewById(R.id.campo_correo);
        final EditText fecha=(EditText)findViewById(R.id.campo_fecha);
        final EditText descripcion=(EditText)findViewById(R.id.campo_descripcion);
        final EditText telefono=(EditText)findViewById(R.id.campo_telefono);


        //////
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //abren la actividad confirmar mainactivycty.this
                Intent intent=new Intent(getApplicationContext(), Confirmar.class);
                ////mandando datos
                intent.putExtra("nombre",nombre.getText().toString());
                intent.putExtra("correo",correo.getText().toString());
                intent.putExtra("fecha",fecha.getText().toString());
                intent.putExtra("descripcion",descripcion.getText().toString());
                intent.putExtra("telefono",Integer.parseInt(telefono.getText().toString()));


                ////
                startActivity(intent);
            }
        });
        //recibimos los datos del mainactivity
        final EditText nombretxt=(EditText)findViewById(R.id.campo_nombrecompleto);
        final EditText fechatxt=(EditText)findViewById(R.id.campo_fecha);
        final EditText correotxt=(EditText)findViewById(R.id.campo_correo);
        final EditText descripciontxt=(EditText)findViewById(R.id.campo_descripcion);
        final EditText telefonotxt=(EditText)findViewById(R.id.campo_telefono);

        Bundle intent=getIntent().getExtras();
        //los obtenemos por la clave y ponemos ese texto del intent
        nombretxt.setText(intent.getString("nombre"));
        fechatxt.setText(intent.getString("fecha"));
        correotxt.setText(intent.getString("correo"));
        descripciontxt.setText(intent.getString("descripcion"));
        telefonotxt.setText(String.valueOf(intent.getInt("telefono")));
    }


    @Override
    public void onClick(View v) {
        if(v==bfecha){
            final Calendar C=Calendar.getInstance();
            dia=C.get(Calendar.DAY_OF_MONTH);
            mes=C.get(Calendar.MONTH);
            ano=C.get(Calendar.YEAR);
            DatePickerDialog date= new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    efecha.setText(i+"/"+(i1+1)+"/"+i2);

                }
            },dia,mes,ano);
            date.show();

        }

    }
}