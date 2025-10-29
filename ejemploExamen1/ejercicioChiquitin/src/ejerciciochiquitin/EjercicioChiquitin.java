/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciochiquitin;
import java.util.Scanner;

/**
 *
 * @author marin
 */
public class EjercicioChiquitin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nivel, exp;
        do{
            System.out.println("Introduce tu nivel actual (1-50)");
            nivel = sc.nextInt();
        }while(nivel < 1 || nivel > 50);
        
        do{
            System.out.println("Introduce tu experiencia actual ");
            exp = sc.nextInt();
        }while(exp < 0);
        
        int expNecesaria = nivel * 1000;
        
        if(exp >= expNecesaria){
            int expRestante = exp - expNecesaria;
            nivel++;
            System.out.println("¡Felicidades! Has subido al nivel " + nivel);
            System.out.println("Te sobran " + expRestante + " puntos de experiencia");
        }
        else {
            int expQueFalta = expNecesaria - exp;
            System.out.println("Te faltan " + expQueFalta + " puntos de experiencia para subir de nivel");
        }
    }
}
