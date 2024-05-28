package com.iudigital.sinhilos;


import com.iudigital.domain.ClienteProducto;
import com.iudigital.domain.Producto;
import java.util.Arrays;

public class CajeraProductoPrincipal
{
    public static void main( String[] args )
    {
        // Crear algunos productos de tecnología
        Producto p1 = new Producto("Laptop", 1500000, 1);  
        Producto p2 = new Producto("Teléfono", 800000, 1); 
        Producto p3 = new Producto("Tablet", 500000, 2);   

        // Crear algunos clientes con productos
        ClienteProducto cliente1 = new ClienteProducto("Felipe", Arrays.asList(p1, p2));
        ClienteProducto cliente2 = new ClienteProducto("María", Arrays.asList(p2, p3));
        ClienteProducto cliente3 = new ClienteProducto("Andrés", Arrays.asList(p1, p3));

        // Crear cajera y procesar compras        
        CajeraProducto cajeraUno = new CajeraProducto("Cajera Ana");        
        CajeraProducto cajeraDos = new CajeraProducto("Cajera Paola");
        CajeraProducto cajeraTres = new CajeraProducto("Cajera Mariana");

        long initialTime = System.currentTimeMillis();// Captura el tiempo de inicio del procesamiento
        cajeraUno.procesarCompra(cliente1, initialTime);
        cajeraDos.procesarCompra(cliente2, initialTime);
        cajeraTres.procesarCompra(cliente3, initialTime);
        

        long finalTime = System.currentTimeMillis();// Captura el tiempo de finalización del procesamiento
        long tiempoTotal = (finalTime  - initialTime) / 1000; // Calcula el tiempo total de procesamiento en segundos
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Tiempo total de procesamiento de todas las compras: " + tiempoTotal + " segundos");
        System.out.println("---------------------------------------------------------------------");

    }

}
