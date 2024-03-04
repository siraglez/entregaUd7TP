package ejercicio2;

import java.util.List;

// Algoritmo principal
public class Main {
    public static void main(String[] args) {
        // Crear gestor de productos
        GestorProductos gestorProductos = new GestorProductos();

        // Agregar algunos libros al catálogo
        gestorProductos.agregarProducto(new Libro("Libro1", 15.0, "Autor1"));
        gestorProductos.agregarProducto(new Libro("Libro2", 18.0, "Autor2"));
        gestorProductos.agregarProducto(new Libro("Libro3", 22.0, "Autor3"));

        // Crear cliente
        Cliente cliente = new Cliente("Cliente1");

        // Mostrar catálogo
        System.out.println("Catálogo de productos:");
        List<Producto> catalogo = gestorProductos.obtenerCatalogo();
        for (Producto producto : catalogo) {
            System.out.println(producto.getTipo() + ": " + producto.nombre + " - Precio: " + producto.precio);
        }

        // Simular una compra
        cliente.agregarCompra(catalogo.get(0));

        // Obtener recomendaciones personalizadas
        System.out.println("\nRecomendaciones para " + cliente.nombre + ":");
        List<Producto> recomendaciones = cliente.obtenerRecomendaciones();
        for (Producto recomendacion : recomendaciones) {
            System.out.println(recomendacion.getTipo() + ": " + recomendacion.nombre + " - Precio: " + recomendacion.precio);
        }
    }
}