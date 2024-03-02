package ejercicio1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SimuladorDadosIA {
    public static void main(String[] args) {
        DadoIA dado1 = new DadoIA(6);
        DadoIA dado2 = new DadoIA(10);
        DadoIA dado3 = new DadoIA(12);

        int sumaDados = 0;

        while (sumaDados < 20) {
            int resultado1 = dado1.lanzar();
            int resultado2 = dado2.lanzar();
            int resultado3 = dado3.lanzar();

            //Procesar y mostrar resultados con preducciones de IA
            System.out.println("Lanzamiento dado 1: " + resultado1);
            System.out.println("Probabilidad dado 1, cara 1: " + dado1.probabilidad(1));

            System.out.println("Lanzamiento dado 2: " + resultado1);
            System.out.println("Probabilidad dado 2, cara 1: " + dado1.probabilidad(1));

            System.out.println("Lanzamiento dado 3: " + resultado1);
            System.out.println("Probabilidad dado 3, cara 1: " + dado1.probabilidad(1));

            sumaDados = resultado1 + resultado2 + resultado3;
            System.out.println("Suma de los dados: " + sumaDados);
        }
    }
}