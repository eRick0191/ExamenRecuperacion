package com.example.examenrecuperacion;

public class EntradaProducto {
    private int cantidad;
    private float compra;
    private float venta;

    public EntradaProducto(int cantidad, float compra, float venta) {
        this.cantidad = cantidad;
        this.compra = compra;
        this.venta = venta;
    }

    public EntradaProducto(){

    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getCompra() {
        return compra;
    }

    public void setCompra(float compra) {
        this.compra = compra;
    }

    public float getVenta() {
        return venta;
    }

    public void setVenta(float venta) {
        this.venta = venta;
    }

    public float calcularPrecioVenta(){
        return venta*cantidad;
    }

    public float calcularPrecioCompra(){
        return compra*cantidad;
    }

    public float calcularGanancia(){
        return calcularPrecioVenta() - calcularPrecioCompra();
    }
}
