package com.barbaro.mitiendieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.barbaro.mitiendieapp.models.Producto;

public class FormAgregarActivity extends AppCompatActivity {

    private EditText inputNombre;
    private EditText inputDes;
    private EditText inputCantidad;
    private EditText inputPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_agregar);

        // Proceso de inflado
        inputNombre = findViewById(R.id.inputNombre);
        inputDes = findViewById(R.id.inputDes);
        inputCantidad = findViewById(R.id.inputCantidad);
        inputPrecio = findViewById(R.id.inputPrecio);

        Button btnAgregar = findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recuperarDatos();
            }
        });
    }

    private void recuperarDatos() {
        String nombre = inputNombre.getText().toString();
        String descripcion = inputDes.getText().toString();
        String cantidad = inputCantidad.getText().toString();
        String precio = inputPrecio.getText().toString();

        if(!nombre.isEmpty() &&
            !cantidad.isEmpty() && !precio.isEmpty()){

            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setDescripcion(descripcion);
            producto.setCantidad(Integer.parseInt(cantidad));
            producto.setPrecio(Float.parseFloat(precio));

        }else{
            Toast.makeText(this, "Completa los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
