package ejercicio2;

// Clase Libro que extiende Productos
class Libro extends Producto {
    String autor;

    public Libro(String nombre, double precio, String autor) {
        super(nombre, precio);
        this.autor = autor;
    }

    @Override
    String getTipo() {
        return "Libro";
    }
}