link al repositorio: https://github.com/siraglez/entregaUd7TP.git

# Ejercicio 1: Simulador de Dados con IA

Este proyecto en Java simula el lanzamiento de tres dados con diferentes números de caras y calcula la probabilidad de obtener la cara número 1 en cada dado.

## 1. Clase `DadoIA`

### 1.1. Variables de instancia:

- `caras`: Número de caras del dado.
- `frecuencias`: Mapa que registra la frecuencia de cada cara después de los lanzamientos.

### 1.2. Constructor `DadoIA(int caras)`:

Inicializa las variables de instancia y crea un mapa `frecuencias` con las caras del dado inicializadas a 0.

### 1.3. Método `lanzar()`:

Simula el lanzamiento del dado utilizando un objeto `Random`. Actualiza la frecuencia de la cara obtenida llamando al método `actualizarFrecuencia()`. Devuelve el resultado del lanzamiento.

### 1.4. Método privado `actualizarFrecuencia(int resultado)`:

Incrementa la frecuencia de la cara específica en el mapa `frecuencias`.

### 1.5. Método `probabilidad(int cara)`:

Calcula la probabilidad de obtener una cara específica dividiendo la frecuencia de esa cara entre el total de lanzamientos.

### 1.6. Método privado `getLanzamientosTotales()`:

Calcula el número total de lanzamientos sumando todas las frecuencias en el mapa.

## 2. Clase `SimuladorDadosIA`

### 2.1. Método `main(String[] args)`:

* Crea tres objetos de la clase `DadoIA` con diferentes números de caras.
* Utiliza un bucle `while` para realizar lanzamientos hasta que la suma de los resultados sea mayor o igual a 20.
* En cada iteración, lanza los tres dados, muestra los resultados y las probabilidades de obtener la cara 1 en cada dado, y calcula la suma de los resultados.

En resumen, este código simula lanzamientos de tres dados con diferentes números de caras, mantiene un registro de la frecuencia de cada cara y calcula la probabilidad de obtener la cara número 1 en cada dado. La simulación se repite hasta que la suma de los resultados alcanza un umbral predefinido (20 en este caso).

# Pseudocódigo

```java
#Clase DadoIA
Clase DadoIA {
    #Variables de instancia
    Entero caras
    Mapa<Integer, Integer> frecuencias

    #Constructor
    DadoIA(Entero caras) {
        this.caras = caras
        this.frecuencias = nuevo Mapa<Integer, Integer>()
        Para cada i desde 1 hasta caras {
            frecuencias.put(i, 0)
        }
    }

    #Método para lanzar el dado
    Entero lanzar() {
        Random random = nuevo Random()
        Entero resultado = random.nextInt(caras) + 1
        actualizarFrecuencia(resultado)
        devolver resultado
    }

    #Método privado para actualizar la frecuencia
    Procedimiento actualizarFrecuencia(Entero resultado) {
        frecuencias.put(resultado, frecuencias.get(resultado) + 1)
    }

    #Método para obtener la probabilidad de una cara específica
    Real probabilidad(Entero cara) {
        Si frecuencias.contiene(cara) entonces
            devolver (Real) frecuencias.get(cara) / getLanzamientosTotales()
        Sino
            devolver 0.0
    }

    #Método privado para obtener el total de lanzamientos
    Entero getLanzamientosTotales() {
        Entero lanzamientosTotales = 0
        Para cada frecuencia en frecuencias.valores() {
            lanzamientosTotales += frecuencia
        }
        devolver lanzamientosTotales
    }
}

#Clase SimuladorDadosIA
Clase SimuladorDadosIA {
    #Método principal
    Procedimiento principal() {
        DadoIA dado1 = nuevo DadoIA(6)
        DadoIA dado2 = nuevo DadoIA(10)
        DadoIA dado3 = nuevo DadoIA(12)

        Entero sumaDados = 0

        Mientras sumaDados < 20 Hacer {
            Entero resultado1 = dado1.lanzar()
            Entero resultado2 = dado2.lanzar()
            Entero resultado3 = dado3.lanzar()

            #Procesar y mostrar resultados con predicciones de IA
            Mostrar "Lanzamiento dado 1: " + resultado1
            Mostrar "Probabilidad dado 1, cara 1: " + dado1.probabilidad(1)

            Mostrar "Lanzamiento dado 2: " + resultado2
            Mostrar "Probabilidad dado 2, cara 1: " + dado2.probabilidad(1)

            Mostrar "Lanzamiento dado 3: " + resultado3
            Mostrar "Probabilidad dado 3, cara 1: " + dado3.probabilidad(1)

            sumaDados = resultado1 + resultado2 + resultado3
            Mostrar "Suma de los dados: " + sumaDados
        }
    }
}

```


