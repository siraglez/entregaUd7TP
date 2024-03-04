package ejercicio2;

import java.util.ArrayList;
import java.util.List;

// Clase Cliente
class Cliente {
    String nombre;
    List<Producto> historialCompras;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.historialCompras = new ArrayList<>();
    }

    // Método para recibir recomendaciones personalizadas
    public List<Producto> obtenerRecomendaciones() {
        // Implementar algoritmo de recomendación personalizada aquí
        // Por ahora, devolvemos algunos libros como ejemplo
        List<Producto> recomendaciones = new ArrayList<>();
        recomendaciones.add(new Libro("Recomendacion1", 20.0, "Autor1"));
        recomendaciones.add(new Libro("Recomendacion2", 25.0, "Autor2"));
        return recomendaciones;
    }

    // Método para agregar una compra al historial
    public void agregarCompra(Producto producto) {
        historialCompras.add(producto);
    }
}