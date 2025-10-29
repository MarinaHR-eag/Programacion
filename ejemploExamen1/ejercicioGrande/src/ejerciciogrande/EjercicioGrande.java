/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciogrande;
import java.util.Scanner;

/**
 *
 * @author marin
 */
public class EjercicioGrande {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vida = 100;
        String opcionElegida = "";
        
        System.out.println("¡Comienza la batalla! Tienes " + vida + " puntos de vida");
        
        do{
            System.out.println("----- NUEVO TURNO -----");
            System.out.println("Tienes " + vida + " puntos de vida");
            
            // Generamos un monstruo con un daño aleatorio entre 5 y 25 puntos
            int danioRecibido = (int)Math.floor(Math.random()*21+5); 
            
            // El usuario escoge una de las opciones
            System.out.println("Escribe la acción que quieres realizar: atacar / defender / curar /salir");
            opcionElegida = sc.nextLine();
            
            switch(opcionElegida) {
                case "atacar": {
                    int danioAlMonstruo = atacar();
                    System.out.println("Has causado " + danioAlMonstruo + " de daño al enemigo");
                    System.out.println("El enemigo te hace " + danioRecibido + " de daño");
                    vida -= danioRecibido;
                    break;
                }
                case "defender": {
                    int danioReducido = defender(danioRecibido);
                    System.out.println("Bloqueas parte del ataque. Te han hecho " + danioReducido + " de daño");
                    vida -= danioReducido;
                    break;
                }
                case "curar": {
                    int curacion = curar();
                    vida += curacion;
                    if(vida > 100) {
                        vida = 100;
                    }
                    System.out.println("Te curas " + curacion + " puntos de vida. Vida actual " + vida);
                }
                case "salir":
                    break;
                default:
                    System.out.println("Esa opción no es válida. Intenta de nuevo.");
            }
            
        }while(vida > 0 && !opcionElegida.equals("salir"));
        
        if(vida <= 0){
            System.out.println("Has muerto.");
        }else{
            System.out.println("Fin del combate.");
        }
    }
    
    private static int atacar(){
        int danioCausado = (int)Math.floor(Math.random()*21+10); // 10-30
        return danioCausado;
    }
    
    private static int defender(int danioRecibido){
        return danioRecibido / 2;
    }
    
    private static int curar(){
        int danioCurado = (int)Math.floor(Math.random()*11+10); // 10-20
        return danioCurado;
    }
    
    
    
}
