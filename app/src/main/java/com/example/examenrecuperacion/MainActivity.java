package com.example.examenrecuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtCodigo;
    private EditText txtDescripcion;
    private EditText txtUnidad;
    private EditText txtVenta;
    private EditText txtCompra;
    private EditText txtCantidad;
    private Button btnLimpiar;
    private Button btnSiguiente;
    private Button btnSalir;
    private EntradaProducto ent = new EntradaProducto();
    private void salir(){
        AlertDialog.Builder confirmar = new AlertDialog.Builder(this);
        confirmar.setTitle("¿Desea cerrar la aplicacion?");
        confirmar.setMessage("Esta accion eliminara toda la informacion");
        confirmar.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                aceptar();
            }
        });
        confirmar.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        confirmar.show();
    }
    private void aceptar(){
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniciar();
        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtCodigo.setText("");
                txtDescripcion.setText("");
                txtUnidad.setText("");
                txtVenta.setText("");
                txtCompra.setText("");
                txtCantidad.setText("");
            }
        });

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtCantidad.getText().toString().matches("")||txtCodigo.getText().toString().matches("")||txtCompra.getText().toString().matches("")||
                txtDescripcion.getText().toString().matches("")||txtUnidad.getText().toString().matches("")||txtVenta.getText().toString().matches("")){
                    Toast.makeText(MainActivity.this,
                            "Falta completar la informacion",
                            Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this,EntradaProductoActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("ent", ent);
                    intent.putExtras(bundle);
                    intent.putExtra ( "TextCantidad", txtCantidad.getText().toString() );
                    intent.putExtra ( "TextDesc", txtDescripcion.getText().toString() );
                    intent.putExtra ( "TextCompra", txtCompra.getText().toString() );
                    intent.putExtra ( "TextVenta", txtVenta.getText().toString() );
                    startActivity(intent);
                }
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salir();
            }
        });
    }


    public void iniciar(){
        txtCodigo = (EditText) findViewById(R.id.txtCodigo);
        txtDescripcion = (EditText) findViewById(R.id.txtDesc);
        txtUnidad = (EditText) findViewById(R.id.txtUnidad);
        txtVenta = (EditText) findViewById(R.id.txtVenta);
        txtCompra = (EditText) findViewById(R.id.txtCompra);
        txtCantidad = (EditText) findViewById(R.id.txtCantidad);
        btnLimpiar = (Button) findViewById(R.id.btnLimpiar);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        btnSalir = (Button) findViewById(R.id.btnSalir);
    }
}