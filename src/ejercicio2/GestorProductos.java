package ejercicio2;

import java.util.ArrayList;
import java.util.List;

// Clase que implementa la interfaz ProductosInterfaz
class GestorProductos implements ProductoInterfaz {
    List<Producto> catalogo;

    public GestorProductos() {
        catalogo = new ArrayList<>();
    }

    // Método para agregar productos al catálogo
    public void agregarProducto(Producto producto) {
        catalogo.add(producto);
    }

    // Implementación del método de la interfaz para obtener el catálogo
    @Override
    public List<Producto> obtenerCatalogo() {
        return catalogo;
    }
}