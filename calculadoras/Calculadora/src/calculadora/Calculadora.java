/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;
import java.util.Scanner;

/**
 *
 * @author marin
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declaro todas las variables que voy a utilizar
        double num1=0, num2=0;
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        int opcionElegida = 6;
        double resultado = 0;
        String panelOpciones = "Seleccione qué operación quiere realizar \n"
                + "1) Suma \n"
                + "2) Resta \n"
                + "3) Multiplicación \n"
                + "4) División \n"
                + "5) Resto \n"
                + "6) Introducir valores numéricos nuevos\n"
                + "7) Salir de la calculadora";
        
        System.out.println("Bienvenido a la calculadora del futuro");
        do{
            switch(opcionElegida){
                case 1:
                    System.out.println("Has elegido sumar los números ");
                    resultado = num1 + num2;
                    break;
                case 2:
                    System.out.println("Has elegido restar los números ");
                    resultado = num1 - num2;
                    break;
                case 3:
                    System.out.println("Has elegido multiplicar los números ");
                    resultado = num1 * num2;
                    break;
                case 4: 
                    System.out.println("Has elegido dividir los números ");
                    resultado = num1 / num2;
                    break;
                case 5:
                    System.out.println("Has elegido calcular el resto de los números ");
                    resultado = num1 % num2;
                    break;
                case 6:
                    // Pedimos los dos valores numéricos
                    System.out.println("Introduce el primer número ");
                    num1 = sc.nextDouble();

                    System.out.println("Introduce el segundo número ");
                    num2 = sc.nextDouble();
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    System.out.println("Esa opción es inválida ");
            }
            if(!salir){
                if(opcionElegida >=1 && opcionElegida <= 5){
                    System.out.println("El resultado es " + resultado);
                }
                System.out.println(panelOpciones);
                // opcionElegida = Integer.parseInt(sc.next()); Convertir un String a entero
                opcionElegida = sc.nextInt();
            }
        }while(!salir);
    }
}
