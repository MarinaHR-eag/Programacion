/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exament3ejercicio1;
import java.util.Scanner;

/**
 *
 * @author marin
 */
public class ExamenT3Ejercicio1 {

    public static boolean contieneVerdura(int verduraBuscada, int[] verduras){
        boolean verduraEncontrada = false;
        
        for(int i = 0; i < verduras.length; i++){
            if(verduras[i] == verduraBuscada){
                verduraEncontrada = true;
                return verduraEncontrada;
            }
        }
        return verduraEncontrada;
    }
    
    public static int contarVerdura(int verduraAContar, int[] verduras){
        int contador = 0;
        
        for(int i = 0; i < verduras.length; i++){
            if(verduras[i] == verduraAContar){
                contador++;
            }
        }
        return contador;
    }
    
    public static int verduraMasAbundante(int[] verduras){
        int indiceValorMaximo = 0;
        int[] aparicionesVerduras = new int[5]; // 
        
        for(int i = 0; i < 5; i++){
            aparicionesVerduras[i] = contarVerdura(i+1, verduras);
            if(aparicionesVerduras[i] > aparicionesVerduras[indiceValorMaximo]){
                indiceValorMaximo = i;
            }
        }
        
        return indiceValorMaximo + 1;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Generamos automaticamente el array
        int[] cosecha = new int[20];
        String[] verduras = {"Chirivía", "Judías verdes", "Patatas", "Zanahorias", "Puerro"};
        int numero;
        
        for(int i = 0; i < cosecha.length; i++){
            cosecha[i] = (int)(Math.random() * 5) + 1;
        }
        
        // Pedir al usuario un número entre 1 y 5
        do{
            System.out.println("Introduzca un número entre 1 y 5 ");
            numero = sc.nextInt();
        }while(numero < 1 || numero > 5);
        
        boolean verduraPresente = contieneVerdura(numero, cosecha);
        if(verduraPresente){
            System.out.println("La verdura " + verduras[numero - 1] + " está presente en la cosecha");
        }
        else{
            System.out.println("La verdura " + verduras[numero - 1] + " no está presente en la cosecha");
        }
        int numeroApariciones = contarVerdura(numero, cosecha);
        System.out.println("La verdura " + verduras[numero - 1] + " aparece " + numeroApariciones + " veces");
        
        int masAbundante = verduraMasAbundante(cosecha);
        System.out.println("La verdura más abundante del día es " + verduras[masAbundante - 1]);
    }
    
}