# Ejercicio 3: Micro Guerra de Barcos

Este código representa una implementación básica de un juego de "Micro Guerra de Barcos" utilizando las clases `Cuadricula` y `CuadriculaAvanzada`.

## 1. `EstadoCelda` (Enum)

Define un enumerador llamado `EstadoCelda` que representa los posibles estados de una celda en la cuadrícula: AGUA, BARCO, TOCADO, y HUNDIDO.

## 2. `Cuadricula` (Clase Base)

- **Atributos:**

  - `tamanioX` y `tamanioY`: Representan las dimensiones de la cuadrícula.
  - `estadoCeldas`: Es una matriz que almacena el estado de cada celda.
- **Métodos:**

  - `Cuadricula(int tamanioX, int tamanioY)`: Constructor que inicializa la cuadrícula con las dimensiones especificadas.
  - `mostrarEstado()`: Muestra el estado general de la cuadrícula.
  - `inicializarCuadricula()`: Inicializa todas las celdas de la cuadrícula como AGUA.
  - `colocarBarco(int x, int y)`: Coloca un barco en la posición especificada.
  - `atacarCelda(int x, int y)`: Realiza un ataque a la celda especificada y actualiza su estado según el resultado.
  - `verificarHundimiento()`: Verifica si todos los barcos han sido hundidos.
  - `obtenerEstadoCelda(int x, int y)`: Obtiene el estado de una celda en las coordenadas dadas.
  - `mostrarTablero()`: Muestra el tablero completo con los estados de las celdas.
  - `reiniciarCuadricula()`: Reinicia la cuadrícula volviendo a inicializar todas las celdas como AGUA.
  - `generarCuadriculaAleatoria(int tamanoX, int tamanoY, int numBarcos)`: Genera una cuadrícula aleatoria con barcos en posiciones aleatorias.
  - `coordenadasValidas(int x, int y)`: Verifica si las coordenadas dadas están dentro de los límites de la cuadrícula.

## 3. `CuadriculaAvanzada` (Clase Derivada de `Cuadricula`)

- **Atributos Adicionales:**

  - `factorClima` y `factorCorrientes`: Representan factores para la simulación ambiental.
- **Métodos Adicionales:**

  - `generarFactorAleatorio()`: Genera un factor aleatorio para la simulación ambiental.
  - `actualizarSimulacionAmbiental(double nuevoFactorClima, double nuevoFactorCorrientes)`: Actualiza los factores de simulación ambiental.
  - `obtenerVelocidadCorriente()`: Calcula la velocidad de la corriente en función del factor de corrientes.
  - `modificarFactorClima(double cambio)`: Modifica el factor de clima según el cambio especificado.
  - `calcularInfluenciaClimaticaEnAtaque()`: Calcula cómo el factor de clima afecta a la precisión de los ataques.
  - `mostrarEstado()`: Muestra el estado de la cuadrícula avanzada, incluyendo los factores de simulación ambiental.

## 4. `MicroGuerraBarcos` (Clase Principal)

- En el método `main`, se crea una instancia de `Cuadricula` y otra de `CuadriculaAvanzada`, se colocan barcos aleatorios y se realizan ataques mostrando el estado inicial y final de cada cuadrícula.

# Pseudocódigo

