/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploexcepciones;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author marin
 */
public class EjemploExcepciones {
    
    static Scanner sc = new Scanner(System.in);
    
    public static int pedirNumeroEntero(){
        int num = 0;
        boolean numeroValido = false;
        
        while(!numeroValido){
            try{
                System.out.println("Introduzca un número entero: ");
                num = sc.nextInt();
                numeroValido = true;
            }catch(InputMismatchException e){
                System.out.println("Eso no es un número entero");
            }finally{
                sc.nextLine();
            }
        }
        
        return num;
    }
    
    public static int dividirNumerosEnteros(int num1, int num2){
        int result;
        try{
            result = num1/num2;
        }catch(ArithmeticException e){
            System.out.println("No se puede dividir por cero");
            result = 0;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        try{
            int num1, num2;
            num1 = pedirNumeroEntero();
            num2 = pedirNumeroEntero();
            
            int result = dividirNumerosEnteros(num1, num2);
            System.out.println("El resultado es: " + result);
        }catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getClass());
            e.printStackTrace();
        }finally{
            System.out.println("Fin del programa");
        }
    }
}
