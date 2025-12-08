/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulacroexament3ejercicio1;
import java.util.Scanner;

/**
 *
 * @author marin
 */
public class SimulacroExamenT3Ejercicio1 {

    // Función para mostrar los elementos de la tienda y sus precios
    public static void mostrarTienda(String[] objetos, double[] precios) {
        System.out.println("Bienvenido a la tienda, estos son nuestros productos: ");
        for (int i = 0; i < objetos.length; i++) {
            // Imprimimos cada producto junto con su precio asociado
            System.out.println(objetos[i] + ": " + precios[i] + " oro");
        }
    }

    // Función para buscar de forma secuencial si un objeto se encuentra en la tienda o no
    public static int buscarObjeto(String[] objetos , String objetoBuscado) {
        // Vamos recorriendo uno a uno los elementos de objetos y si encontramos el que buscamos,
        // devolvemos su índice. En caso contrario, devolvemos -1
        for (int i = 0; i < objetos.length; i++) {
            if (objetos[i].equals(objetoBuscado)) {
                return i;
            }
        }
        return -1;
    }

    // Función para comprobar si el usuario puede comprar un objeto con el dinero que le queda
    public static boolean puedeComprar(double oro, double precio) {
        return oro >= precio;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creamos los arrays de la tienda
        String[] objetos = {"Poción", "Antorcha", "Daga", "Escudo", "Arco", "Grimorio"};
        double[] precios = {10.0, 5.0, 25.0, 40.0, 60.0, 120.0};

        // Pedimos al usuario que introduzca una cantidad de oro inicial
        System.out.println("Introduce tu cantidad de oro inicial: ");
        double oro = sc.nextDouble();
        sc.nextLine();
        
        boolean salir = false;

        while (!salir) {
            // Mostramos los objetos de la tienda junto con sus precios
            mostrarTienda(objetos, precios);
            // Preguntamos al usuario qué objeto quiere comprar
            System.out.println("Introduce el objeto que quieres comprar, o escribe salir");
            String objetoAComprar = sc.nextLine().trim();

            // Comprobamos si el usuario ha querido salir de la aplicación
            if (objetoAComprar.equals("salir")) {
                salir = true;
            } else{
                // Buscamos el objeto en la tienda y guardamos su índice
                int pos = buscarObjeto(objetos, objetoAComprar);

                // En el caso de que no se encuentre el objeto, se muestra un mensaje por pantalla
                if (pos == -1) {
                    System.out.println("No disponemos de " + objetoAComprar);
                } else{
                    // Obtenemos el precio del producto
                    double precio = precios[pos];
                    // Comprobamos si el usuario lo puede comprar con el oro que le queda
                    if (puedeComprar(oro, precio)) {
                        oro -= precio;
                        System.out.println("Has comprado " + objetoAComprar + ". Te quedan: " + oro + " oro");
                    } else {
                        System.out.println("No tienes suficiente oro para comprar " + objetoAComprar);
                        salir = true;
                    }
                }
            }
        }

        System.out.println("Oro final: " + oro);
    }

    
    
}
