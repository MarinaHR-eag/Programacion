/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadorafinal;

import java.util.Scanner;

/**
 *
 * @author marin
 */
public class CalculadoraFinal {
    /**
     * @param args the command line arguments
     */
    private static int funcionPanelOpciones(String panel){
        Scanner sc = new Scanner(System.in);
        System.out.println("Panel desde una función ");
        System.out.println(panel);
        int opcionElegida = sc.nextInt();
        
        return opcionElegida;
    }
    
    private static double obtenerNumeroConDecimales(String mensaje){
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        double num = sc.nextDouble();
        
        return num;
    }
    
    private static double suma(double num1, double num2){
        System.out.println("Has elegido sumar los números ");
        double resultado = num1 + num2;
        
        return resultado;
    }
    
    private static double resta(double num1, double num2){
        System.out.println("Has elegido restar los números ");
        double resultado = num1 - num2;
        
        return resultado;
    }
    
    private static double multiplicacion(double num1, double num2){
        System.out.println("Has elegido multiplicar los números ");
        double resultado = num1 * num2;
        
        return resultado;
    }
    
    private static double division(double num1, double num2){
        System.out.println("Has elegido dividir los números ");
        double resultado = num1 / num2;
        
        return resultado;
    }
    
    private static double resto(double num1, double num2){
        System.out.println("Has elegido calcular el resto de los números ");
        double resultado = num1 % num2;
        
        return resultado;
    }
    
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
                    resultado = suma(num1, num2);
                    break;
                case 2:
                    resultado = resta(num1, num2);
                    break;
                case 3:
                    resultado = multiplicacion(num1, num2);
                    break;
                case 4: 
                    resultado = division(num1, num2);
                    break;
                case 5:
                    resultado = resto(num1, num2);
                    break;
                case 6:
                    // Pedimos los dos valores numéricos
                    num1 = obtenerNumeroConDecimales("Introduce el primer número ");
                    num2 = obtenerNumeroConDecimales("Introduce el segundo número ");
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
                opcionElegida = funcionPanelOpciones(panelOpciones);
                // opcionElegida = Integer.parseInt(sc.next()); Convertir un String a entero
            }
        }while(!salir);
    }
}
