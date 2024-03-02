package ejercicio1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DadoIA {
    private int caras;
    private Map<Integer, Integer> frecuencias;

    public DadoIA(int caras) {
        this.caras = caras;
        this.frecuencias = new HashMap<>();
        for (int i = 1; i <= caras; i++) {
            frecuencias.put(i, 0);
        }
    }

    public int lanzar() {
        Random random = new Random();
        int resultado = random.nextInt(caras) + 1;
        actualizarFrecuencia(resultado);
        return resultado;
    }

    private void actualizarFrecuencia(int resultado) {
        frecuencias.put(resultado, frecuencias.get(resultado) + 1);
    }

    public double probabilidad(int cara) {
        if (frecuencias.containsKey(cara)) {
            return (double) frecuencias.get(cara) / getLanzamientosTotales();
        } else {
            return 0.0;
        }
    }

    private int getLanzamientosTotales() {
        int lanzamientosTotales = 0;
        for (int frecuencia : frecuencias.values()) {
            lanzamientosTotales += frecuencia;
        }
        return lanzamientosTotales;
    }
}


