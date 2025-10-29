/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cazadormonedas;
import java.util.Scanner;

/**
 *
 * @author marin
 */
public class CazadorMonedas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaramos las variables necesarias
        Scanner sc = new Scanner(System.in);
        // monedas guardará las monedas que introduce el jugador en cada turno
        // monedasTotales guardará la suma de las monedas de todos los turnos
        // monedasMaximas guarda el valor más grande de monedas que se han obtenido en un turno
        int monedas = 0, monedasTotales = 0, monedasMaximas = 0;
        // turnoMaximoMonedas guarda el número de turno en el que se ha obetnido el máximo de monedas
        int turno = 0, turnoMaximasMonedas = 0;
        
        // Usamos un bucle do while para gestionar los turnos
        do{
            System.out.println("Turno " + turno);
            // Nos aseguramos que el usuario introduce una cantidad de monedas positiva o igual a 0
            do{
                System.out.println("Introduce una cantidad de monedas. 0 para terminar.");
                monedas = sc.nextInt();
            }while(monedas < 0);
            
            // Añadimos las monedas al total
            monedasTotales += monedas;
            
            // Comprobamos si hemos superado lo que teníamos guardado en el máximo, y si es así lo guardamos
            if(monedas > monedasMaximas){
                monedasMaximas = monedas;
                turnoMaximasMonedas = turno;
            }
            turno++;          
        }while(monedas > 0);
        
        // Si monedasTotales es igual a 0 implica que no se han introducido monedas en ningún momento
        if(monedasTotales > 0){
            System.out.println("Total de monedas " + monedasTotales);
            double media = (double) monedasTotales/turno;
            System.out.println("La media de monedas es " + media);
            System.out.println("Mayor cantidad de monedas: " + monedasMaximas);
            System.out.println("Turno de máximas monedas " + turnoMaximasMonedas); 
        }else{
            System.out.println("No se han introducido monedas");
        }
        
    }
    
}
