package com.example.examenrecuperacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EntradaProductoActivity extends AppCompatActivity {
    private TextView txtProducto;
    private EditText txtTotalV;
    private EditText txtTotalC;
    private EditText txtTotalG;
    private Button btnRegresar;
    private Button btnCalcular;
    EntradaProducto ent = new EntradaProducto();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada_producto);
        iniciar();
        txtTotalC.setFocusable(false);
        txtTotalG.setFocusable(false);
        txtTotalV.setFocusable(false);
        Bundle datos = getIntent().getExtras();
        EntradaProducto ent = (EntradaProducto) datos.getSerializable("ent");
        txtProducto.setText(ent.getDescripcion()+ent.getCodigo());
        Intent i = getIntent();
        String textDescripcion = i.getStringExtra("TextDesc");
        String textVenta = i.getStringExtra("TextVenta");
        String textCompra = i.getStringExtra("TextCompra");
        String textCantidad = i.getStringExtra("TextCantidad");

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                float compra =Float.parseFloat(textCompra);
                float venta = Float.parseFloat(textVenta);
                int cantidad = Integer.parseInt(textCantidad);
                ent.setCantidad(cantidad);
                ent.setCompra(compra);
                ent.setVenta(venta);
                txtTotalC.setText(String.valueOf(ent.calcularPrecioCompra()));
                txtTotalV.setText(String.valueOf(ent.calcularPrecioVenta()));
                txtTotalG.setText(String.valueOf(ent.calcularGanancia()));
            }
        });

        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void iniciar(){
        txtProducto = (TextView) findViewById(R.id.txtProducto);
        txtTotalV = (EditText) findViewById(R.id.txtTotalV);
        txtTotalC = (EditText) findViewById(R.id.txtTotalC);
        txtTotalG = (EditText) findViewById(R.id.txtTotalG);
        btnRegresar = (Button) findViewById(R.id.btnRegresar);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
    }
}