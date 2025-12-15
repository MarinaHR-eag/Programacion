/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exament3ejercicio3;
import java.util.Scanner;
/**
 *
 * @author marin
 */
public class ExamenT3Ejercicio3 {

    public static void mostrarMapa(int[][] mapa, int fila, int columna){
        for(int i = 0; i<mapa.length; i++){
            for(int j = 0; j<mapa[i].length; j++){
                if(fila==i && columna==j){
                    System.out.print("P ");
                } else{
                    System.out.print(mapa[i][j] + " ");
                }
            }
            System.out.print("\n");
        }
    }
            
            
    public static void main(String[] args) {
        int[][] mapa = {
            {1, 1, 1, 1, 1, 1}, 
            {1, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 2, 1},
            {1, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1}
        };
        boolean fin = false;
        Scanner sc = new Scanner(System.in);
        String opcion;
        // colocamos al jugador en la posición inicial (1, 1)
        int filaActual = 1, colActual = 1;
        // Posiciones a las que se quiere mover el jugador
        int fila = 1, columna = 1;
        do{
            // Mostramos el mapa con la posición actual
            mostrarMapa(mapa, filaActual, colActual);
            do{
                System.out.println("Introduce movimiento (Wasd)");
                opcion = sc.next().toUpperCase();
            }while (!(opcion.equals("W")
                    ||opcion.equals("A")
                    ||opcion.equals("S")||
                    (opcion.equals("D"))));
            
            // Comprobamos la opción que ha introducido el usuario
            switch(opcion){
                case "W":
                    fila = filaActual - 1;
                    columna = colActual;
                    break;
                case "A":
                    fila = filaActual;
                    columna = colActual - 1;
                    break;
                case "S":
                    fila = filaActual + 1;
                    columna = colActual;
                    break;
                case "D":
                    fila = filaActual;
                    columna = colActual + 1;
                    break;
            }
            // una vez tenemos el movimiendo actualizado, comprobamos si es válido
            // Comprobamos si nos hemos salido del mapa
            if(fila < 0 || fila >= mapa.length || columna < 0 || columna >= mapa.length){
                System.out.println("No te puedes salir del mapa");
            } 
            // Ahora comprobamos si la casilla es un obstáculo
            else if(mapa[fila][columna] == 1){
                System.out.println("No puedes moverte ahí, es un obstáculo");
            }
            // Ahora comprobamos si la casilla es el tesoro
            else if(mapa[fila][columna] == 2){
                System.out.println("¡Has encontrado el tesoro, enhorabuena!");
                fin = true;
            }
            // En caso contrario, el jugador se mueve
            else{
                filaActual = fila;
                colActual = columna;
            }
        }while(!fin);
        
    }
    
}
