package com.example.pmdm02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HacerPedidoActivity extends AppCompatActivity {
    public static final String NOMBRE = "com.example.pdm02.NOMBRE";
    public static final String CATEGORIA = "com.example.pdm02.CATEGORIA";
    public static final String ARTICULO = "com.example.pdm02.ARTICULO";
    public static final String CANTIDAD = "com.example.pdm02.CANTIDAD";
    private String nombre;
    private Spinner categorias, articulos, cantidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hacer_pedido);

        Intent intent = getIntent();
        this.nombre = intent.getStringExtra(ClienteActivity.NOMBRE); //Capturo la variable nombre de ClienteActivity
        TextView titulo = (TextView)findViewById(R.id.textViewTitulo);
        titulo.setText("Pedido para " + nombre); //Cambio el título con el nombre capturado


        List<String> listInformatica = new ArrayList<String>(); //Creo un List con todos loa articulos de la categoría informática
        listInformatica.add("Pc Sobremesa");
        listInformatica.add("Portátil");
        listInformatica.add("Monitor");
        final ArrayAdapter<String> informatica = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listInformatica);
        informatica.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //Creo un ArrayAdapter para introducir en el Spinner

        List<String> listElectronica = new ArrayList<String>(); //Creo un List con todos loa articulos de la categoría electrónica
        listElectronica.add("Televisión");
        listElectronica.add("DVD");
        final ArrayAdapter<String> electronica = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listElectronica);
        electronica.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //Creo un ArrayAdapter para introducir en el Spinner

        List<String> listMoviles = new ArrayList<String>(); //Creo un List con todos loa articulos de la categoría móviles
        listMoviles.add("Pixel");
        listMoviles.add("Galaxy");
        listMoviles.add("Iphone");
        listMoviles.add("Xiaomi");
        final ArrayAdapter<String> moviles = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMoviles);
        moviles.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); //Creo un ArrayAdapter para introducir en el Spinner


        this.categorias = (Spinner)findViewById(R.id.spinnerCategoria);
        this.cantidad = (Spinner)findViewById(R.id.spinnerCantidad);
        categorias.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //Capturo el evento de cambio de valor del spinner
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                articulos = (Spinner)findViewById(R.id.spinnerArticulo);

                switch (i){ //Cargo la lista del spinner de artículos en función del valor de categoria
                    case 0:
                        articulos.setAdapter(informatica);
                    break;
                    case 1:
                        articulos.setAdapter(electronica);
                    break;
                    case 2:
                        articulos.setAdapter(moviles);
                    break;
                    default:
                        articulos.setAdapter(null);
                    break;
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }

    public void realizarPedido(View view){
        Intent direccionPedido = new Intent(this, DireccionPedido.class);
        String cat = categorias.getSelectedItem().toString();
        System.out.println("Categoria: " + cat);
        String art = articulos.getSelectedItem().toString();
        String can = this.cantidad.getSelectedItem().toString();
        //Capturo todas las variables necesarias para la siguiente activity
        direccionPedido.putExtra(NOMBRE, nombre);
        direccionPedido.putExtra(CATEGORIA, cat);
        direccionPedido.putExtra(ARTICULO, art);
        direccionPedido.putExtra(CANTIDAD, can);

        startActivity(direccionPedido);

    }

}
