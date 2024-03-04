package ejercicio2;

// Clase abstracta para productos
abstract class Producto {
    String nombre;
    double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    abstract String getTipo();
}