package ejercicio3;

import java.util.Random;

public class MicroGuerraBarcos {

    public static void main(String[] args) {
        int tamanoX = 10;
        int tamanoY = 10;
        int numBarcos = 5;

        // Utilizando Cuadricula
        Cuadricula cuadricula = new Cuadricula(tamanoX, tamanoY);
        cuadricula.mostrarTablero(); // Muestra el estado inicial

        // Colocar barcos en posiciones aleatorias
        colocarBarcosAleatorios(cuadricula, numBarcos);

        System.out.println("------ Batalla Inicia ------");
        // Realizar ataques o acciones del juego
        realizarAtaques(cuadricula);

        System.out.println("------ Estado Final ------");
        cuadricula.mostrarTablero(); // Muestra el estado final después de los ataques

        System.out.println("----------------------------------");

        // Utilizando CuadriculaAvanzada
        CuadriculaAvanzada cuadriculaAvanzada = new CuadriculaAvanzada(tamanoX, tamanoY);
        cuadriculaAvanzada.mostrarEstado(); // Muestra el estado inicial con simulación ambiental

        // Colocar barcos en posiciones aleatorias
        colocarBarcosAleatorios(cuadriculaAvanzada, numBarcos);

        System.out.println("------ Batalla con Simulación Ambiental ------");
        // Realizar ataques o acciones del juego con simulación ambiental
        realizarAtaquesConSimulacion(cuadriculaAvanzada);

        System.out.println("------ Estado Final con Simulación Ambiental ------");
        cuadriculaAvanzada.mostrarEstado(); // Muestra el estado final con simulación ambiental
    }

    private static void colocarBarcosAleatorios(Cuadricula cuadricula, int numBarcos) {
        Random random = new Random();
        for (int i = 0; i < numBarcos; i++) {
            int x = random.nextInt(cuadricula.getTamanioX());
            int y = random.nextInt(cuadricula.getTamanioY());
            cuadricula.colocarBarco(x, y);
        }
    }

    private static void realizarAtaques(Cuadricula cuadricula) {
        Random random = new Random();
        int numAtaques = 10; // Número de ataques aleatorios

        System.out.println("Realizando Ataques sin Simulación Ambiental:");

        for (int i = 0; i < numAtaques; i++) {
            int x = random.nextInt(cuadricula.getTamanioX());
            int y = random.nextInt(cuadricula.getTamanioY());

            System.out.println("Ataque en (" + x + ", " + y + ")");
            cuadricula.atacarCelda(x, y);
        }
    }

    private static void realizarAtaquesConSimulacion(CuadriculaAvanzada cuadriculaAvanzada) {
        Random random = new Random();
        int numAtaques = 10; // Número de ataques aleatorios

        System.out.println("Realizando Ataques con Simulación Ambiental:");

        for (int i = 0; i < numAtaques; i++) {
            int x = random.nextInt(cuadriculaAvanzada.getTamanioX());
            int y = random.nextInt(cuadriculaAvanzada.getTamanioY());

            System.out.println("Ataque en (" + x + ", " + y + ")");
            cuadriculaAvanzada.atacarCelda(x, y);
        }
    }

}
