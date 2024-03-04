package ejercicio4;

import java.util.Scanner;

public class MicroGuerraBarcosIA {
    public static void main(String[] args) {
        CuadriculaIA cuadriculaJugador = new CuadriculaIA();
        CuadriculaIA cuadriculaComputadora = new CuadriculaIA();
        Scanner scanner = new Scanner(System.in);

        // Lógica del juego
        while (!juegoTerminado(cuadriculaJugador, cuadriculaComputadora)) {
            // Turno del jugador
            System.out.println("Turno del Jugador:");
            System.out.print("Ingrese la fila (0-9): ");
            int filaJugador = scanner.nextInt();
            System.out.print("Ingrese la columna (0-9): ");
            int columnaJugador = scanner.nextInt();
            cuadriculaJugador.turnoJugador(filaJugador, columnaJugador);

            // Turno de la computadora
            cuadriculaComputadora.turnoComputadora();

            // Mostrar el estado actual del juego
            cuadriculaJugador.mostrarCuadriculaJugador();
            cuadriculaComputadora.mostrarCuadriculaComputadora();
        }

        // Mostrar resultado final del juego
        System.out.println("Juego Terminado");
        if (cuadriculaJugador.todasLasCoordenadasHundidas()) {
            System.out.println("¡Has ganado! Todos los barcos de la computadora se han hundido.");
        } else {
            System.out.println("La computadora ha ganado. Todos tus barcos se han hundido.");
        }
    }

    private static boolean juegoTerminado(CuadriculaIA cuadriculaJugador, CuadriculaIA cuadriculaComputadora) {
        // Lógica para determinar si el juego ha terminado (Todos los barcos se han hundido)
        return cuadriculaJugador.todasLasCoordenadasHundidas() || cuadriculaComputadora.todasLasCoordenadasHundidas();
    }
}
