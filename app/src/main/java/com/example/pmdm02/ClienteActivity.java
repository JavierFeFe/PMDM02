package com.example.pmdm02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ClienteActivity extends AppCompatActivity {
    public static final String NOMBRE = "com.example.pdm02.NOMBRE"; //Creo una variable para compartir con las demás Activity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
    }
    public void hacerPedido(View view) {
        TextView textViewNombre = (TextView) findViewById(R.id.textViewNombre);
        String nombre = textViewNombre.getText().toString();
        Intent hacerPedido = new Intent(this, HacerPedidoActivity.class); //Capturo el nombre del cliente para ponerlo en la página de pedidos
        hacerPedido.putExtra(NOMBRE,nombre);
        startActivity(hacerPedido);
    }
    public void verPedidos(View view) {
        Intent verPedidos = new Intent(this, VerPedidos.class);
        startActivity(verPedidos);
    }
    public void verCompras(View view) {
        Intent verCompras = new Intent(this, VerCompras.class);
        startActivity(verCompras);
    }
    public void salir(View view){
        super.onBackPressed();
       Intent login = new Intent(this, MainActivity.class);
       login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
       startActivity(login);
    }
}
