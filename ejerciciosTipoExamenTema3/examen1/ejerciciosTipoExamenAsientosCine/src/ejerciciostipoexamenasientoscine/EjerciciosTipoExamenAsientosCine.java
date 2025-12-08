/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciostipoexamenasientoscine;
import java.util.Scanner;

/**
 *
 * @author marin
 */
public class EjerciciosTipoExamenAsientosCine {

    public static void mostrarSala(int[][] salaCine){
        for(int fila = 0; fila < salaCine.length; fila++){
            String filaAsientos = "";
            for(int columna = 0; columna < salaCine[fila].length; columna++){
                filaAsientos += salaCine[fila][columna] + " "; 
            }
            System.out.println(filaAsientos);
        }
    }
    
    public static boolean asientoLibre(int[][] salaCine, int fila, int columna){
        boolean asientoLibre = false;
        if(salaCine[fila][columna] == 0){
            asientoLibre = true;
        }
        return asientoLibre;
    }
    
    public static void reservarAsiento(int[][] salaCine, int fila, int columna){
        boolean asientoLibre = asientoLibre(salaCine, fila, columna);
        if(asientoLibre){
            salaCine[fila][columna] = 1;
            System.out.println("Reserva realizada");
        }else{
            System.out.println("Asiento no dispobible");
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Creamos la sala de cine
        int[][] salaCine = {
            {0, 1, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 1, 0, 0, 1},
            {0, 1, 1, 0, 0, 0, 1, 0},
            {1, 0, 0, 0, 1, 0, 0, 0}
        };
        
        // Mostramos la sala de cine antes de pedirle al usuario una fila y columna
        mostrarSala(salaCine);
        // Pedimos al usuario una fila y una columna
        int fila, columna;
        // Si la fila o la columna están fuera de rango, las volvemos a pedir
        do{
            System.out.println("Introduce la fila que quieres (de la 0 a la 4)");
            fila = sc.nextInt();
        }while(fila < 0 || fila > 4);
        
        do{
            System.out.println("Introduce la columna que quieres (de la 0 a la 7)");
            columna = sc.nextInt();
        }while(columna < 0 || columna > 7);
        
        // Llamamos al método de reservar asiento para comprobar que funciona y cumplir
        // el funcionamiento del enunciado
        reservarAsiento(salaCine, fila, columna);
        
        // Mostramos la sala de cine por pantalla
        mostrarSala(salaCine);
    }
}
