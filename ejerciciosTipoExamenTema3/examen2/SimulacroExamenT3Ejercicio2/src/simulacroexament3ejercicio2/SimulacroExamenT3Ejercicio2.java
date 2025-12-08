/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulacroexament3ejercicio2;
import java.util.Scanner;

/**
 *
 * @author marin
 */
public class SimulacroExamenT3Ejercicio2 {

    // Función para comprobar si el peso pasado como argumento está dentro de los pesos posibles
    static boolean existePeso(double[] arrayPesos, double peso) {
        // Recorremos el array de pesos y comprobamos uno a uno si coincide con el que nos han pasado como argumento
        for(int i = 0; i < arrayPesos.length; i++) {
            if (arrayPesos[i] == peso){
                return true;
            }
        }
        return false;
    }

    // Función para comprobar si cabe un objeto en la mochila
    static boolean cabeEnLaMochila(double pesoActual, double capacidad, double nuevoObjeto) {
        // Sumamos el peso del objeto nuevo al que tiene la mochila ahora mismo
        // Comprobamos si es menor o igual que la capacidad de la mochila
        return pesoActual + nuevoObjeto <= capacidad;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creamos el array de pesos
        double[] pesos = {2.0, 1.5, 3.0, 5.0, 0.5, 4.0, 2.5};

        // Pedimos al usuario que introduzca la capacidad máxima de la mochila
        System.out.print("Introduce la capacidad máxima de la mochila: ");
        double capacidad = sc.nextDouble();

        // Usamos una variable para guardar el peso actual de la mochila y el número de objetos guardados
        double pesoActual = 0;
        int objetosGuardados = 0;
        
        // Usamos una variable booleana para controlar si hay que salir del bucle
        boolean salir = false;

        while (!salir) {
            // Pedimos al usuario el peso del objeto que quiere introducir en la mochila o -1 si quiere salir
            System.out.print("Introduce el peso del objeto a guardar (o -1 para terminar): ");
            double pesoObjeto = sc.nextDouble();

            // Comprobamos si quiere salir
            if (pesoObjeto == -1){
                salir = true;
            } else{
                // Comprobamos si el peso está dentro de los admitidos
                if (!existePeso(pesos, pesoObjeto)) {
                    System.out.println("Ese objeto no existe en el conjunto permitido.");
                }
                // En el caso de que esté admitido, comprobamos si cabe en la mochila
                else if (cabeEnLaMochila(pesoActual, capacidad, pesoObjeto)) {
                    pesoActual += pesoObjeto;
                    objetosGuardados++;
                    System.out.println("Objeto guardado en la mochila. Peso actual: " + pesoActual);
                } else {
                    System.out.println("No cabe más peso en la mochila.");
                    salir = true;
                }
            }
        }

        System.out.println("Peso final en la mochila: " + pesoActual);
        System.out.println("Objetos guardados: " + objetosGuardados);
    }
}
