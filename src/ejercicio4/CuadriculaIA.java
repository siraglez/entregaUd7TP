package ejercicio4;

import java.util.Random;

public class CuadriculaIA {
    private char[][] cuadricula;
    private boolean[][] disparosJugador;
    private boolean[][] disparosComputadora;
    private Random random;

    public CuadriculaIA() {
        cuadricula = new char[10][10];
        disparosJugador = new boolean[10][10];
        disparosComputadora = new boolean[10][10];
        random = new Random();

        // Inicializar cuadrículas
        inicializarCuadriculas();
    }

    private void inicializarCuadriculas() {
        // Código para inicializar las cuadrículas con barcos u otros elementos según tu lógica
        // En este ejemplo, se colocan algunos barcos aleatorios
        for (int i = 0; i < 5; i++) {
            int fila = random.nextInt(10);
            int columna = random.nextInt(10);
            cuadricula[fila][columna] = 'B'; // 'B' representa un barco
        }
    }

    public void mostrarCuadriculaJugador() {
        // Código para mostrar la cuadrícula del jugador
        System.out.println("Cuadrícula del Jugador:");
        mostrarCuadricula(cuadricula);
    }

    public void mostrarCuadriculaComputadora() {
        // Código para mostrar la cuadrícula de la computadora (ocultando barcos y mostrando resultados de disparos)
        System.out.println("Cuadrícula de la Computadora:");
        char[][] cuadriculaVisible = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (disparosComputadora[i][j]) {
                    cuadriculaVisible[i][j] = cuadricula[i][j] == 'B' ? 'X' : 'O'; // 'X' si acertó en un barco, 'O' si falló
                } else {
                    cuadriculaVisible[i][j] = '~'; //representa una celda no disparada
                }
            }
        }
        mostrarCuadricula(cuadriculaVisible);
    }

    private void mostrarCuadricula(char[][] cuadricula) {
        // Método auxiliar para mostrar la cuadrícula
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(cuadricula[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void turnoJugador(int fila, int columna) {
        // Lógica del turno del jugador, actualizar cuadrícula y verificar si se hundió algún barco
        if (validarCoordenadas(fila, columna) && !disparosJugador[fila][columna]) {
            disparosJugador[fila][columna] = true;
            if (cuadricula[fila][columna] == 'B') {
                System.out.println("¡Has acertado en un barco!");
            } else {
                System.out.println("Agua. No has alcanzado ningún barco.");
            }
        } else {
            System.out.println("Coordenadas inválidas o ya disparaste en esta posición. Inténtalo de nuevo.");
        }
    }

    public void turnoComputadora() {
        // Estrategia de IA para el turno de la computadora, realizar un disparo y adaptar la estrategia
        int fila = random.nextInt(10);
        int columna = random.nextInt(10);

        if (!disparosComputadora[fila][columna]) {
            disparosComputadora[fila][columna] = true;
            if (cuadricula[fila][columna] == 'B') {
                System.out.println("¡La Computadora ha acertado en un barco!");
            } else {
                System.out.println("La Computadora ha disparado al agua. No ha alcanzado ningún barco.");
            }
        } else {
            // Repetir el turno si ya disparó en esa posición
            turnoComputadora();
        }
    }

    private boolean validarCoordenadas(int fila, int columna) {
        return fila >= 0 && fila < 10 && columna >= 0 && columna < 10;
    }

    public boolean todasLasCoordenadasHundidas() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (cuadricula[i][j] == 'B' && !disparosJugador[i][j]) {
                    return false; // Si hay al menos un barco no hundido, retorna false
                }
            }
        }
        return true; // Si no se encontraron barcos no hundidos, retorna true
    }


}
