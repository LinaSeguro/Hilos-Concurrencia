package com.iudigital.conhilos;

import com.iudigital.clienteproducto.ClienteProducto;
import com.iudigital.clienteproducto.Producto;

public class CajeraProductoHilo extends Thread {

    private String nombreCajera;
    private ClienteProducto cliente;
    private double total; //Total de la compra
    private long tiempoTotal; // Tiempo total de procesamiento

    public CajeraProductoHilo(String nombre, ClienteProducto cliente) {
        this.nombreCajera = nombre;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        long tiempoInicio = System.currentTimeMillis(); // Captura el tiempo de inicio del procesamiento

        System.out.println("La cajera " + this.nombreCajera + " comienza a procesar la compra del cliente "
                + cliente.getNombre() + " en el tiempo " + (System.currentTimeMillis() - tiempoInicio) / 1000
                + " seg");

        double total = 0;
        int contProducto = 1;  // Contador para el número de producto

        for (Producto producto : cliente.getProductos()) {

            try {
                Thread.sleep((long) (producto.getCantidad() * 1000)); // Simula el tiempo de procesamiento en segundos
                total += producto.getPrecio() * producto.getCantidad();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Procesando el producto " + contProducto
                    + " del cliente " + cliente.getNombre()
                    + " producto " + producto.getNombre()
                    + " precio producto " + producto.getPrecio()
                    + " cantidad  " + producto.getCantidad()
                    + " costo total del producto " + producto.getCantidad() * producto.getPrecio()
                    + " ->Tiempo: " + (System.currentTimeMillis() - tiempoInicio) / 1000 + " seg");


            contProducto++;
        }

        System.out.println("La cajera " + this.nombreCajera
                + " ha terminado de procesar " + cliente.getNombre()
                + " con un total a pagar de $" + total
                + " en el tiempo: " + (System.currentTimeMillis() - tiempoInicio) / 1000 + " seg");

    }

    
}
