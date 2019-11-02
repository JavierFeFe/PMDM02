package com.example.pmdm02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText editTextUsuario, editTextPass;
    private TextView textError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUsuario = (EditText) findViewById(R.id.editTextUsuario);
        editTextPass = (EditText) findViewById(R.id.editTextPassword);
        textError = (TextView) findViewById(R.id.textViewError);
    }
    /** Called when the user taps the Login button */
    public void realizaLogin(View view) {

        Intent intentCliente = new Intent(this, ClienteActivity.class);
        Intent intentAdmin = new Intent(this, AdminActivity.class);
        if (editTextUsuario.getText().toString().equals("admin") && editTextPass.getText().toString().equals("abc123.")){
            textoLogin(""); //Elimino texto por si se presiona el botón retroceder desde la Activity de cliente
            startActivity(intentAdmin);
        }else if (editTextUsuario.getText().toString().equals("cliente1") && editTextPass.getText().toString().equals("abc123.")){
            textoLogin(""); //Elimino texto por si se presiona el botón retroceder desde la Activity de admin
            startActivity(intentCliente);
        }else {
            textoLogin("¡¡Usuario o contraseña incorrectos!!");
        }
    }
    private void textoLogin(String error){ //Método para resetar el formulario

        editTextUsuario.setText("");
        editTextPass.setText("");
        textError.setText(error);
        editTextUsuario.requestFocus();
    }
}
