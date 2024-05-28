package com.iudigital.sinhilos;

import com.iudigital.domain.ClienteProducto;
import com.iudigital.domain.Producto;

public class CajeraProducto {

    private String nombreCajera;

    public CajeraProducto(String nombre) {
        this.nombreCajera = nombre;
    }

    public void procesarCompra(ClienteProducto cliente, long tiempoInicio ) {
        System.out.println("\n");
         System.out.println("La cajera " + this.nombreCajera + " Comienza a procesar la compra del cliente "
            + cliente.getNombre() + " en el tiempo " + (System.currentTimeMillis() - tiempoInicio) / 1000
            + " seg ");
        double total = 0;
        
        int contCliente = 1;  // Contador para el número de producto
        for (Producto producto : cliente.getProductos()) {
            esperarXSegundos(); // Espera fija de 1 segundo
            System.out.println("Procesando el producto " + contCliente);
            System.out.println("Nombre del producto: " + producto.getNombre());
            System.out.println("Precio del producto: " + producto.getPrecio());
            System.out.println("Cantidad de productos: " + producto.getCantidad());
            System.out.println("Costo total del producto: " + producto.getCantidad() * producto.getPrecio());
            System.out.println("Tiempo: " + (System.currentTimeMillis() - tiempoInicio) / 1000 + " seg");
            System.out.println();

            
            total += producto.getPrecio() * producto.getCantidad();
            contCliente++;
        }
        System.out.println("La cajera " + this.nombreCajera
                + " ha terminado de procesar " + cliente.getNombre()
                + " con un total a pagar de $" + total
                + " en el tiempo: " + (System.currentTimeMillis() - tiempoInicio) / 1000 + " seg");

    }

    private void esperarXSegundos() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El hilo fue interrumpido mientras esperaba.");
        }
    }
}