```java
EstadoCelda:
  Enumeración de los estados de una celda: AGUA, BARCO, TOCADO, HUNDIDO

Cuadricula:
  Atributos:
    - tamanioX: entero
    - tamanioY: entero
    - estadoCeldas: matriz de EstadoCelda

  Métodos:
    - Cuadricula(tamanioX: entero, tamanioY: entero): constructor
    - getTamanioX(): entero
    - getTamanioY(): entero
    - getEstadoCeldas(): matriz de EstadoCelda
    - mostrarEstado(): void
    - inicializarCuadricula(): void
    - colocarBarco(x: entero, y: entero): void
    - atacarCelda(x: entero, y: entero): void
    - verificarHundimiento(): boolean
    - obtenerEstadoCelda(x: entero, y: entero): EstadoCelda
    - mostrarTablero(): void
    - reiniciarCuadricula(): void
    - generarCuadriculaAleatoria(tamanoX: entero, tamanoY: entero, numBarcos: entero): Cuadricula
    - coordenadasValidas(x: entero, y: entero): boolean

CuadriculaAvanzada:
  Atributos adicionales:
    - factorClima: decimal
    - factorCorrientes: decimal

  Métodos adicionales:
    - CuadriculaAvanzada(tamanioX: entero, tamanioY: entero): constructor
    - generarFactorAleatorio(): decimal
    - actualizarSimulacionAmbiental(nuevoFactorClima: decimal, nuevoFactorCorrientes: decimal): void
    - obtenerVelocidadCorriente(): decimal
    - modificarFactorClima(cambio: decimal): void
    - calcularInfluenciaClimaticaEnAtaque(): decimal
    - mostrarEstado(): void

```


# Ejercicio 4: Micro Guerra de Barcos con Estrategia de IA

## 1. Clase `CuadriculaIA`

La clase `CuadriculaIA` implementa un juego de Micro Guerra de Barcos con Estrategia de IA en Java.

### 1.1. Atributos:

- `cuadricula`: Matriz de caracteres que representa la cuadrícula del juego con barcos y disparos.
- `disparosJugador`: Matriz booleana que registra los disparos del jugador.
- `disparosComputadora`: Matriz booleana que registra los disparos de la computadora.
- `random`: Instancia de la clase `Random` para generar números aleatorios.

### 1.2. Constructor (`CuadriculaIA()`):

- Inicializa las matrices y la instancia de `Random`.
- Llama al método `inicializarCuadriculas()` para colocar barcos aleatorios en la cuadrícula.

### 1.3. Métodos:

- `inicializarCuadriculas()`: Coloca aleatoriamente 5 barcos (`'B'`) en la cuadrícula.
- `mostrarCuadriculaJugador()`: Muestra la cuadrícula actual del jugador.
- `mostrarCuadriculaComputadora()`: Muestra la cuadrícula de la computadora, ocultando los barcos y mostrando los resultados de los disparos.
- `turnoJugador(int fila, int columna)`: Realiza el turno del jugador: actualiza la cuadrícula y verifica si se ha hundido algún barco.
- `turnoComputadora()`: Implementa una estrategia de IA para el turno de la computadora: realiza un disparo y ajusta la estrategia.
- `validarCoordenadas(int fila, int columna)`: Verifica si las coordenadas dadas son válidas.
- `todasLasCoordenadasHundidas()`: Verifica si todos los barcos en la cuadrícula han sido hundidos.

## 2. Clase `MicroGuerraBarcosIA`

El programa principal (`MicroGuerraBarcosIA`) permite jugar al Micro Guerra de Barcos con Estrategia de IA.

### 2.1. Método `main(String[] args)`:

- Crea instancias de las cuadrículas del jugador y de la computadora.
- Utiliza un bucle `while` para iterar hasta que el juego haya terminado.
- Permite al jugador ingresar sus coordenadas durante su turno.
- Muestra el estado actual del juego después de cada turno.
- Al final del juego, muestra el resultado final.

### 2.2. Método `juegoTerminado(CuadriculaIA cuadriculaJugador, CuadriculaIA cuadriculaComputadora)`:

- Lógica para determinar si el juego ha terminado (Todos los barcos se han hundido).

# Pseudocódigo

