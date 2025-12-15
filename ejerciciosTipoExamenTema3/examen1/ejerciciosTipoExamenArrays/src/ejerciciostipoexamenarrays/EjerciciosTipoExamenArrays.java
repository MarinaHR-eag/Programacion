/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciostipoexamenarrays;

import java.util.Scanner;

/**
 *
 * @author marin
 */
public class EjerciciosTipoExamenArrays {
    public static double sumaTotalRecaudacion(double[] recaudaciones){
        double suma = 0.0;
        for(int i = 0; i < recaudaciones.length; i++){
            suma += recaudaciones[i];
        }
        
        return suma;
    }
    
    public static int diaMayor(double[] recaudaciones){
        int posicionDiaMayor = 0;
        for(int i = 1; i < recaudaciones.length; i++){
            if(recaudaciones[i] > recaudaciones[posicionDiaMayor]){
                posicionDiaMayor = i;
            }
        }
        
        return posicionDiaMayor;
    }
    
    public static double recaudacionMedia(double[] recaudaciones){
        double suma = sumaTotalRecaudacion(recaudaciones);
        double media = suma / recaudaciones.length;
        
        return media;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String[] diasSemana = {"lunes", "martes", "miércoles", "jueves",
        "viernes", "sábado", "domingo"};
        double[] recaudaciones = new double[7];
        
        // Pedir al usuario las recaudaciones semanales
        for(int i = 0; i < 7; i++){
            double recaudacion;
            do{
                System.out.println("Introduzca la recaudación del " + diasSemana[i]);
                recaudacion = sc.nextDouble();
                sc.nextLine();
            }while(recaudacion < 0);
            recaudaciones[i] = recaudacion;
        }
        
        // Mostramos por pantalla la recaudación total
        double recaudacionTotal = sumaTotalRecaudacion(recaudaciones);
        System.out.println("La recaudación total es " + recaudacionTotal);
        
        // Mostramos el día con mayor recaudación
        int indiceMayorRecaudacion = diaMayor(recaudaciones);
        System.out.println("El día de mayor recaudación fue el " + diasSemana[indiceMayorRecaudacion]);
        
        // Mostramos la media de la recaudación
        double media = recaudacionMedia(recaudaciones);
        System.out.println("La recaudación media ha sido " + media);
    }    
}
