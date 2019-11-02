package com.example.pmdm02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DireccionPedido extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_direccion_pedido);
    }
    public void finalizarPedido(View view){
        Context context = getApplicationContext();

        EditText etDir = findViewById(R.id.editTextDireccion);
        EditText etCid = findViewById(R.id.editTextCiudad);
        EditText etCp = findViewById(R.id.editTextCP);

        Intent intent = getIntent();
        String categoria = intent.getStringExtra(HacerPedidoActivity.CATEGORIA); //Capturo la variable categoria de HacerPedidoActivity
        String articulo = intent.getStringExtra(HacerPedidoActivity.ARTICULO); //Capturo la variable categoria de HacerPedidoActivity
        String cantidad = intent.getStringExtra(HacerPedidoActivity.CANTIDAD); //Capturo la variable cantidad de HacerPedidoActivity
        String direccion = etDir.getText().toString();
        String ciudad = etCid.getText().toString();
        String cp = etCp.getText().toString();
        CharSequence text = "Pedido: " + categoria + " - " + articulo + " - "
                + " (" + cantidad + ")\n" + "Dirección: " + direccion + " (" + cp + ") " + ciudad;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent intentCliente = new Intent(this, ClienteActivity.class);
        intentCliente.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intentCliente);
    }
}
