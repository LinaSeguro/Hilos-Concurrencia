package com.iudigital.conhilos;

import com.iudigital.domain.ClienteProducto;
import com.iudigital.domain.Producto;

import java.util.Arrays;
import java.util.List;

public class CajeraProductoPrincipalHilo {
    public static void main(String[] args) {
        // Crear algunos productos
        Producto p1 = new Producto("Laptop", 1500000, 1); 
        Producto p2 = new Producto("Teléfono", 800000, 1); 
        Producto p3 = new Producto("Tablet", 500000, 2);   

        // Crear algunos clientes con productos
        List<Producto> productosCliente1 = Arrays.asList(p1, p2);
        ClienteProducto cliente1 = new ClienteProducto("Felipe", productosCliente1);

        List<Producto> productosCliente2 = Arrays.asList(p2, p3);
        ClienteProducto cliente2 = new ClienteProducto("María", productosCliente2);

        List<Producto> productosCliente3 = Arrays.asList(p1, p3);
        ClienteProducto cliente3 = new ClienteProducto("Andrés ", productosCliente3);

        // Crear hilos para cada cajera y cliente
        CajeraProductoHilo cajera1 = new CajeraProductoHilo("Cajera Ana", cliente1);
        CajeraProductoHilo cajera2 = new CajeraProductoHilo("Cajera Paola", cliente2);
        CajeraProductoHilo cajera3 = new CajeraProductoHilo("Cajera Mariana", cliente3);
        
        // Capturar el tiempo inicial
        long tiempoInicio = System.currentTimeMillis();

        // Iniciar los hilos
        cajera1.start();
        cajera2.start();
        cajera3.start();

        // Esperar a que todos los hilos terminen
        try {
            cajera1.join();
            cajera2.join();
            cajera3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       // Capturar el tiempo final
        long tiempoFinal = System.currentTimeMillis();

        // Calcular el tiempo total de procesamiento
        long tiempoTotal = (tiempoFinal - tiempoInicio) / 1000;

       
        // Imprimir el tiempo de ejecución
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("Tiempo total de procesamiento de todas las compras : " + tiempoTotal + " segundos");
        System.out.println("--------------------------------------------------------------------------------------");


    }
}





