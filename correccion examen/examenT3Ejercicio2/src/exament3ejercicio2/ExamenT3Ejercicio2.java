/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exament3ejercicio2;
import java.util.Scanner;

/**
 *
 * @author marin
 */
public class ExamenT3Ejercicio2 {

    public static int buscarRegalo(String regaloBuscado, String[] regalos){
        for(int i = 0; i < regalos.length; i++){
            if(regaloBuscado.toLowerCase().equals(regalos[i].toLowerCase())){
                return i;
            }
        }
        return -1;
    }
    
    public static int actualizarAmistad(int amistadActual, int cambio){
        return amistadActual + cambio;
    }
    
    public static void main(String[] args) {
        // Declaración de variables
        Scanner sc = new Scanner(System.in);
        String[] arrayRegalos = {"Piedra", "Flor", "Pescado", "Fresa", "Gema"};
        int[] reacciones = {-5, 2, -3, 5, 10};
        int nivelAmistad = 0;
        String regalo;
        int indiceRegalo = -1;
        boolean salir = false;
        
        do{
            System.out.println("Estos son los regalos disponibles, ¿cuál quieres regalar? \n"
                    + "Escribe fin para terminar");
            for(int i = 0; i < arrayRegalos.length; i++){
                System.out.println(arrayRegalos[i]);
            }
            regalo = sc.nextLine();
            if(regalo.toLowerCase().equals("fin")){
                salir = true;
                System.out.println("Has dejado de hacer regalos. Amistad final: " + nivelAmistad);
            }
            else{
                indiceRegalo = buscarRegalo(regalo, arrayRegalos);
                if(indiceRegalo == -1){
                    System.out.println("Error, ese regalo no es válido-");
                }
                else{
                    nivelAmistad = actualizarAmistad(nivelAmistad, reacciones[indiceRegalo]);
                    if(nivelAmistad >= 20){
                        System.out.println("¡El personaje te ama!");
                        salir = true;
                    }else if(nivelAmistad <= -10){
                        System.out.println("¡El personaje te odia!");
                        salir = true;
                    }
                }
            }
        }while(!salir);
        
        
        
    }
    
}