```java
clase CuadriculaIA:
    - cuadricula: arreglo de caracteres
    - disparosJugador: arreglo de booleanos
    - disparosComputadora: arreglo de booleanos
    - random: instancia de Random

    método CuadriculaIA():
        cuadricula = nueva matriz de 10x10
        disparosJugador = nueva matriz de 10x10
        disparosComputadora = nueva matriz de 10x10
        random = nueva instancia de Random

        inicializarCuadriculas()

    método inicializarCuadriculas():
        // Colocar aleatoriamente 5 barcos en la cuadrícula
        para i desde 1 hasta 5:
            fila = random.nextInt(10)
            columna = random.nextInt(10)
            cuadricula[fila][columna] = 'B'  // 'B' representa un barco

    método mostrarCuadriculaJugador():
        // Mostrar la cuadrícula actual del jugador
        imprimir "Cuadrícula del Jugador:"
        mostrarCuadricula(cuadricula)

    método mostrarCuadriculaComputadora():
        // Mostrar la cuadrícula de la computadora (ocultando barcos y mostrando resultados de disparos)
        imprimir "Cuadrícula de la Computadora:"
        para cada fila, columna en disparosComputadora:
            si disparosComputadora[fila][columna]:
                si cuadricula[fila][columna] == 'B':
                    imprimir 'X'  // Acertó en un barco
                sino:
                    imprimir 'O'  // Falló en alcanzar un barco
            sino:
                imprimir '~'  // Celda no disparada

    método mostrarCuadricula(cuadricula: arreglo de caracteres):
        // Método auxiliar para mostrar una cuadrícula dada
        para cada fila en cuadricula:
            para cada columna en fila:
                imprimir cuadricula[fila][columna] + " "
            imprimir nueva línea
        imprimir nueva línea

    método turnoJugador(fila: entero, columna: entero):
        // Lógica del turno del jugador, actualizar cuadrícula y verificar si se hundió algún barco
        si validarCoordenadas(fila, columna) y no disparosJugador[fila][columna]:
            disparosJugador[fila][columna] = verdadero
            si cuadricula[fila][columna] == 'B':
                imprimir "¡Has acertado en un barco!"
                // Lógica adicional para verificar si se hundió el barco
            sino:
                imprimir "Agua. No has alcanzado ningún barco."
        sino:
            imprimir "Coordenadas inválidas o ya disparaste en esta posición. Inténtalo de nuevo."

    método turnoComputadora():
        // Estrategia de IA para el turno de la computadora, realizar un disparo y adaptar la estrategia
        fila = random.nextInt(10)
        columna = random.nextInt(10)

        si no disparosComputadora[fila][columna]:
            disparosComputadora[fila][columna] = verdadero
            si cuadricula[fila][columna] == 'B':
                imprimir "¡La Computadora ha acertado en un barco!"
                // Lógica adicional para verificar si se hundió el barco
            sino:
                imprimir "La Computadora ha disparado al agua. No ha alcanzado ningún barco."
        sino:
            // Repetir el turno si ya disparó en esa posición
            turnoComputadora()

    función validarCoordenadas(fila: entero, columna: entero) -> booleano:
        retornar fila >= 0 y fila < 10 y columna >= 0 y columna < 10

    función todasLasCoordenadasHundidas() -> booleano:
        para cada fila, columna en cuadricula:
            si cuadricula[fila][columna] == 'B' y no disparosJugador[fila][columna]:
                retornar falso  // Aún hay barcos no hundidos
        retornar verdadero  // Todos los barcos han sido hundidos

// Programa principal
cuadriculaJugador = nueva instancia de CuadriculaIA
cuadriculaComputadora = nueva instancia de CuadriculaIA

// Lógica del juego
mientras no juegoTerminado(cuadriculaJugador, cuadriculaComputadora):
    // Turno del jugador
    imprimir "Turno del Jugador:"
    pedir fila al usuario
    pedir columna al usuario
    cuadriculaJugador.turnoJugador(fila, columna)

    // Turno de la computadora
    cuadriculaComputadora.turnoComputadora()

    // Mostrar el estado actual del juego
    cuadriculaJugador.mostrarCuadriculaJugador()
    cuadriculaComputadora.mostrarCuadriculaComputadora()

// Mostrar resultado final del juego
imprimir "Juego Terminado"
si cuadriculaJugador.todasLasCoordenadasHundidas():
    imprimir "¡Has ganado! Todos los barcos de la computadora se han hundido."
sino:
    imprimir "La computadora ha ganado. Todos tus barcos se han hundido."

```
