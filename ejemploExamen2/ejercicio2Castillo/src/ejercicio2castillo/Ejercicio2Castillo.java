/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2castillo;
import java.util.Scanner;

/**
 *
 * @author marin
 */
public class Ejercicio2Castillo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Declaro las variables para controlar la partida y las inicializo
        int vida = 100;
        int oro = 0;
        int opcionElegida;

        System.out.println("¡Bienvenido al castillo!");

        do {
            System.out.println("--- Castillo encantado ---");
            System.out.print("Elige una opción: ");
            System.out.println("1. Explorar");
            System.out.println("2. Mostrar estado");
            System.out.println("3. Salir");
            
            do{
                System.out.println("Introduce la opción escogida ");
                opcionElegida = sc.nextInt();
            }while(opcionElegida < 1 || opcionElegida > 3); // Comprobamos que la opción introducida es correcta
            
            switch (opcionElegida) {
                // En el caso de que escojamos explorar el castillo, hay que generar un evento aleatorio
                case 1:
                    // En el caso de que escojamos explorar generamos un evento aleatorio, que no es más que un número entero entre 1 y 4
                    // Para ello reutilizamos la función generarNumeroAleatorio que hemos creado
                    int eventoAleatorio = generarNumeroAleatorio(1, 4);
                    switch (eventoAleatorio) {
                        // En el caso de que salga 1, te encuentras un enemigo que te quita vida, así que generamos un daño aleatorio y lo restamos a la vida
                        case 1:
                            int danioEnemigo = generarNumeroAleatorio(10, 30);
                            vida -= danioEnemigo;
                            System.out.println("Encuentras un enemigo y pierdes " + danioEnemigo + " de vida.");
                            break;
                        // En el caso de que salga 2, te encuentras una poción que te cura entre 5 y 20 puntos de vida, con un máximo de 100 puntos de vida
                        // Generamos un número aleatorio entre 5 y 20, lo sumamos a la vida y luego comprobamos que la vida no sea superior a 100
                        // Si la vida es superior a 100, le asignamos un valor de 100
                        case 2:
                            int curacion = generarNumeroAleatorio(5, 20);
                            vida += curacion;
                            if (vida > 100){
                                vida = 100;
                            }
                            System.out.println("Encuentras una poción y recuperas " + curacion + " de vida.");
                            break;
                        // En el caso de que salga 3, te encuentras una trampa y pierdes entre 5 y 15 puntos de vida
                        // Generamos un número aleatorio entre 5 y 15 y lo restamos a la vida
                        case 3:
                            int danioTrampa = generarNumeroAleatorio(5, 15);
                            vida -= danioTrampa;
                            System.out.println("Has caído en una trampa y pierdes " + danioTrampa + " de vida.");
                            break;
                        // En el caso de que salga 4, encuentras un cofre y ganas entre 10 y 50 monedas.
                        // Generamos un número aleatorio entre 10 y 50 y lo añadimos a las monedas que tenemos
                        case 4:
                            int ganancia = generarNumeroAleatorio(10, 50);
                            oro += ganancia;
                            System.out.println("Encuentras un cofre con " + ganancia + " monedas de oro.");
                            break;
                    }
                    break;
                    
                // En el caso de que escojamos la opción 2, debemos mostrar el estado de la partida. 
                // Para ello utilizamos la función mostrarEstadoPartida que hemos creado
                case 2:
                    mostrarEstadoPartida(vida, oro);
                    break;

                case 3:
                    System.out.println("Saliendo de la mazmorra...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (vida > 0 && opcionElegida != 3); // Ejecutamos el bucle mientras que la vida sea mayor que cero y no se elija la opción de salir

        // Comprobamos si hemos muerto en el castillo, y en caso de que sea así lo mostramos por pantalla
        if (vida <= 0){
            System.out.println("Moriste en el castillo, y nadie encontrará tu cuerpo jamás. ");
        }
        else{
            System.out.println("\nHas salido con " + vida + " de vida y " + oro + " monedas de oro.");
        }
    }
    
    public static int generarNumeroAleatorio(int min, int max) {
        return (int) Math.floor(Math.random() * (max - min + 1) + min);
    }

    public static void mostrarEstadoPartida(int vida, int oro) {
        System.out.println("Tu vida es igual a: " + vida + "\n"
                + "Tienes " + oro + " monedas de oro ");
    }
    
}
