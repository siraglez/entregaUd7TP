package ejercicio3;

import java.util.Random;

public class Cuadricula {
    //Clase base para la cuadrícula de la micro guerra de barcos
    private int tamanioX;
    private int tamanioY;
    private EstadoCelda[][] estadoCeldas;

    public Cuadricula(int tamanioX, int tamanioY) {
        this.tamanioX = tamanioX;
        this.tamanioY = tamanioY;
        this.estadoCeldas = new EstadoCelda[tamanioX][tamanioY];
        inicializarCuadricula();
    }

    public int getTamanioX() {
        return tamanioX;
    }

    public int getTamanioY() {
        return tamanioY;
    }

    public EstadoCelda[][] getEstadoCeldas() {
        return estadoCeldas;
    }

    public void mostrarEstado() {
        System.out.println("Estado de la Cuadricula");
        System.out.println("Tamaño X: " + tamanioX);
        System.out.println("Tamaño Y: " + tamanioY);
        // Puedes agregar más detalles según tus necesidades
    }

    private void inicializarCuadricula() {
        for (int i = 0; i < tamanioX; i++) {
            for (int j = 0; j < tamanioY; j++) {
                estadoCeldas[i][j] = EstadoCelda.AGUA;
            }
        }
    }

    public void colocarBarco(int x, int y) {
        if (coordenadasValidas(x, y)) {
            estadoCeldas[x][y] = EstadoCelda.BARCO;
        }
    }

    public void atacarCelda(int x, int y) {
        if (coordenadasValidas(x, y)) {
            if (estadoCeldas[x][y] == EstadoCelda.BARCO) {
                estadoCeldas[x][y] = EstadoCelda.HUNDIDO;
            } else if (estadoCeldas[x][y] == EstadoCelda.AGUA) {
                estadoCeldas[x][y] = EstadoCelda.TOCADO;
            }
        }
    }

    public boolean verificarHundimiento() {
        for (int i = 0; i < tamanioX; i++) {
            for (int j = 0; j < tamanioY; j++) {
                if (estadoCeldas[i][j] == EstadoCelda.BARCO) {
                    return false; // Todavía hay al menos un barco no hundido
                }
            }
        }
        return true; // Todos los barcos han sido hundidos
    }

    public EstadoCelda obtenerEstadoCelda(int x, int y) {
        if (coordenadasValidas(x, y)) {
            return estadoCeldas[x][y];
        }
        return null; // Devuelve null si las coordenadas no son válidas
    }

    public void mostrarTablero() {
        for (int i = 0; i < tamanioX; i++) {
            for (int j = 0; j < tamanioY; j++) {
                System.out.print(estadoCeldas[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void reiniciarCuadricula() {
        inicializarCuadricula();
    }

    public static Cuadricula generarCuadriculaAleatoria(int tamanoX, int tamanoY, int numBarcos) {
        Cuadricula cuadriculaAleatoria = new Cuadricula(tamanoX, tamanoY);
        Random random = new Random();

        for (int i = 0; i < numBarcos; i++) {
            int x = random.nextInt(tamanoX);
            int y = random.nextInt(tamanoY);
            cuadriculaAleatoria.colocarBarco(x, y);
        }

        return cuadriculaAleatoria;
    }

    public boolean coordenadasValidas(int x, int y) {
        return x >= 0 && x < tamanioX && y >= 0 && y < tamanioY;
    }
}
