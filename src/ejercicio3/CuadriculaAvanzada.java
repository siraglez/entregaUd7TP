package ejercicio3;

import java.util.Random;

public class CuadriculaAvanzada extends Cuadricula {
    //Clase mejorada con simulación ambiental
    private double factorClima;
    private double factorCorrientes;

    public CuadriculaAvanzada(int tamanioX, int tamanioY) {
        super(tamanioX, tamanioY);
        this.factorClima = factorClima;
        this.factorCorrientes = factorCorrientes;
    }

    private double generarFactorAleatorio() {
        Random random = new Random();
        return 0.5 + random.nextDouble();
    }

    // Métodos adicionales para la simulación ambiental
    public double getFactorClima() {
        return factorClima;
    }

    public double getFactorCorrientes() {
        return factorCorrientes;
    }

    public void actualizarSimulacionAmbiental(double nuevoFactorClima, double nuevoFactorCorrientes) {
        this.factorClima = nuevoFactorClima;
        this.factorCorrientes = nuevoFactorCorrientes;
    }

    public double obtenerVelocidadCorriente() {
        // Calcula la velocidad de la corriente en función del factor de corrientes
        return factorCorrientes * 10; // Ejemplo
    }

    public void modificarFactorClima(double cambio) {
        this.factorClima += cambio;
    }

    public double calcularInfluenciaClimaticaEnAtaque() {
        // Calcula cómo el factor de clima afecta a la precisión de los ataques, por ejemplo
        return factorClima * 0.8; // Ejemplo
    }

    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Factor de Clima: " + factorClima);
        System.out.println("Factor de Corrientes: " + factorCorrientes);
    }
}
