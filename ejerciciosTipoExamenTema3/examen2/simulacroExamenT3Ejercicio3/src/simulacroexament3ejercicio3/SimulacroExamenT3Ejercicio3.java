/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulacroexament3ejercicio3;
import java.util.Scanner;

/**
 *
 * @author marin
 */
public class SimulacroExamenT3Ejercicio3 {

    // Función para mostrar el mapa por pantalla
    static void mostrarMapa(int[][] mapa) {
        System.out.println("Este es el mapa del bosque: ");
        for (int i = 0; i < mapa.length; i++) {
            String fila = "";
            for (int j = 0; j < mapa[i].length; j++) {
                fila += mapa[i][j] + " ";
            }
            System.out.println(fila);
        }
    }

    // Función que comprueba si una casilla es transitable o no (es igual a 0 o no)
    static boolean esTransitable(int[][] mapa, int fila, int columna) {
        return mapa[fila][columna] == 0;
    }

    // Función que comprueba si una casilla es el tesoro (es igual a 2)
    static boolean esTesoro(int[][] mapa, int fila, int columna) {
        return mapa[fila][columna] == 2;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creamos el mapa con los datos del enunciado
        int[][] mapa = {
            {0, 1, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 2, 1},
            {0, 1, 0, 0, 0, 0}
        };
        
        // Usamos dos variables para ver por dónde va el usuario
        int filaActual = -1, columnaActual = -1;
        int fila, columna;
        
        boolean tesoroEncontrado = false;

        do{
            // Mostramos el mapa por pantalla
            mostrarMapa(mapa);

            // Validación de la fila
            do {
                System.out.print("Introduce la fila (0–4): ");
                fila = sc.nextInt();
                if (fila < 0 || fila > 4) {
                    System.out.println("Fila fuera de rango.");
                }
            } while (fila < 0 || fila > 4);

            // Validación de la columna
            do {
                System.out.print("Introduce la columna (0–5): ");
                columna = sc.nextInt();
                if (columna < 0 || columna > 5) {
                    System.out.println("Columna fuera de rango.");
                }
            } while (columna < 0 || columna > 5);

            // Comprobamos si la fila y la columna están dentro del rango accesible
            // O si no hemos hecho el primer movimiento todavía
            int margenFila = fila - filaActual;
            int margenColumna = columna - columnaActual;
            if(
                (margenFila >= -1 && margenFila <= 1 && margenColumna >= -1 && margenColumna <= 1)
                || 
                (filaActual == -1 && columnaActual == -1)
            ){
                if (!esTransitable(mapa, fila, columna)) {
                    if (esTesoro(mapa, fila, columna)) {
                        filaActual = fila;
                        columnaActual = columna;
                        System.out.println("¡Has encontrado el tesoro!");
                        tesoroEncontrado = true;
                    } else {
                        System.out.println("No puedes avanzar, hay un obstáculo.");
                    }
                } else {
                    filaActual = fila;
                    columnaActual = columna;
                    System.out.println("Avanzas a la casilla en la fila " + fila + " y la columna " + columna);
                }
            } else{
                System.out.println("Casilla fuera de alcance, actualmente te encuentras en la fila " + filaActual + " y la columna " + columnaActual);
            }
        }while(!tesoroEncontrado);
        
    }
}
